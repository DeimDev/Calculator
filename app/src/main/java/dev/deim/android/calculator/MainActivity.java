package dev.deim.android.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private double firstOperand = 0;
    private String operation = "";


    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.edit_text);
    }

    public void calcOnClick(View view) {
        Button butt = (Button) view;
        if (butt.getId() == R.id.butt_0 && mEditText.getText().toString().equals("0")) return;
        if (mEditText.getText().toString().equals("0") && butt.getId() != R.id.butt_point) {
            mEditText.setText(butt.getText());
            return;
        }
        mEditText.append(butt.getText());
    }

    public void funcOnClick(View view) {
        Button butt = (Button) view;
        switch (butt.getId()) {
            case R.id.butt_ac:
                mEditText.setText("0");
                firstOperand = 0;
                double secondOperand;
                operation = "";
                break;
            case R.id.butt_del:
                mEditText.setText(mEditText.getText().toString().substring(0, (mEditText.getText().length() - 1)));
                break;
            case R.id.butt_div:
                firstOperand = Double.parseDouble(mEditText.getText().toString());
                mEditText.setText("0");
                operation = "/";
                break;
            case R.id.butt_mul:
                firstOperand = Double.parseDouble(mEditText.getText().toString());
                mEditText.setText("0");
                operation = "*";
                break;
            case R.id.butt_add:
                firstOperand = Double.parseDouble(mEditText.getText().toString());
                mEditText.setText("0");
                operation = "+";
                break;
            case R.id.butt_dim:
                firstOperand = Double.parseDouble(mEditText.getText().toString());
                mEditText.setText("0");
                operation = "-";
                break;
            case R.id.butt_enter:
                secondOperand = Double.parseDouble(mEditText.getText().toString());
                double result = calculate(operation, firstOperand, secondOperand);
                mEditText.setText(String.format(Locale.getDefault(), "%f", result));
                break;
        }

    }

    private double calculate(String oper, double first, double second) {
        switch (oper) {
            case "/":
                return first / second;
            case "*":
                return first * second;
            case "+":
                return first + second;
            case "-":
                return first - second;
        }
        return 0;
    }
}
