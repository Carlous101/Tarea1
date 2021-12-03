package com.example.ejemplo001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb;//Declaro las variables para el radio buton 1 y 2 para GENERO
    int radiobuttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //r1=(RadioButton) findViewById(R.id.rdMasculino);
        //r2=(RadioButton) findViewById(R.id.rdFemenino);
        rg=(RadioGroup)findViewById(R.id.rbgGenero);
    }

    public void btEnviar(View view) {
        //Creamos el Inten
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        EditText txtNombres = (EditText) findViewById(R.id.txtNombre);
        EditText txtFecNac = (EditText) findViewById(R.id.txtFecNac);
        EditText txtTelefono = (EditText) findViewById(R.id.txtTelefono);
        //RadioGroup rbgGenero = (RadioGroup) findViewById(R.id.rbgGenero);
        //RadioButton RBtnMasculino = (RadioButton) findViewById(R.id.rdMasculino);
        //RadioButton RBtnFemenino = (RadioButton) findViewById(R.id.rdFemenino);

        //Creamos la información a pasar entre actividades - Pares Key-Value
        Bundle b = new Bundle();
        b.putString("NOMBRE", txtNombres.getText().toString());
        b.putString("TELEFONO", txtTelefono.getText().toString());
        b.putString("FECNACIMIENTO", txtFecNac.getText().toString());
        b.putString("GENERO", rb.getText().toString());


        //Añadimos la información al intent
        intent.putExtras(b);
        //Iniciamos la nueva actividad
        startActivity(intent);

    }
    public void validar(View view){
        radiobuttons= rg.getCheckedRadioButtonId();
        rb=(RadioButton)findViewById(radiobuttons);
    }
}