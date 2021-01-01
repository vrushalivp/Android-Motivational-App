package com.example.motivationalspeaker;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {
    public EditText emailid, password;
    public Button signup;
    TextView tvSignIn;
    public EditText fnames;
    public EditText lnames;
    FirebaseAuth mFirebaseAuth;
    FirebaseDatabase database;
    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mFirebaseAuth = FirebaseAuth.getInstance();
        emailid = findViewById(R.id.editText3);
        password = findViewById(R.id.editText4);
        signup = findViewById(R.id.signup);
        tvSignIn = findViewById(R.id.tv12);
        fnames = findViewById(R.id.fnm1);
        lnames = findViewById(R.id.lnm);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference();


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verify();

            }
        });
        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(SignupActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

    public void verify()
    {

        final String name1=fnames.getText().toString().trim();
        final String name2=lnames.getText().toString().trim();
        final String mail=emailid.getText().toString().trim();
        String passwords=password.getText().toString().trim();


        if (name1.isEmpty())
        {
            fnames.setError("please enter your first name");
            fnames.requestFocus();
        }
        if (name2.isEmpty())
        {
            lnames.setError("please enter your last name");
            lnames.requestFocus();
        }
        if (mail.isEmpty())
        {
            emailid.setError("please enter email id");
            emailid.requestFocus();
        }
        else if (passwords.isEmpty())
        {
            password.setError("please enter your password");
            password.requestFocus();
        }
        else if (mail.isEmpty() && passwords.isEmpty() && name1.isEmpty() && name2.isEmpty())
        {
            Toast.makeText(SignupActivity.this, "Fields Are Empty", Toast.LENGTH_SHORT).show();
        }
        else if (!(mail.isEmpty() && passwords.isEmpty() && name1.isEmpty() && name2.isEmpty()))
        {

            mFirebaseAuth.createUserWithEmailAndPassword(mail,passwords).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful())
                    {
                        Toast.makeText(SignupActivity.this, "SignUp Unsuccessful , Please Try Again", Toast.LENGTH_SHORT).show();
                    }
/*                    else
                    {
                        String UserID = ref.push().getKey();
                        user us=new user(mail,name1,name2);
                        ref.child("groupwork").child("user").child(UserID).setValue(us);

                        Toast.makeText(SignupActivity.this, "Successfully inserted", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignupActivity.this, Dashboard.class);//it goes to Home1Activity only for checking.change it later
                        startActivity(intent);

                    }
*/
                    else
                    {
                        user us=new user(mail,name1,name2);
                        FirebaseDatabase.getInstance().getReference("Speakers/user").child(FirebaseAuth.getInstance().getUid()).setValue(us).addOnCompleteListener(
                                new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful())
                                        {
                                            Toast.makeText(SignupActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                        }
                                        else
                                        {
                                            Toast.makeText(SignupActivity.this, "Registration unsuccess", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                        );
                        startActivity(new Intent(SignupActivity.this, Dashboard.class));
                    }
                }
            });
        }


        else
        {
            Toast.makeText(SignupActivity.this, "Error Occured!", Toast.LENGTH_SHORT).show();
        }

    }
}
