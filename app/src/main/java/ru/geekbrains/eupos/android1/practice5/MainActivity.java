package ru.geekbrains.eupos.android1.practice5;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.text.DecimalFormat;

public class MainActivity extends BaseActivity implements View.OnClickListener  {

    private static final String PREF_NAME = "key_pref";
    private static final String PREF_THEME_KEY = "key_pref_theme";

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
        setTheme(getAppTheme());
        setContentView(R.layout.activity_main);
        initView ();
        initLister ();
        this.setTitle("Калькулятор");
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

    @SuppressLint("NonConstantResourceId")
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
 /*           case R.id.toggleButton:
                // включена ли кнопка
                boolean on = ((ToggleButton) view).isChecked();
                if (on) {
                    // действия если включена

                } else {
                    // действия, если выключена

                }*/
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
        recreate();
    }

    private void inputNumb(){
        compute.setValueOne(Double.parseDouble(numberField.getText().toString())); ;
        operationField.setText(compute.getOp());
        resultField.setText(decimalFormat.format(compute.getValueOne()));
        numberField.setText("");
    }

    protected void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(PREF_THEME_KEY, codeStyle);
        editor.apply();
    }

    protected int getAppTheme() {
        SharedPreferences sharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        return sharedPref.getInt(PREF_THEME_KEY,R.style.AppThemeLight);
    }
}