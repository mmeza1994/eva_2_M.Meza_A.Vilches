package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class HOME_ACT extends AppCompatActivity {
    private ViewFlipper vf;
    private int[] images = {R.drawable.a, R.drawable.b, R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_o_m_e__a_c_t);
        vf = (ViewFlipper)findViewById(R.id.slider);

        for(int i = 0; i < images.length; i++)
        {
            flip_image(images[i]);
        }
    }
    public void flip_image(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view);           // añadimos al viewflipper el contenido del slider
        vf.setFlipInterval(2800);   // duración intervalo de imagenes
        vf.setAutoStart(true);     // inicia de forma automatica.

        // Sentido al slider
        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }


    public void Informacion(View v)
    {
        Intent i = new Intent(this, INFO_ACT.class);
        startActivity(i);
    }

    public void Clientes (View v)
    {
        Intent i = new Intent(this, CLIENTES_ACT.class);
        startActivity(i);
    }
    public void Prestamo (View v)
    {
        ArrayList<String> listaClientes = new ArrayList<String>();
        listaClientes.add("Axel");
        listaClientes.add("Roxana");

        ArrayList<String> listaCreditos = new ArrayList<String>();
        listaCreditos.add("Cre_Hipotecario");
        listaCreditos.add("Cre_Automotriz");

        Intent i = new Intent(this, PRESTAMOS_ACT.class);
        i.putExtra("listaClientes",listaClientes);
        i.putExtra("listaCreditos",listaCreditos);
        startActivity(i);
    }
    public void Seguridad (View v)
    {
        Intent i = new Intent(this, SEGURIDAD_ACT.class);
        startActivity(i);
    }

}