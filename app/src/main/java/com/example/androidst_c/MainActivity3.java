package com.example.androidst_c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private TextView nombre_env;
    private TextView apellido_env;
    private TextView cargo_env;
    private TextView sueldo_env;
    private TextView diaslab_env;
    private TextView sueldoxdia_env;
    private TextView sueldoneto_env;
    private TextView descuento_env;
    private TextView pension_env;
    private TextView salud_env;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        nombre_env = (TextView) findViewById(R.id.nombre_env);
        apellido_env = (TextView) findViewById(R.id.apellido_env);
        cargo_env = (TextView) findViewById(R.id.cargo_env);
        sueldo_env = (TextView) findViewById(R.id.sueldo_env);
        diaslab_env = (TextView) findViewById(R.id.diaslab_env);
        sueldoxdia_env = (TextView) findViewById(R.id.sueldoxdia_env);
        sueldoneto_env = (TextView) findViewById(R.id.sueldoneto_env);
        descuento_env = (TextView) findViewById(R.id.descuento_env);
        pension_env = (TextView) findViewById(R.id.pension_env);
        salud_env = (TextView) findViewById(R.id.salud_env);



        String dnombre = getIntent().getStringExtra("nombre");
        String dapellido = getIntent().getStringExtra("apellido");
        String dcargo = getIntent().getStringExtra("cargo");
        String dsueldo = getIntent().getStringExtra("sueldo");
        String ddiaslab = getIntent().getStringExtra("diaslab");

        //numerico
        double dsueldoxdia = getIntent().getDoubleExtra("sueldoxdia", 0.0);
        sueldoneto_env.setText(String.valueOf("Sueldo por dia: " + dsueldoxdia));

         double dsueldoneto = getIntent().getDoubleExtra("Sueldoneto", 0.0);
        sueldoxdia_env.setText(String.valueOf("Sueldo neto: " + dsueldoneto));

        double ddescuento = getIntent().getDoubleExtra("descuento", 0.0);
        descuento_env.setText(String.valueOf("Descuento: " + ddescuento));

        double dpension = getIntent().getDoubleExtra("pension", 0.0);
        pension_env.setText(String.valueOf("Pension: " + dpension));

        double dsalud = getIntent().getDoubleExtra("salud", 0.0);
        salud_env.setText(String.valueOf("Salud: " + dsalud));





        nombre_env.setText(dnombre);
        apellido_env.setText(dapellido);
        cargo_env.setText(dcargo);
        sueldo_env.setText(dsueldo);
        diaslab_env.setText(ddiaslab);


    }

    public void Regresar(View View){
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }
}