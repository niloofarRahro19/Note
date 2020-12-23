package com.example.note;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    EditText email;
    EditText pass;
    Button buttonlogin;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.email2);
        pass=findViewById(R.id.password2);
        buttonlogin=findViewById(R.id.btnlogin);
        firebaseAuth=FirebaseAuth.getInstance();

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtemail=email.getText().toString();
                String txtpass=pass.getText().toString();
                if (TextUtils.isEmpty(txtemail)||TextUtils.isEmpty(txtpass)){
                    Toast.makeText(login.this,"please filled out all fields",Toast.LENGTH_LONG).show();
                }
                else
                    login(txtemail,txtpass);
            }
        });
    }
    public void login(String email,String pass){
        firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(login.this,"login successfull",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(login.this,MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(login.this,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }
}
