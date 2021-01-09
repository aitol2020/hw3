package com.geecktech.hw3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private String login = "Admin";
    private String passwordd = "123";
    private EditText elogin;
    private TextView sifraa;
    private EditText eparol;
    boolean isemtyy = false;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.buttom);
        sifraa = findViewById(R.id.sifra);
        elogin = findViewById(R.id.pochta);
        eparol = findViewById(R.id.parol);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "логином и паролем", Toast.LENGTH_LONG).show();
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = elogin.getText().toString();
                sifraa.setText(text);

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputname = elogin.getText().toString();
                String inputparol = eparol.getText().toString();

                if (inputname.isEmpty() || inputparol.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Заполните поле!", Toast.LENGTH_LONG).show();
                    if (inputname.isEmpty() || inputparol.isEmpty()) {
                        elogin.setError("Erorr this text");
                        eparol.setError("Erorr this text");
                        return;
                    }

                } else {
                    isemtyy = isemty(inputname, inputparol);

                    if (!isemtyy) {
                        counter--;
                        Toast.makeText(getApplicationContext(), "Неправильно ввели пароль или логин!", Toast.LENGTH_LONG).show();
                        if (inputname.isEmpty() || inputparol.isEmpty()) {
                            elogin.setError("Erorr this text");
                            eparol.setError("Erorr this text");
                            return;
                        } else {

                        }
                        sifraa.setText("Количество оставших попытка" + counter);
                        if (counter == 0) {
                            button.setEnabled(false);
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Вы успешно авторизовались!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                    }
                }

            }
        });
    }

    private boolean isemty(String name, String password) {
        if (name.equals(login) && password.equals(passwordd)) {
            return true;
        }
        return false;
    }
}