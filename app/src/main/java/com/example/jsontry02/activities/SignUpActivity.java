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
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {
    EditText userName,userEmail,userUSN,userPhoneNumber,userCollege;
    TextView alreadyUser;
    FirebaseAuth mAuth;
    Button signUp;
    FirebaseDatabase database;
    DatabaseReference root;
    String userUID,userNameString,userEmailString,userUSNString,userPhoneNumberString,userCollegeString;
    PreferenceManager preferenceManager = new PreferenceManager(this);
    FirebaseUser currentUserOfAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initializeView();
        alreadyUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,LogInActivity.class);
                startActivity(intent);
                finish();
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpUser();

            }
        });
    }
    public void initializeView(){
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser()!=null){
            Intent intent = new Intent(SignUpActivity.this,SplashscreenActivity.class);
            startActivity(intent);
            finish();
        }
        userName = findViewById(R.id.userName);
        userEmail = findViewById(R.id.userEmail);
        userPhoneNumber = findViewById(R.id.userPhoneNumber);
        userUSN = findViewById(R.id.userUSN);
        userCollege = findViewById(R.id.userCollege);
        alreadyUser = findViewById(R.id.alreadyUser);
        signUp = findViewById(R.id.btnSignUp);
        database=FirebaseDatabase.getInstance();
        root=database.getReference().child("usersOfApp");
        currentUserOfAuth = FirebaseAuth.getInstance().getCurrentUser();
    }
    public void signUpUser(){
        userNameString =userName.getText().toString();
        userPhoneNumberString =userPhoneNumber.getText().toString();
        userUSNString =userUSN.getText().toString();
        userEmailString =userEmail.getText().toString();
        userCollegeString =userCollege.getText().toString();
        if(userName.getText().toString().isEmpty() || userEmail.getText().toString().isEmpty() || userUSN.getText().toString().isEmpty() ||
                userPhoneNumber.getText().toString().isEmpty() || userPhoneNumber.getText().toString().length()!=10 || userUSN.getText().toString().length()!=10){
            Toast.makeText(this, "Please enter a valid credentials", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.createUserWithEmailAndPassword(userEmailString,userUSNString.toLowerCase())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            userUID = mAuth.getCurrentUser().getUid().toString();
                            preferenceManager.saveUserData(userNameString,userEmailString,userPhoneNumberString,userUSNString.toLowerCase(),userCollegeString);
                            uploadingUserDataToFireBase();
                            Intent intent = new Intent(SignUpActivity.this,SplashscreenActivity.class);
                            startActivity(intent);
                            finish();

                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignUpActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void uploadingUserDataToFireBase(){
        HashMap<String,String> userMap= new HashMap<>();
        userMap.put("Name",(userNameString));
        userMap.put("Email",(userEmailString));
        userMap.put("PhoneNumber",(userPhoneNumberString));
        userMap.put("USN",(userUSNString));
        userMap.put("College",(userCollegeString));
        root.child(userUID).setValue(userMap).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                AuthCredential credential = EmailAuthProvider.getCredential(preferenceManager.getUserEmail(),preferenceManager.getUserUSN());
                currentUserOfAuth.reauthenticate(credential)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                currentUserOfAuth.delete()
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Toast.makeText(SignUpActivity.this, "Please Try Again", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                            }
                        });
            }
        });
    }
}
