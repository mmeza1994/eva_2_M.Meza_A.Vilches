package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clase.Clientes;
import Clase.Creditos;

public class PRESTAMOS_ACT extends AppCompatActivity {

    private Spinner spin1;
    private Spinner spin2;
    private TextView view1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos_act);

        spin1 =(Spinner)findViewById(R.id.spinner1);
        spin2 =(Spinner)findViewById(R.id.sp2);
        view1 =(TextView)findViewById(R.id.mostrar);

        ArrayList<String>listaCreditos = (ArrayList<String>) getIntent().getSerializableExtra("listaCreditos");
        ArrayList<String>listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listaClientes);
        ArrayAdapter<String> adapts = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listaCreditos);

        spin1.setAdapter(adapt);
        spin2.setAdapter(adapts);
    }

    public void Calcular(View v)
    {
        Creditos cr1 = new Creditos();

        Clientes c1 = new Clientes();
        String cliente = spin1.getSelectedItem().toString();
        String credito = spin2.getSelectedItem().toString();

        if(cliente.equals("Axel") && credito.equals("Cre_Hipotecario"))
        {
            int total = c1.getAxel()+cr1.getCre_hipotecarios();
            view1.setText("El prestamo total es: $" + total);
        }
        if (cliente.equals("Axel") && credito.equals("Cre_Automotriz"))
        {
            int total = c1.getAxel()+cr1.getCre_automotriz();
            view1.setText("El prestamo total es: $" + total);
        }
        if(cliente.equals("Roxana") && credito.equals("Cre_Hipotecario"))
        {
            int total = c1.getRoxana()+cr1.getCre_hipotecarios();
            view1.setText("El prestamo total es: $" + total);
        }
        if (cliente.equals("Roxana") && credito.equals("Cre_Automotriz"))
        {
            int total = c1.getRoxana()+cr1.getCre_automotriz();
            view1.setText("El prestamo total es: $" + total);
        }
    }
    public void Deuda(View v)
    {
        Creditos cr1 = new Creditos();

        Clientes c1 = new Clientes();
        String cliente = spin1.getSelectedItem().toString();
        String credito = spin2.getSelectedItem().toString();

        if(cliente.equals("Axel") && credito.equals("Cre_Hipotecario"))
        {
            int total = (c1.getAxel()+cr1.getCre_hipotecarios())/12;
            view1.setText("Las cuotas son de: $" + total);
        }
        if (cliente.equals("Axel") && credito.equals("Cre_Automotriz"))
        {
            int total = (c1.getAxel()+cr1.getCre_automotriz())/8;
            view1.setText("Las cuotas son de: $" + total);
        }
        if(cliente.equals("Roxana") && credito.equals("Cre_Hipotecario"))
        {
            int total = (c1.getRoxana()+cr1.getCre_hipotecarios())/12;
            view1.setText("Las cuotas son de: $" + total);
        }
        if (cliente.equals("Roxana") && credito.equals("Cre_Automotriz"))
        {
            int total = (c1.getRoxana()+cr1.getCre_automotriz())/8;
            view1.setText("Las cuotas son de: $" + total);
        }
    }
}