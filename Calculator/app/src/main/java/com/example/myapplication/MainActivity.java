package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private String operator;
    private StringBuffer param1, param2;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.txt_cal);
        text.setText("0");

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInput("1");
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInput("2");
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInput("3");
            }
        });
        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInput("4");
            }
        });
        findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInput("5");
            }
        });
        findViewById(R.id.btn6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInput("6");
            }
        });
        findViewById(R.id.btn6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInput("6");
            }
        });
        findViewById(R.id.btn7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInput("7");
            }
        });
        findViewById(R.id.btn8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInput("8");
            }
        });
        findViewById(R.id.btn9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInput("9");
            }
        });
        findViewById(R.id.btn0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInput("0");
            }
        });
        findViewById(R.id.btn_ac).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = (String) text.getText();
                index = str.indexOf(operator);

                if(index < 0){
                    text.setText("0");
                } else {
                    String textDisplay = str.substring(0, index);
                    text.setText(textDisplay);
                }
            }
        });
        findViewById(R.id.btn_bs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        findViewById(R.id.btn_c).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("0");
            }
        });
        findViewById(R.id.btn_plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator = "+";
                param1.append(text.getText());
                text.setText(text.getText() + " " + operator + " ");
            }
        });
        findViewById(R.id.btn_minus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator = "-";
                param1.append(text.getText());
                text.setText(text.getText() + " " + operator + " ");
            }
        });
        findViewById(R.id.btn_multi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator = "x";
                param1.append(text.getText());
                text.setText(text.getText() + " " + operator + " ");
            }
        });
        findViewById(R.id.btn_divide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator = "/";
                param1.append(text.getText());
                text.setText(text.getText() + " " + operator + " ");
            }
        });
        findViewById(R.id.btn_equal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index < 0)
                {
                    text.setText((param1.toString()));
                } else {
                    String str = (String) text.getText();
                    int i = str.indexOf(".");
                    if(i < 0) {
                        int number1 = Integer.parseInt(param1.toString().trim());
                        int number2 = Integer.parseInt(param2.toString().trim());
                        int result;
                        if(operator.equals("+")) {
                            result = number1 + number2;
                            text.setText(Integer.toString(result));
                        } else if(operator.equals("-")) {
                            result = number1 - number2;
                            text.setText(Integer.toString(result));
                        } else if(operator.equals("x")) {
                            result = number1 * number2;
                            text.setText(Integer.toString(result));
                        } else if(operator.equals("/")) {
                            float r = number1 / number2;
                            text.setText(Float.toString(r));
                        }
                    }
                }
            }
        });
        findViewById(R.id.btn_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInput(".");
            }
        });
        findViewById(R.id.btn_negative).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index < 0) {
                    if(param1.toString().contains("-")){
                        String p1 = param1.toString().substring(1, param1.length());
                        text.setText(p1.toString());
                    } else {
                        param1.append("-" + param1);
                        text.setText(param1.toString());
                    }
                } else
                {
                    if(param2.toString().contains("-")){
                        String p2 = param2.toString().substring(1, param2.length());
                        text.setText(p2.toString());
                    } else {
                        param2.append("-" + param2);
                        text.setText(param2.toString());
                    }
                }

            }
        });
    }

    public void displayInput(String s){
        if(text.getText().equals("0"))
        {
            text.setText(s);
        } else
        {
            String tmp = text.getText() + s;
            text.setText(tmp);
        }
    }

}