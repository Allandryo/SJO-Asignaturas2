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

        TextView texto_bienvenida = findViewById(R.id.texto_bienvenida);

        texto_bienvenida.setText("Bienvenido " + nombre + ", Tienes " + edad + " años y vives en " + ciudad +".");

        Button button_logout = findViewById(R.id.button_logout);

        Intent pantalla_formulario = new Intent(ActivityLogin.this, MainActivity.class);
        button_logout.setOnClickListener(e ->{
            startActivity(pantalla_formulario);
        });



    }
}