package com.unam.proyectotec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class registerPantallaActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText name;
    private EditText password;
    private EditText password_confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_register_pantalla);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        password_confirm = findViewById(R.id.password_confirm);
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //  updateUI(currentUser);
    }

    public void registrarUsuario(View view){
        if (password.getText().toString().equals(password_confirm.getText().toString() )){
                    mAuth.createUserWithEmailAndPassword(name.getText().toString(), password.getText().toString())
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Toast.makeText(getApplicationContext(),"REGISTRO EXITOSO",Toast.LENGTH_SHORT).show();
                                        Intent i = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(i);

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(getApplicationContext(), "ERROR EN LA AUTENTICACION.",
                                                Toast.LENGTH_SHORT).show();

                                    }

                                    // ...
                                }
                            });
                    //FIN DEL CREATE DEL USUARIO EN FIREBASE
        } else {
            Toast.makeText(this,"EL PASSWORD NO ES IGUAL",Toast.LENGTH_SHORT).show();
        }


    }

}