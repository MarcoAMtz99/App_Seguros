package com.unam.proyectotec;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginPantallaActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText name;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pantalla);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //  updateUI(currentUser);
    }

    public void login(View view){
        mAuth.signInWithEmailAndPassword(name.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // SI FUNCIONA EL LOGIN
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(),"BIENVENIDO",Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(),menuPantallaActivity.class);
                            startActivity(i);

                        } else {
                            //SI FALLA EL LOGIN
                            Toast.makeText(getApplicationContext(), "FALLO EN LA AUTENTICACION.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
                //FIN DEL METODO QUE VALIDA EL LOGIN
    }

}