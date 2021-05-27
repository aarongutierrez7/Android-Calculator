package com.upc.eetac.dsa.calculatordsa;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
//import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

//import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    //private Button button;
    private Switch switch1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.textView);
        display.setShowSoftInputOnFocus(false);
        switch1 = findViewById(R.id.switch1);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }

    public void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos + strToAdd.length());
        }
        else{
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + strToAdd.length());
        }

    }

    public void zeroButton (View view){
        updateText("0");

    }
    public void oneButton (View view){
        updateText("1");

    }
    public void twoButton (View view){
        updateText("2");

    }
    public void threeButton (View view){
        updateText("3");

    }
    public void fourButton (View view){
        updateText("4");

    }
    public void fiveButton (View view){
        updateText("5");

    }
    public void sixButton (View view){
        updateText("6");

    }
    public void sevenButton (View view){
        updateText("7");

    }
    public void eightButton (View view){
        updateText("8");

    }
    public void nineButton (View view){
        updateText("9");

    }
    public void addButton (View view){
        updateText("+");

    }
    public void subtractButton (View view){
        updateText("-");

    }
    public void multiplyButton (View view){
        updateText("x");

    }
    public void divideButton (View view){
        updateText("/");

    }
    public void equalsButton (View view){
        String userExp = display.getText().toString();
        userExp = userExp.replaceAll("x", "*");
        Expression exp;


        if (switch1.isChecked()){

            String[] parts = userExp.split("[\\(||\\)]");
            String partsdef = String.valueOf(Math.toRadians(Integer.parseInt(parts[1])));
            if (parts[2].isEmpty()) {
                String userExpDeg = parts[0] + "(" + partsdef + ")";
                exp = new Expression(userExpDeg);
                String result = String.valueOf(exp.calculate());
                display.setText(result);
                display.setSelection(result.length());
            }
            else {
                String userExpDeg = parts[0] + "(" + partsdef + ")" + parts[2];
                exp = new Expression(userExpDeg);
                String result = String.valueOf(exp.calculate());
                display.setText(result);
                display.setSelection(result.length());
            }


        }
        else {
            exp = new Expression(userExp);
            String result = String.valueOf(exp.calculate());
            display.setText(result);
            display.setSelection(result.length());
        }

    }
    public void clearButton (View view){
        display.setText("");
    }
    public void tangentButton (View view){
        updateText("tan(");
    }
    public void cosinusButton (View view){
        updateText("cos(");

    }
    public void sinusButton (View view){
        updateText("sin(");

    }
    /*public int SwitchButton (View view){
        int switcherNumb = 0;
        if (view.equals(button.findViewById(R.id.SwitchButton)) && switcherNumb == 0 ){
            switcherNumb ++;
        }
        else {
            switcherNumb --;
        }

    return switcherNumb;
    }*/
    public void deleteButton (View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }

    public void openParenthesesButton (View view){
        updateText("(");

    }

    public void closedParenthesesButton (View view){
        updateText(")");

    }



}