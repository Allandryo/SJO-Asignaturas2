package com.example.trabajolayaouts2_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class tableLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_table_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ConstraintLayout main = findViewById(R.id.main);

        Button boton1 = findViewById(R.id.buttonTable1);
        Button boton2 = findViewById(R.id.buttonTable2);
        Button boton3 = findViewById(R.id.buttonTable3);
        Button boton4 = findViewById(R.id.buttonTable4);
        Button boton5 = findViewById(R.id.buttonTable5);
        Button botonConstraint = findViewById(R.id.buttonConstraint);

        boton1.setOnClickListener(e ->{
            main.setBackgroundResource(R.color.beige);
        });
        boton2.setOnClickListener(e ->{
            main.setBackgroundResource(R.color.blue);
        });
        boton3.setOnClickListener(e ->{
            main.setBackgroundResource(R.color.pink);
        });
        boton4.setOnClickListener(e ->{
            main.setBackgroundResource(R.color.yellow);
        });
        boton5.setOnClickListener(e ->{
            main.setBackgroundResource(R.color.grey);
        });

        Intent pantallaConstraint = new Intent(tableLayout.this, constraintLayout.class);

        botonConstraint.setOnClickListener(v ->{
            startActivity(pantallaConstraint);
        });
    }
}
