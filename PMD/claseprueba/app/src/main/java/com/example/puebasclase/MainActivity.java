package com.example.puebasclase;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public boolean mod = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            Button button1 = findViewById(R.id.button1);
            TextView nombre = findViewById(R.id.nombre);
            ImageView imagenAndroid = findViewById(R.id.imagenAndroid);

            button1.setOnClickListener(v1 -> {
                if (mod){
                    button1.setText(R.string.button);
                    button1.setBackgroundResource(R.color.white);
                    nombre.setText(R.string.name);
                    mod = false;
                } else {
                    button1.setText(R.string.clickedButton);
                    button1.setBackgroundResource(R.color.black);
                    nombre.setText(R.string.bienvenido);
                    mod = true;
                }

            });
            return insets;
        });
    }
}