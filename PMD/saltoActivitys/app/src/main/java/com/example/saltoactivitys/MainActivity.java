package com.example.saltoactivitys;

import android.content.Intent;
import android.inputmethodservice.InputMethodService;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    boolean activado = false;
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


        ToggleButton modo_noche = findViewById(R.id.input_dia_noche);
        EditText input_nombre = findViewById(R.id.input_nombre);
        EditText input_edad = findViewById(R.id.input_edad);
        Spinner input_ciudad = findViewById(R.id.input_ciudades);
        RadioGroup input_genero = findViewById(R.id.input_genero);
        SwitchCompat input_notificaciones = findViewById(R.id.input_notificaciones);
        CheckBox input_terminos_condiciones = findViewById(R.id.input_terminos);
        Button button_login = findViewById(R.id.button_login);

        Intent pantalla_login = new Intent(MainActivity.this, ActivityLogin.class);

        modo_noche.setOnClickListener(e ->{
            if (modo_noche.isChecked()){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });

        button_login.setOnClickListener(e ->{

            String nombre = input_nombre.getText().toString();
            String edad = input_edad.getText().toString();
            String ciudad = input_ciudad.getSelectedItem().toString();

            int seleccionado = input_genero.getCheckedRadioButtonId();
            RadioButton opcion = findViewById(seleccionado);
            String genero = opcion.getText().toString();

            String notificaciones;
            if (input_notificaciones.isChecked()){
                notificaciones = ("Activado");
            } else {
                notificaciones = ("Deasctivado");
            }

            String terminos_condiciones;
            if (input_terminos_condiciones.isChecked()){
                terminos_condiciones = ("Aceptaste");
            } else {
                terminos_condiciones = ("No aceptaste");
            }

            pantalla_login.putExtra("nombre", nombre);
            pantalla_login.putExtra("edad", edad);
            pantalla_login.putExtra("ciudad", ciudad);
            pantalla_login.putExtra("genero", genero);
            pantalla_login.putExtra("notificaciones", notificaciones);
            pantalla_login.putExtra("terminos_condiciones", terminos_condiciones);

            startActivity(pantalla_login);
        });


    }
}