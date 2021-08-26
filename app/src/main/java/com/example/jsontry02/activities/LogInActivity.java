package com.example.jsontry02.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jsontry02.R;
import com.example.jsontry02.utilities.PreferenceManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LogInActivity extends AppCompatActivity {
    EditText userEmail,userUSN;
    TextView newUser;
    FirebaseAuth mAuth;
    Button logIn;
    DatabaseReference mDatabase;
    String userUID,userNameString,userEmailString,userUSNString,userPhoneNumberString,userCollegeString;
    PreferenceManager preferenceManager = new PreferenceManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        initializeView();
        if (mAuth.getCurrentUser()!=null){
            Intent intent = new Intent(LogInActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logInUser();
            }
        });
        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInActivity.this,SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void initializeView(){
        userEmail = findViewById(R.id.userEmail);
        userUSN = findViewById(R.id.userUSN);
        logIn = findViewById(R.id.btnLogIn);
        newUser=findViewById(R.id.newUser);
        mAuth = FirebaseAuth.getInstance();
        mDatabase=FirebaseDatabase.getInstance().getReference("usersOfApp");
    }
    public void logInUser(){
        mAuth.signInWithEmailAndPassword(userEmail.getText().toString().trim(),userUSN.getText().toString().toLowerCase())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            userUID=mAuth.getCurrentUser().getUid();
                            Toast.makeText(LogInActivity.this, "Done Login", Toast.LENGTH_SHORT).show();
                            mDatabase.child(userUID).addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    userNameString = snapshot.child("Name").getValue(String.class);
                                    userEmailString = snapshot.child("Email").getValue(String.class);
                                    userPhoneNumberString = snapshot.child("PhoneNumber").getValue(String.class);
                                    userUSNString = snapshot.child("USN").getValue(String.class);
                                    userCollegeString = snapshot.child("College").getValue(String.class);
                                    preferenceManager.saveUserData(userNameString,userEmailString,userPhoneNumberString,userUSNString.toLowerCase(),userCollegeString);
                                    Toast.makeText(LogInActivity.this,preferenceManager.getUserName(), Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LogInActivity.this,SplashscreenActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {
                                    Toast.makeText(LogInActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LogInActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
