package com.example.examen1pmd;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    String sexoSeleccionado = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText inputNombre = findViewById(R.id.nombreFormulario);
        EditText inputApellidos = findViewById(R.id.apellidoFormulario);
        EditText inputEdad = findViewById(R.id.edadFormulario);
        RadioGroup inputSexo = findViewById(R.id.sexo);
        RadioButton inputSexoMasculino = findViewById(R.id.sexoM);
        RadioButton inputSexoFemenino = findViewById(R.id.sexoF);
        CheckBox inputTyC = findViewById(R.id.TyC);
        Button btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(v ->{
            String nombre = inputNombre.getText().toString().trim();
            String apellidos = inputApellidos.getText().toString().trim();
            String edad = inputEdad.getText().toString().trim();

            if (nombre.isEmpty()) {
                Toast.makeText(this, R.string.nombreVacio, Toast.LENGTH_SHORT).show();
                return;
            }
            if (apellidos.isEmpty()) {
                Toast.makeText(this, R.string.apellidoVacio, Toast.LENGTH_SHORT).show();
                return;
            }
            if (edad.isEmpty()) {
                Toast.makeText(this, R.string.edadVacio, Toast.LENGTH_SHORT).show();
                return;
            }
            if (Integer.parseInt(edad) < 16) {
                Toast.makeText(this, R.string.edadMenor, Toast.LENGTH_SHORT).show();
                return;
            }


            int IDSexoSeleccionado = inputSexo.getCheckedRadioButtonId();
            if (IDSexoSeleccionado == -1){
                sexoSeleccionado = "Ningun sexo seleccionado";
            } else {
                RadioButton idSeleccionado = findViewById(IDSexoSeleccionado);
                sexoSeleccionado = idSeleccionado.getText().toString().trim();
            }


            if (!inputTyC.isChecked()) {
                Toast.makeText(this, R.string.TyCVacio, Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, R.string.mensajeExito, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,ResumenActivity.class);
            intent.putExtra("Nombre",nombre);
            intent.putExtra("Apellidos", apellidos);
            intent.putExtra("Edad", edad);
            intent.putExtra("Sexo", sexoSeleccionado);
            startActivity(intent);

        });




    }
}