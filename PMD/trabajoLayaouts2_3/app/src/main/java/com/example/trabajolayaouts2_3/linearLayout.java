package com.example.trabajolayaouts2_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class linearLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_linear_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button botonFrame = findViewById(R.id.buttonFrame);
        Button botonTable = findViewById(R.id.buttonTable);
        Button botonConstraint = findViewById(R.id.buttonConstraint);

        Intent pantallaFrame = new Intent(linearLayout.this, frameLayout.class);
        Intent pantallaTable = new Intent(linearLayout.this, tableLayout.class);
        Intent pantallaConstraint = new Intent(linearLayout.this, constraintLayout.class);

        botonFrame.setOnClickListener(v -> startActivity(pantallaFrame));
        botonTable.setOnClickListener(v -> startActivity(pantallaTable));
        botonConstraint.setOnClickListener(v -> startActivity(pantallaConstraint));
    }
}