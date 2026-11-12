package com.example.examen1pmd;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResumenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_resumen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView nombre = findViewById(R.id.nombreUsuario);
        TextView apellidos = findViewById(R.id.apellidoUsuario);
        TextView edad = findViewById(R.id.edadUsuario);
        TextView sexo = findViewById(R.id.sexoUsuario);
        Button Volver = findViewById(R.id.btnVolver);

        Intent intent = getIntent();
        String Nombre = intent.getStringExtra("Nombre");
        String Apellidos = intent.getStringExtra("Apellidos");
        String Edad = intent.getStringExtra("Edad");
        String Sexo = intent.getStringExtra("Sexo");

        nombre.setText(getString(R.string.nombre, Nombre));
        apellidos.setText(getString(R.string.apellido, Apellidos));
        edad.setText(getString(R.string.edad, Edad));
        sexo.setText(getString(R.string.sexo, Sexo));

        Volver.setOnClickListener(v ->{
            Intent formulario = new Intent(ResumenActivity.this, MainActivity.class);
            startActivity(formulario);
        });

    }
}