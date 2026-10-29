package com.example.saltoactivitys;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent info_formulario = getIntent();

        String nombre = info_formulario.getStringExtra("nombre");
        String edad = info_formulario.getStringExtra("edad");
        String ciudad = info_formulario.getStringExtra("ciudad");
        String genero = info_formulario.getStringExtra("genero");
        String notificaciones = info_formulario.getStringExtra("notificaciones");
        String terminos_condiciones = info_formulario.getStringExtra("terminos_condiciones");

        TextView txtNombre = findViewById(R.id.texto_nombre);
        TextView txtEdad = findViewById(R.id.texto_edad);
        TextView txtCiudad = findViewById(R.id.texto_ciudad);
        TextView txtGenero = findViewById(R.id.texto_genero);
        TextView txtNotificaciones = findViewById(R.id.texto_notificaciones);
        TextView txtTC = findViewById(R.id.texto_tc);

        txtNombre.append(nombre);
        txtEdad.append(edad);
        txtCiudad.append(ciudad);
        txtGenero.append(genero);
        txtNotificaciones.append(notificaciones);
        txtTC.append(terminos_condiciones);

        Button button_logout = findViewById(R.id.button_logout);

        Intent pantalla_formulario = new Intent(ActivityLogin.this, MainActivity.class);
        button_logout.setOnClickListener(e ->{
            startActivity(pantalla_formulario);
        });



    }
}