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
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
        DatePickerDialog picker = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        txtFechaNac.setText(i2 + "/" + (i1 + 1) + "/" + i);
                    }

                }, year, month, day);
        picker.show();
    }

}