package com.unam.proyectotec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menuPantallaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pantalla);
    }
    public void Cotizar(View view){
        Intent i = new Intent(getApplicationContext(),cotizarActivity.class);
        startActivity(i);
    }
    public void Datos(View view){
        Intent i = new Intent(getApplicationContext(),datosPersonalesActivity.class);
        startActivity(i);
    }
    public void Historial(View view){
        Intent i = new Intent(getApplicationContext(),historialActivity.class);
        startActivity(i);
    }
}