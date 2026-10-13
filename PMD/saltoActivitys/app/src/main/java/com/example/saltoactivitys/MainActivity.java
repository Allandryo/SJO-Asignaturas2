package com.example.saltoactivitys;

import android.content.Intent;
import android.inputmethodservice.InputMethodService;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button_login = findViewById(R.id.button_login);

        button_login.setOnClickListener(e ->{
            EditText input_nombre = findViewById(R.id.input_nombre);
            String nombre = input_nombre.getText().toString();

            EditText input_edad = findViewById(R.id.input_edad);
            String edad = input_edad.getText().toString();


            EditText input_ciudad = findViewById(R.id.input_ciudad);
            String ciudad = input_ciudad.getText().toString();

            Intent pantalla_login = new Intent(MainActivity.this, ActivityLogin.class);
            pantalla_login.putExtra("nombre", nombre);
            pantalla_login.putExtra("edad", edad);
            pantalla_login.putExtra("ciudad", ciudad);
            startActivity(pantalla_login);
        });


    }
}