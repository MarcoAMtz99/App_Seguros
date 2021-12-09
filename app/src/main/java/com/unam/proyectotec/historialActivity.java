package com.unam.proyectotec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class historialActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private ListView listView;
    private ArrayList<String> names;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        //FIREBASE
        mAuth = FirebaseAuth.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        listView = findViewById(R.id.lista_historial);
        names = new ArrayList<String>();





        //INGRESAR A LOS REGISTROS DEL USUARIO
        db.collection("cotizaciones")
                .whereEqualTo("user_id", mAuth.getCurrentUser().getUid())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.e("MI_ERROR", document.getId() + " => " + document.getData().get("nombre").toString());
                                // Datos.setText(document.getData().get("nombre").toString());
                                names.add(document.getData().get("nombre").toString());
                            }


                            Toast.makeText(getApplicationContext(),"HISTORIAL EXITOSO",Toast.LENGTH_SHORT).show();

                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(historialActivity.this, android.R.layout.simple_list_item_1,names);
                            listView.setAdapter(adapter);
                        } else {
                            Toast.makeText(getApplicationContext(),"HISTORIAL FALLIDO",Toast.LENGTH_SHORT).show();
                        }


                    }

                });

    }
}