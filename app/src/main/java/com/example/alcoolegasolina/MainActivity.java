package com.example.alcoolegasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editAlcool, editGasosa;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Edit Inputs
        editAlcool      =   findViewById(R.id.editAlcool);
        editGasosa      =   findViewById(R.id.editGasosa);

        // TextView
        txtResultado    =   findViewById(R.id.txtResultado);
    }

    public void calcular(View view) {
        String precoAlcool  =   editAlcool.getText().toString();
        String precoGasosa  =   editGasosa.getText().toString();

        Boolean campoValidado   =   validarCampos( precoAlcool, precoGasosa );

        if ( campoValidado ) {
            //Convertendo string para números
            Double valorAlcool = Double.parseDouble( precoAlcool );
            Double valorGasosa = Double.parseDouble( precoGasosa );

            /* Fazer cálculo de menor preço
            * Se (calorAlcool / valorGasolina) >= 0.7 é melhor utilizar gasolina
            * senão é melhor utilizar álcool
            * */
            if ( valorAlcool / valorGasosa >= 0.7 ) {
                txtResultado.setText("Melhor utilizar é Gasolina");
            } else {
                txtResultado.setText("Melhor utilizar é Álcool");
            }
        } else {
            txtResultado.setText("Preencha os campos primeiros!");
        }
    }

    // Validar os campos
    public boolean validarCampos( String pAlcool, String pGasosa ) {
        Boolean campoValidado   =   true;

        if ( pAlcool == null || pAlcool.equals("") ) {
            campoValidado = false;
        } else if ( pGasosa == null || pGasosa.equals("") ) {
            campoValidado = false;
        }

        return campoValidado;
    }
}