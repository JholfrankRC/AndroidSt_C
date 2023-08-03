package com.example.androidst_c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.FileObserver;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;


public class MainActivity2 extends AppCompatActivity {

    private EditText lbl_nombre;
    private EditText lbl_apellido;
    private EditText lbl_cargo;
    private EditText lbl_sueldo;
    private EditText lbl_diaslab;
    private CheckBox check1;
    private CheckBox check2;
    private CheckBox check3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lbl_nombre = (EditText) findViewById(R.id.lbl_nombre);
        lbl_apellido = findViewById(R.id.lbl_apellido);
        lbl_cargo = (EditText) findViewById(R.id.lbl_cargo);
        lbl_sueldo = (EditText) findViewById(R.id.lbl_sueldo);
        lbl_diaslab = (EditText) findViewById(R.id.lbl_diaslab);
        check1 = (CheckBox) findViewById(R.id.check1);
        check2 = (CheckBox) findViewById(R.id.check2);
        check3 = (CheckBox) findViewById(R.id.check3);
    }

    public void enviar(View View){

        Intent i = new Intent(this, MainActivity3.class);


        double sueldo_inicial = Double.parseDouble(lbl_sueldo.getText().toString());
        double sueldoxdia = Double.parseDouble(lbl_diaslab.getText().toString());

        boolean descuento = check1.isChecked();
        boolean pension = check2.isChecked();
        boolean salud = check3.isChecked();


        double porcentaje_descuento =0;
        if(descuento){

            porcentaje_descuento += 3;
            double descuento_desc = sueldo_inicial * 0.03;
            i.putExtra("descuento", descuento_desc);
            
        }
        if (pension){
            porcentaje_descuento += 4;
            double descuento_pension = sueldo_inicial * 0.04;
            i.putExtra("pension", descuento_pension);
        }
        if(salud){
            porcentaje_descuento += 4;
            double descuento_salus = sueldo_inicial * 0.04;
            i.putExtra("salud", descuento_salus);
        }

        double total_descuento = sueldo_inicial * (porcentaje_descuento / 100);
        double sueldo_dia = sueldo_inicial / 30;
        double salario_bruto = sueldo_dia * sueldoxdia;
        double sueldo_neto = salario_bruto - total_descuento;



        i.putExtra("nombre", lbl_nombre.getText().toString());
        i.putExtra("apellido", lbl_apellido.getText().toString());
        i.putExtra("cargo", lbl_cargo.getText().toString());
        i.putExtra("sueldo", lbl_sueldo.getText().toString());
        i.putExtra("diaslab", lbl_diaslab.getText().toString());
        i.putExtra("sueldoxdia", sueldo_dia);
        i.putExtra("Sueldoneto", sueldo_neto);

        startActivity(i);

    }

}