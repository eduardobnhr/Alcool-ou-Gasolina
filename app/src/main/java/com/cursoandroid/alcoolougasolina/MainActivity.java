package com.cursoandroid.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);

    }

    public void calcularPreco(View view){
        //recuperar valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //Validar os campos digitados
        Boolean camposValidados =  validarCampos(precoAlcool, precoGasolina);
        if(camposValidados){
                //convertendo string para numeros
            double valorAlcool = Double.parseDouble( precoAlcool);
            double valorGasolina = Double.parseDouble( precoGasolina);
            /*fazer calcular de menor preco
            *se (valorAlcool / valorGasolina) >= 0.7 é melhor utilizar gasolina
            * senao é melhoir utilizare alcool
             */
            Double resultado = valorAlcool/valorGasolina;
            if(resultado >= 0.7){
                textResultado.setText("é melhor usar gasolina");
            }else{
                textResultado.setText("melhor utilizar alcool");
            }


        }else{
            textResultado.setText("Preencha os precos primeiro!");
        }

    }

    public Boolean validarCampos(String pAlcool, String pGasolina){
        Boolean camposValidados = true;
        String campo = "preenchido";
        if(pAlcool == null || pAlcool.equals("") ){
            camposValidados = false;
            campo = "alcool";
        }else if(pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
            campo = "gasolina";
        }
        return camposValidados;

    }
}