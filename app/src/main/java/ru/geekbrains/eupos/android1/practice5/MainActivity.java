package ru.geekbrains.eupos.android1.practice5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatToggleButton;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Compute compute = new Compute();

    private TextView resultField, operationField;
    private  EditText numberField;
    private Button btnNull;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnSeven;
    private Button btnEigh;
    private Button btnNine;
    private Button btnAdd;
    private Button btnSubtrac;
    private Button btnMulti;
    private Button btnDiv;
    private Button btnPercent;
    private Button btnResult;
    private Button btnComma;
    private Button btnBspace;
    private Button btnClear;
    private ToggleButton toggleButton;

    private DecimalFormat decimalFormat = new DecimalFormat("#.#######");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView ();
        initLister ();
        this.setTitle("Калькулятор");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("compute", (Parcelable) compute);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        compute = savedInstanceState.getParcelable("compute");
        resultField.setText(String.format("id", compute.getValueOne()));
        operationField.setText(String.format("id", compute.getOp()));
        numberField.setText(String.format("id", compute.getValueTwo()));
    }

    private void initLister() {
        btnNull.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEigh.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnComma.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnMulti.setOnClickListener(this);
        btnResult.setOnClickListener(this);
        btnSubtrac.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnBspace.setOnClickListener(this);
        btnPercent.setOnClickListener(this);
        toggleButton.setOnClickListener(this);
    }

    private void initView() {
        resultField = findViewById(R.id.resultField);
        numberField = findViewById(R.id.numberField);
        operationField =  findViewById(R.id.operationField);
        btnNull = findViewById(R.id.btnNull);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEigh = findViewById(R.id.btnEigh);
        btnNine = findViewById(R.id.btnNine);
        btnAdd = findViewById(R.id.btnAdd);
        btnComma = findViewById(R.id.btnComma);
        btnDiv = findViewById(R.id.btnDiv);
        btnMulti = findViewById(R.id.btnMulti);
        btnClear = findViewById(R.id.btnClear);
        btnResult = findViewById(R.id.btnResult);
        btnSubtrac = findViewById(R.id.btnSubtrac);
        btnBspace = findViewById(R.id.btnBspace);
        btnPercent = findViewById(R.id.btnPercent);
        toggleButton = findViewById(R.id.toggleButton);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnNull:
            case R.id.btnOne:
            case R.id.btnTwo:
            case R.id.btnThree:
            case R.id.btnFour:
            case R.id.btnFive:
            case R.id.btnSix:
            case R.id.btnSeven:
            case R.id.btnEigh:
            case R.id.btnNine:
            case R.id.btnComma:
                Button button = findViewById(view.getId());
                numberField.append(button.getText().toString());
                break;
            case R.id.btnAdd:
                compute.setOp("+");
                inputNumb();
                break;
            case R.id.btnSubtrac:
                compute.setOp("-");
                inputNumb();
                break;
            case R.id.btnMulti:
                compute.setOp("*");
                inputNumb();
                break;
            case R.id.btnDiv:
                compute.setOp("/");
                inputNumb();
                break;
            case R.id.btnResult:
                compute.calculation(Double.parseDouble(numberField.getText().toString()));
                resultField.setText(decimalFormat.format(compute.getValueOne()));
                numberField.setText("");
                operationField.setText("");
                break;
            case R.id.btnClear:
                resultField.setText("");
                numberField.setText("");
                operationField.setText("");
                compute.setValueOne(Double.NaN);
                compute.setValueTwo(Double.NaN);
                break;
            case R.id.btnBspace:
                if(numberField.getText().length()>0)
                    numberField.setText(numberField.getText().subSequence(0,numberField.getText().length()-1));
                break;
            case R.id.toggleButton:
                if
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }

    private void inputNumb(){
        compute.setValueOne(Double.parseDouble(numberField.getText().toString())); ;
        operationField.setText(compute.getOp());
        resultField.setText(decimalFormat.format(compute.getValueOne()));
        numberField.setText("");
    }
}