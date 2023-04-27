package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Boolean isFlagNotNull = true;
    EditText editCiferblat;
    String operator = "", oldNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editCiferblat = findViewById(R.id.editCiferblat);
    }

    @SuppressLint("NonConstantResourceId")
    public void clickNumber(View view) {
        if (isFlagNotNull){
            editCiferblat.setText("");
            isFlagNotNull = false;
        }

        String number = editCiferblat.getText().toString();
        switch (view.getId()){
            case R.id.But7:
                if (zeroSolo(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number+"7"; break;

            case R.id.But6:
                if (zeroSolo(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number+"6"; break;

            case R.id.But5:
                if (zeroSolo(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number+"5"; break;

            case R.id.But4:
                if (zeroSolo(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number+"4"; break;

            case R.id.But3:
                if (zeroSolo(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number+"3"; break;

            case R.id.But2:
                if (zeroSolo(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number+"2"; break;

            case R.id.But1:
                if (zeroSolo(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number+"1"; break;

            case R.id.But8:
                if (zeroSolo(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number+"8"; break;

            case R.id.But9:
                if (zeroSolo(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number+"9"; break;

            case R.id.ButNull:
                if (zeroSolo(number) && (number.length() == 1)){
                    number = "0";
                } else number = number+"0";
                break;

            case R.id.ButDot:
                if(dotIsPresent(number)){
                }
                else if (zeroSolo(number)) {
                    number = "0.";
                }
                else { number = number+"."; } break;

            case R.id.ButPlusMinus:
                if (numberIsNull(number)){
                    number = "0";
                } else {
                    if (minusIsPresent(number)) {
                        number = number.substring(1);
                    } else {
                        number = "-" + number;
                    }
                }
                break;
        }
        editCiferblat.setText(number);
    }

    private boolean zeroSolo(String number) {
        if (number.equals("")){
            return true;
        }
        return number.charAt(0) == '0';
    }

    private boolean numberIsNull(String number) {
        return (number.equals("0")) || (number.equals(""));
    }

    public Boolean dotIsPresent(String number) {
        return number.contains(".");
    }

    public Boolean minusIsPresent(@NonNull String number) {
        return number.charAt(0) == '-';
    }

    @SuppressLint("NonConstantResourceId")
    public void operation(View view) {
        isFlagNotNull = true;
        oldNumber = editCiferblat.getText().toString();

        switch (view.getId()){
            case R.id.ButDel: operator="/"; break;
            case R.id.ButMinus: operator="-"; break;
            case R.id.ButPlus: operator="+"; break;
            case R.id.ButUmnoz: operator="*"; break;
        }
    }

    @SuppressLint("SetTextI18n")
    public void result(View view) {
        String newNumber = editCiferblat.getText().toString();
        double result = 0.0;

        switch (operator){
            case "-": result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber); break;
            case "+": result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber); break;
            case "/": result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber); break;
            case "*": result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber); break;
        }
        editCiferblat.setText(result+"");
    }

    public void acClick(View view) {
        editCiferblat.setText("0");
        isFlagNotNull = true;
    }

    @SuppressLint("SetTextI18n")
    public void clickPercent(View view) {
        if (Objects.equals(operator, "")){
            String number = editCiferblat.getText().toString();
            double temp = Double.parseDouble(number)/100;
            number = String.valueOf(temp);
            editCiferblat.setText(number);
        } else {
            double result = 0.0;
            String newNumber = editCiferblat.getText().toString();
            switch (operator){
                case "+": result = Double.parseDouble(oldNumber) + Double.parseDouble(oldNumber) * Double.parseDouble(newNumber)/100;
                    break;
                case "-": result = Double.parseDouble(oldNumber) - Double.parseDouble(oldNumber) * Double.parseDouble(newNumber)/100;
                    break;
                case "*": result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber)/100;
                    break;
                case "/": result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber)*100;
                    break;
            }
            editCiferblat.setText(result+"");
            operator = "";
        }
    }

    public void sqRt(View view) {
        if (Objects.equals(operator, "")){
            String number = editCiferblat.getText().toString();
            double temp = Double.parseDouble(number);
            number = String.valueOf(Math.sqrt(temp));
            editCiferblat.setText(number);
        }
    }

    public void oneDelX(View view) {
        if (Objects.equals(operator, "")){
            String number = editCiferblat.getText().toString();
            double temp = 1 / Double.parseDouble(number);
            number = String.valueOf(temp);
            editCiferblat.setText(number);
        }
    }
}

