package com.saludo.tareaandroidsemana2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtFechaNac;
    private EditText txtTelefono;
    private EditText txtEmail;
    private EditText txtContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText)findViewById(R.id.txtNombre);
        txtFechaNac = (EditText)findViewById(R.id.txtFechaNac);
        txtTelefono = (EditText)findViewById(R.id.txtTelefono);
        txtEmail = (EditText)findViewById(R.id.txtEmail);
        txtContacto = (EditText)findViewById(R.id.txtContacto);

        mostrarDatos();

    }

    public void mostrarSiguiente(View view) {

        Intent intent = new Intent(MainActivity.this, Registro.class);
        intent.putExtra("nombre", txtNombre.getText().toString());
        intent.putExtra("fechanac", txtFechaNac.getText().toString());
        intent.putExtra("telefono", txtTelefono.getText().toString());
        intent.putExtra("email", txtEmail.getText().toString());
        intent.putExtra("contacto", txtContacto.getText().toString());
        startActivity(intent);
    }

    public void mostrarFecha(View view) {
        final Calendar cldr = Calendar.getInstance();
        int dia = cldr.get(Calendar.DAY_OF_MONTH);
        int mes = cldr.get(Calendar.MONTH);
        int ano = cldr.get(Calendar.YEAR);
        DatePickerDialog picker = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        txtFechaNac.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }

                }, ano, mes, dia);
        picker.show();
    }

    public void mostrarDatos(){

        Bundle parametros = this.getIntent().getExtras();

        if (parametros != null){

            String nombre = parametros.getString("nombre");
            String fechanac = parametros.getString("fechanac");
            String telefono = parametros.getString("telefono");
            String email = parametros.getString("email");
            String contacto = parametros.getString("contacto");

            txtNombre.setText(nombre);
            txtFechaNac.setText(fechanac);
            txtTelefono.setText(telefono);
            txtEmail.setText(email);
            txtContacto.setText(contacto);

        }
    }

}