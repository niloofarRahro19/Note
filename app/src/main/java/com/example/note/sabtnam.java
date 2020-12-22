package com.example.note;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class sabtnam extends AppCompatActivity {
    TextView login;
    TextView email;
    TextView name;
    TextView pass;
    Button submit;
    DatabaseReference mrootref;
    FirebaseAuth mAuth;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabtnam);

        login = findViewById(R.id.login1);
        email = findViewById(R.id.email1);
        name = findViewById(R.id.name1);
        pass = findViewById(R.id.password1);
        submit = findViewById(R.id.submit1);

        mrootref = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sabtnam.this,login.class);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tname = name.getText().toString();
                String temail = email.getText().toString();
                String tpass = pass.getText().toString();

                if (TextUtils.isEmpty(tname) || TextUtils.isEmpty(temail) || TextUtils.isEmpty(tpass)) {
                    Toast.makeText(sabtnam.this, "fill all of fields", Toast.LENGTH_LONG).show();
                } else if (tpass.length() > 8) {
                    Toast.makeText(sabtnam.this, "please Enter long password", Toast.LENGTH_LONG).show();
                } else registering(tname, temail, tpass);
            }
        });
    }

    public void registering(final String name, final String email, final String pass) {
        mAuth.createUserWithEmailAndPassword(email, pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                HashMap<String, Object> data = new HashMap<>();
                data.put("name", name);
                data.put("email", email);
                data.put("password", pass);
                mrootref.child("user").child(mAuth.getCurrentUser().getUid()).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            progressDialog.dismiss();
                            Toast.makeText(sabtnam.this, "register is successfull", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(sabtnam.this,MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            finish();

                        }
                    }
                });
            }
        });
    }
}
