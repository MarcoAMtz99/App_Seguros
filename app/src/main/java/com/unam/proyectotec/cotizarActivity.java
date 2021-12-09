package com.unam.proyectotec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;
import com.unam.proyectotec.modelo.Cotizacion;

import java.util.HashMap;
import java.util.Map;

public class cotizarActivity extends AppCompatActivity {
    private EditText nombre;
    private EditText fecha_nacimiento;
    private EditText modelo_auto;
    private EditText cp;
    private EditText celular;
    private DatabaseReference usersRef;
    private FirebaseAuth mAuth;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotizar);
        //DATOS DE LA VISTA
        nombre = findViewById(R.id.nombre);
        fecha_nacimiento = findViewById(R.id.fecha_nacimiento);
        cp = findViewById(R.id.codigo_postal);
        celular = findViewById(R.id.celular);
        modelo_auto = findViewById(R.id.modelo_auto);

        //FIREBASE
        mAuth = FirebaseAuth.getInstance();


        DatabaseReference ref = database.getReference("usuarios");
        usersRef = ref.getRef();



    }
    @SuppressLint("RestrictedApi")
    public void ActionCot(View view){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> cotiza = new HashMap<>();
        cotiza.put("nombre", nombre.getText().toString());
        cotiza.put("fecha_nacimiento", fecha_nacimiento.getText().toString());
        cotiza.put("codigo_postal", cp.getText().toString());
        cotiza.put("celular", celular.getText().toString());
        cotiza.put("modelo_auto", modelo_auto.getText().toString());
        cotiza.put("user_id", mAuth.getCurrentUser().getUid());


        db.collection("cotizaciones")
                .add(cotiza)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(),"REGISTRO EXITOSO",Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"REGISTRO FAIL",Toast.LENGTH_SHORT).show();
                    }
                });


    }






}
