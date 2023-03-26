package com.example.a1click;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StartActivity extends AppCompatActivity {
    private EditText etUsername,etPassword;
    private static User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button btn_sign = findViewById(R.id.login);
        etUsername = findViewById(R.id. username);
        etPassword = findViewById(R.id. password);

        FirebaseDatabase database= FirebaseDatabase.getInstance();
        DatabaseReference table_user=database.getReference("User");

        btn_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog mDialog = new ProgressDialog(StartActivity.this);
                mDialog.setMessage("Please Wait..");
                mDialog.show();
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot DataSnapshot) {

                        if (DataSnapshot.child(etUsername.getText().toString()).exists()) {

                            mDialog.dismiss();
                            user = DataSnapshot.child(etUsername.getText().toString()).getValue(User.class);

                            assert user != null;
                            if (user.getPassword().equals(etPassword.getText().toString())) {
                                startActivity(new Intent(StartActivity.this, MainActivity.class));
                                Toast.makeText(StartActivity.this, "Signed in Successfully", Toast.LENGTH_SHORT).show();
                            }else{Toast.makeText(StartActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();}
                        }else{
                            mDialog.dismiss();
                            Toast.makeText(StartActivity.this, "User doesn't exist ", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
        });
    }

    public void onClick2(View v){
        startActivity(new Intent(this, SignUp.class));
    }
}