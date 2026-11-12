package com.example.trabajolayout2_4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResumenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.resumenMain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Obtener datos del Intent
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("NOMBRE");
        String email = intent.getStringExtra("EMAIL");
        String sexo = intent.getStringExtra("SEXO");

        // Referencias a los TextViews
        TextView txtNombre = findViewById(R.id.txtResumenNombre);
        TextView txtEmail = findViewById(R.id.txtResumenEmail);
        TextView txtSexo = findViewById(R.id.txtResumenSexo);
        Button botonVolver = findViewById(R.id.botonVolver);

        // Asignar los valores usando los formatos definidos en strings.xml
        txtNombre.setText(getString(R.string.resumenNombre, nombre != null ? nombre : ""));
        txtEmail.setText(getString(R.string.resumenEmail, email != null ? email : ""));
        txtSexo.setText(getString(R.string.resumenSexo, sexo != null ? sexo : ""));

        // Botón para regresar a MainActivity mediante Intent
        botonVolver.setOnClickListener(v -> {
            Intent intentVolver = new Intent(ResumenActivity.this, MainActivity.class);
            startActivity(intentVolver);
        });
    }
}
