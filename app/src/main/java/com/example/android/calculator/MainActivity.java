package com.example.android.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;
    EditText first;
    EditText second;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;

    TextView result;

    String oper = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        first = (EditText) findViewById(R.id.first);
        second = (EditText) findViewById(R.id.second);
        result = (TextView) findViewById(R.id.result);
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        float num1 = 0;
        float num2 = 0;
        float result1 = 0;

        //проверяем не пустые ли поля
        if (TextUtils.isEmpty(first.getText().toString())
                || TextUtils.isEmpty(second.getText().toString())) {
            return;
        }
        //заполняем переменные
        num1 = Float.parseFloat(first.getText().toString());
        num2 = Float.parseFloat(second.getText().toString());
        //определяем нажатую кнопку
        switch (view.getId()) {
            case R.id.btnAdd:
                oper = "+";
                result1 = num1 + num2;
                break;
            case R.id.btnSub:
                oper = "-";
                result1 = num1 - num2;
                break;
            case R.id.btnMult:
                oper = "*";
                result1 = num1 * num2;
                break;
            case R.id.btnDiv:
                oper = "/";
                result1 = num1 / num2;
                break;
            default:
                break;
        }
        //выводим результат
        result.setText(num1 + " " + oper + " " + num2 + " = " + result1);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_RESET_ID, 0, "Reset");
        menu.add(0, MENU_QUIT_ID, 0, "Quit");
        return super.onCreateOptionsMenu(menu);
    }

    // обработка нажатий на пункты меню
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_RESET_ID:
                // очищаем поля
                first.setText("");
                second.setText("");
                result.setText("");
                break;
            case MENU_QUIT_ID:
                // выход из приложения
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}