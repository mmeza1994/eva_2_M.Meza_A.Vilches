package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SEGURIDAD_ACT extends AppCompatActivity {

    private EditText ingreso;
    private TextView mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_e_g_u_r_i_d_a_d__a_c_t);

        ingreso = (EditText)findViewById(R.id.contr);
        mostrar = (TextView)findViewById(R.id.codificado);
    }
    private SecretKeySpec generateKey(String password)throws Exception {
        MessageDigest sh = MessageDigest.getInstance("SHA-256");
        byte[] key = password.getBytes("UTF-8");
        key = sh.digest(key);

        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        return secretKey;
    }
    public String Encriptar(String datos,String password)throws Exception
    {
        if(!ingreso.getText().toString().isEmpty())
        {
            SecretKeySpec secretKey = generateKey(password);
            Cipher cipher= Cipher.getInstance("AES");
            cipher.init(cipher.ENCRYPT_MODE,secretKey);

            byte[] datosEncriptadosBt = cipher.doFinal(datos.getBytes());
            String datosEncriptadosSt = Base64.encodeToString(datosEncriptadosBt,Base64.DEFAULT);

            return datosEncriptadosSt;
        }
        else
        {
            Toast.makeText(this,"Debe ingresar una contraseña",Toast.LENGTH_LONG).show();
            return null;
        }

    }
    public void Encriptar(View v)
    {
        try {
            String mensaje = Encriptar(ingreso.getText().toString(),mostrar.getText().toString());
            mostrar.setText(mensaje);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}