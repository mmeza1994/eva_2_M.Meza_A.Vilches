package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clase.AdminSQLiteOpenHelper;

public class CLIENTES_ACT extends AppCompatActivity {
    private EditText idcodigo,idnombre,idsalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_l_i_e_n_t_e_s__a_c_t);
        idcodigo = (EditText)findViewById(R.id.codigo);
        idnombre = (EditText)findViewById(R.id.nombre);
        idsalario = (EditText)findViewById(R.id.salario);
    }
    public void anadirCliente(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"fichero",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        if(!idcodigo.getText().toString().isEmpty())
        {
            ContentValues registro = new ContentValues();
            registro.put("codigo",idcodigo.getText().toString());
            registro.put("nombre",idnombre.getText().toString());
            registro.put("salario",idsalario.getText().toString());

            bd.insert("clientes",null,registro);
            bd.close();

            Toast.makeText(this,"Has guardado un cliente",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"Debe rellenar los campos",Toast.LENGTH_SHORT).show();
        }

    }
    public void MostraCliente(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = idcodigo.getText().toString();

        if(!codigo.isEmpty())
        {
            Cursor fila = db.rawQuery("SELECT nombre, salario FROM clientes WHERE codigo="+ codigo,null);
            if (fila.moveToFirst())
            {
                idnombre.setText(fila.getString(0));
                idsalario.setText(fila.getString(1));
            }else
            {
                Toast.makeText(this,"No hay campos en la tabla",Toast.LENGTH_LONG).show();
            }
        }else
        {
            Toast.makeText(this,"No hay cliente asociado al codigo",Toast.LENGTH_LONG).show();
        }
    }
    public void EliminarCliente(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"fichero", null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = idcodigo.getText().toString();

        db.delete("clientes","codigo="+codigo,null);
        db.close();

        Toast.makeText(this,"Has eliminado un cliente",Toast.LENGTH_LONG).show();


    }
    public void ActualizarCliente(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"fichero",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = idcodigo.getText().toString();

        ContentValues cont = new ContentValues();

        cont.put("codigo",idcodigo.getText().toString());
        cont.put("nombre",idnombre.getText().toString());
        cont.put("salario",idsalario.getText().toString());

        if (!codigo.isEmpty())
        {
            db.update("clientes",cont,"codigo="+codigo,null);

            Toast.makeText(this,"Has actualizado un campo", Toast.LENGTH_LONG).show();
        }

    }
}