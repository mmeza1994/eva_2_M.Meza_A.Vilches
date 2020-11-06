package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MAIN_ACTIVITY extends AppCompatActivity {
    private ProgressBar progress;
    private Button btn;
    private EditText nombre;
    private EditText contra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = (EditText)findViewById(R.id.nombre);
        contra = (EditText)findViewById(R.id.contr);
        progress = (ProgressBar)findViewById(R.id.progress);
        btn = (Button)findViewById(R.id.ingresar);



    }
    public void Ingresar (View v)
    {
        if ((nombre.getText().toString().equals("android")) || (nombre.getText().toString().equals("ANDROID")) && (contra.getText().toString().equals("123")))
        {
            Intent i = new Intent(this, HOME_ACT.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(this,"Debe ingresar un usuario y contraseña correcta",Toast.LENGTH_LONG).show();
        }

    }

}

