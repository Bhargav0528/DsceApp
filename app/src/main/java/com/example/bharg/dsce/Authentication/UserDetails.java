package com.example.bharg.dsce.Authentication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bharg.dsce.MainActivity;
import com.example.bharg.dsce.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class UserDetails extends AppCompatActivity {

    EditText usn,branch,sem,username;
    ImageView btcontinue;

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    DatabaseReference dref;

    String email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user_details);
        email = getIntent().getStringExtra("email");
        password = getIntent().getStringExtra("pass");

        mAuth = FirebaseAuth.getInstance();

        dref = FirebaseDatabase.getInstance().getReference();

        usn = (EditText)findViewById(R.id.usn);
        branch = (EditText)findViewById(R.id.branch);
        username = (EditText)findViewById(R.id.username);
        sem = (EditText)findViewById(R.id.semester);

        btcontinue = (ImageView)findViewById(R.id.btcontinue);
        btcontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(UserDetails.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(UserDetails.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(UserDetails.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    String ussn = usn.getText().toString();
                                    String usrname = username.getText().toString();
                                    String semester = sem.getText().toString();
                                    String brnch = branch.getText().toString();

                                    FirebaseUser usr = mAuth.getCurrentUser();
                                    String uid = usr.getUid();


                                    dref.child("users").child(uid).child("branch").setValue(brnch);
                                    dref.child("users").child(uid).child("semester").setValue(semester);
                                    dref.child("users").child(uid).child("usn").setValue(ussn);
                                    dref.child("users").child(uid).child("username").setValue(usrname);

                                    startActivity(new Intent(UserDetails.this, MainActivity.class));
                                }
                            }
                        });



            }
        });
    }


}
