package com.example.trabajolayout2_4;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    static boolean modoOscuroActivo = false;

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

        View mainLayout = findViewById(R.id.main);
        Button botonModoOscuro = findViewById(R.id.botonModoOscuro);
        Button botonRegistro = findViewById(R.id.botonRegistro);

        TextView titulo = findViewById(R.id.tituloFormulario);
        TextView sexo = findViewById(R.id.labelSexo);
        TextView pie = findViewById(R.id.pieFormulario);
        CheckBox terminos = findViewById(R.id.input_terminos);
        RadioGroup inputGenero = findViewById(R.id.input_genero);
        RadioButton opcionHombre = findViewById(R.id.opcionHombre);
        RadioButton opcionMujer = findViewById(R.id.opcionMujer);

        EditText inputNombre = findViewById(R.id.inputNombre);
        EditText inputCorreo = findViewById(R.id.inputCorreo);
        EditText inputContra = findViewById(R.id.inputContraseña);
        EditText inputConfirmar = findViewById(R.id.inputConfirmarContraseña);

        botonRegistro.setOnClickListener(v -> {
            String nombre = inputNombre.getText().toString().trim();
            String correo = inputCorreo.getText().toString().trim();
            String contra = inputContra.getText().toString();
            String confirmar = inputConfirmar.getText().toString();

            // 1. Todos los inputs de texto deben estar rellenos
            if (nombre.isEmpty()) {
                Toast.makeText(this, R.string.usuarioVacio, Toast.LENGTH_SHORT).show();
                return;
            }
            if (correo.isEmpty()) {
                Toast.makeText(this, R.string.correoVacio, Toast.LENGTH_SHORT).show();
                return;
            }
            if (contra.isEmpty()) {
                Toast.makeText(this, R.string.contraVacia, Toast.LENGTH_SHORT).show();
                return;
            }
            if (confirmar.isEmpty()) {
                Toast.makeText(this, R.string.confirmarVacia, Toast.LENGTH_SHORT).show();
                return;
            }

            // 2. El correo debe contener un arroba
            if (!correo.contains("@")) {
                Toast.makeText(this, R.string.correoInvalido, Toast.LENGTH_SHORT).show();
                return;
            }

            // 3. La contraseña debe tener al menos 7 caracteres
            if (contra.length() < 7) {
                Toast.makeText(this, R.string.contraCorta, Toast.LENGTH_SHORT).show();
                return;
            }

            // 4. La confirmación debe ser idéntica a la contraseña
            if (!contra.equals(confirmar)) {
                Toast.makeText(this, R.string.contraNoCoincide, Toast.LENGTH_SHORT).show();
                return;
            }

            // 5. Debe haber al menos un radio seleccionado
            int idRadioSeleccionado = inputGenero.getCheckedRadioButtonId();
            if (idRadioSeleccionado == -1) {
                Toast.makeText(this, R.string.sexoNoSeleccionado, Toast.LENGTH_SHORT).show();
                return;
            }
            RadioButton radioSeleccionado = findViewById(idRadioSeleccionado);
            String sexoSeleccionado = radioSeleccionado.getText().toString();

            // 6. El checkbox debe estar marcado
            if (!terminos.isChecked()) {
                Toast.makeText(this, R.string.terminosNoAceptados, Toast.LENGTH_SHORT).show();
                return;
            }

            // Todas las validaciones superadas: pasar a ResumenActivity
            Intent intent = new Intent(MainActivity.this, ResumenActivity.class);
            intent.putExtra("NOMBRE", nombre);
            intent.putExtra("EMAIL", correo);
            intent.putExtra("SEXO", sexoSeleccionado);
            startActivity(intent);
        });

        botonModoOscuro.setOnClickListener(v -> {
            if (modoOscuroActivo) {
                // --- CAMBIAR A MODO CLARO ---
                mainLayout.setBackgroundColor(getColor(R.color.white));

                int colorTextoClaro = getColor(R.color.black);
                int hintColorClaro = Color.GRAY;

                titulo.setTextColor(colorTextoClaro);
                sexo.setTextColor(colorTextoClaro);
                pie.setTextColor(colorTextoClaro);
                terminos.setTextColor(colorTextoClaro);
                opcionHombre.setTextColor(colorTextoClaro);
                opcionMujer.setTextColor(colorTextoClaro);

                inputNombre.setTextColor(colorTextoClaro);
                inputNombre.setHintTextColor(hintColorClaro);
                inputCorreo.setTextColor(colorTextoClaro);
                inputCorreo.setHintTextColor(hintColorClaro);
                inputContra.setTextColor(colorTextoClaro);
                inputContra.setHintTextColor(hintColorClaro);
                inputConfirmar.setTextColor(colorTextoClaro);
                inputConfirmar.setHintTextColor(hintColorClaro);

                // Botón vuelve a fondo oscuro con texto claro
                botonModoOscuro.setBackgroundTintList(getColorStateList(R.color.black));
                botonModoOscuro.setTextColor(getColor(R.color.white));
                botonModoOscuro.setText("Modo Oscuro");

                modoOscuroActivo = false;
            } else {
                mainLayout.setBackgroundColor(getColor(R.color.grey));

                int colorTextoOscuro = getColor(R.color.white);
                int hintColorOscuro = getColor(R.color.lgrey);

                titulo.setTextColor(colorTextoOscuro);
                sexo.setTextColor(colorTextoOscuro);
                pie.setTextColor(colorTextoOscuro);
                terminos.setTextColor(colorTextoOscuro);
                opcionHombre.setTextColor(colorTextoOscuro);
                opcionMujer.setTextColor(colorTextoOscuro);

                inputNombre.setTextColor(colorTextoOscuro);
                inputNombre.setHintTextColor(hintColorOscuro);
                inputCorreo.setTextColor(colorTextoOscuro);
                inputCorreo.setHintTextColor(hintColorOscuro);
                inputContra.setTextColor(colorTextoOscuro);
                inputContra.setHintTextColor(hintColorOscuro);
                inputConfirmar.setTextColor(colorTextoOscuro);
                inputConfirmar.setHintTextColor(hintColorOscuro);

                botonModoOscuro.setBackgroundTintList(getColorStateList(R.color.white));
                botonModoOscuro.setTextColor(getColor(R.color.black));
                botonModoOscuro.setText("Modo Claro");

                modoOscuroActivo = true;
            }
        });
    }
}
