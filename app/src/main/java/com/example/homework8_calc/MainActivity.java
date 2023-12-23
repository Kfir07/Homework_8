package com.example.homework8_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public Button multiplier,divider,plus,minus,equals, reset,point, minusPlus;
    public EditText screen;
    public boolean firstOrSecond;
    public Button currentDigit;
    public int digit;
    public String textString="";
    public boolean beforeDot = true;
    public int afterDotCounter = 1;
    public double firstValue,secondValue;
    public Button currentAction;
    public String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstValue=0;
        secondValue=0;
        firstOrSecond = true;
        multiplier = (Button) findViewById(R.id.multiplier);
        minusPlus = (Button) findViewById(R.id.minusPlus);
        divider = (Button) findViewById(R.id.divider);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        equals = (Button) findViewById(R.id.equals);
        reset = (Button) findViewById(R.id.reset);
        point = (Button) findViewById(R.id.point);
        screen = (EditText) findViewById(R.id.screen);
        multiplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstValue == 0)
                    Toast.makeText(MainActivity.this, "Invalid argument", Toast.LENGTH_LONG).show();
                else {
                    if (currentAction != null)
                        Toast.makeText(MainActivity.this, "Invalid argument", Toast.LENGTH_LONG).show();
                    else {
                        beforeDot = true;
                        afterDotCounter = 1;
                        currentAction = multiplier;
                        firstOrSecond = false;
                    }
                }
            }
        });
        divider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstValue == 0)
                    Toast.makeText(MainActivity.this, "Invalid argument", Toast.LENGTH_LONG).show();
                else {
                    if (currentAction != null)
                        Toast.makeText(MainActivity.this, "Invalid argument", Toast.LENGTH_LONG).show();
                    else {
                        beforeDot = true;
                        afterDotCounter = 1;
                        currentAction = divider;
                        firstOrSecond = false;
                    }
                }
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstValue == 0)
                    Toast.makeText(MainActivity.this, "Invalid argument", Toast.LENGTH_LONG).show();
                else {
                    if (currentAction != null)
                        Toast.makeText(MainActivity.this, "Invalid argument", Toast.LENGTH_LONG).show();
                    else {
                        beforeDot = true;
                        afterDotCounter = 1;
                        currentAction = plus;
                        firstOrSecond = false;
                    }
                }
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstValue == 0)
                    Toast.makeText(MainActivity.this, "Invalid argument", Toast.LENGTH_LONG).show();
                else {
                    if (currentAction != null)
                        Toast.makeText(MainActivity.this, "Invalid argument", Toast.LENGTH_LONG).show();
                    else {
                        beforeDot = true;
                        afterDotCounter = 1;
                        currentAction = minus;
                        firstOrSecond = false;
                    }
                }
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentAction == null)
                    Toast.makeText(MainActivity.this, "Invalid argument", Toast.LENGTH_LONG).show();
                else {
                    beforeDot = true;
                    afterDotCounter = 1;
                    screen.getText().clear();
                    double textInt = ExecuteAction();
                    textString = String.valueOf(textInt);
                    screen.setText(textString);
                    firstValue = ExecuteAction();
                    secondValue = 0;
                    currentAction = null;
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstValue = 0;
                secondValue = 0;
                beforeDot = true;
                afterDotCounter = 1;
                currentAction = null;
                firstOrSecond = true;
                screen.getText().clear();
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beforeDot = false;
            }
        });
        minusPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstOrSecond){
                    firstValue *= -1;
                    screen.setText(Double.toString(firstValue));}
                else {
                    secondValue *= -1;
                    screen.setText(Double.toString(secondValue));
                }
            }
        });
    }
    public void onClick(View view){
        currentDigit = (Button)view;
        value = (String) currentDigit.getText();
        digit = FindDigit();
        if(firstOrSecond){
            if (firstValue<0)
                digit = -digit;
            if (firstValue== 0) {
                if (beforeDot)
                    firstValue = digit;
                else {
                    firstValue = digit * 0.1;
                    afterDotCounter++;
                }
            }
            else {
                if (beforeDot)
                    firstValue = (firstValue * 10) + digit;
                else {
                    firstValue += digit * Math.pow(0.1, afterDotCounter);
                    afterDotCounter++;
                }
            }
            screen.setText(Double.toString(firstValue));
        }
        else{
            if (secondValue<0)
                digit = -digit;
            if (secondValue==0) {
                if (beforeDot)
                    secondValue = digit;
                else {
                    secondValue = digit * 0.1;
                    afterDotCounter++;
                }
            }
            else {
                if (beforeDot)
                    secondValue = (secondValue * 10) + digit;
                else {
                    secondValue += digit * Math.pow(0.1, afterDotCounter);
                    afterDotCounter++;
                }
            }
            screen.setText(Double.toString(secondValue));
        }
    }
    public double ExecuteAction(){
        if (currentAction==divider){
            return firstValue/secondValue;
        }
        if (currentAction==multiplier){
            return firstValue*secondValue;
        }
        if (currentAction==plus){
            return firstValue+secondValue;
        }
        if (currentAction==minus){
            return firstValue-secondValue;
        }
        return Double.parseDouble(null);
    }
    public int FindDigit(){
        if (value.equals("0"))
            return 0;
        else if (value.equals("1"))
            return 1;
        else if (value.equals("2"))
            return 2;
        else if (value.equals("3"))
            return 3;
        else if (value.equals("4"))
            return 4;
        else if (value.equals("5"))
            return 5;
        else if (value.equals("6"))
            return 6;
        else if (value.equals("7"))
            return 7;
        else if (value.equals("8"))
            return 8;
        else if (value.equals("9"))
            return 9;
        return -1;
    }

}