package com.saludo.tareaandroidsemana2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    TextView txtNombre1;
    TextView txtTelefono1;
    TextView txtFechaNac1;
    TextView txtEmail1;
    TextView txtContacto1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtNombre1 = (TextView)findViewById(R.id.txtNombre1);
        txtFechaNac1 = (TextView)findViewById(R.id.txtFechaNac1);
        txtTelefono1 = (TextView)findViewById(R.id.txtTelefono1);
        txtEmail1 = (TextView)findViewById(R.id.txtEmail1);
        txtContacto1 = (TextView)findViewById(R.id.txtContacto1);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("nombre");
        String fechanac = parametros.getString("fechanac");
        String telefono = parametros.getString("telefono");
        String email = parametros.getString("email");
        String contacto = parametros.getString("contacto");

        txtNombre1.setText(nombre);
        txtFechaNac1.setText(fechanac);
        txtTelefono1.setText(telefono);
        txtEmail1.setText(email);
        txtContacto1.setText(contacto);

    }

    public void editarDatos(View view) {

        Intent intent = new Intent(Registro.this, MainActivity.class);
        intent.putExtra("nombre", txtNombre1.getText().toString());
        intent.putExtra("fechanac", txtFechaNac1.getText().toString());
        intent.putExtra("telefono", txtTelefono1.getText().toString());
        intent.putExtra("email", txtEmail1.getText().toString());
        intent.putExtra("contacto", txtContacto1.getText().toString());
        startActivity(intent);
        
    }

}