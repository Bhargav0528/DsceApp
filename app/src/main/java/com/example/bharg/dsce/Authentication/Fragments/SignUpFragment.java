package com.example.bharg.dsce.Authentication.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.bharg.dsce.R;
import com.example.bharg.dsce.Authentication.UserDetails;
import com.google.firebase.auth.FirebaseAuth;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText etemail;
    private EditText etpass;
    private Button signup;

    private static final String TAG = "SignUpFragment";

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        mAuth = FirebaseAuth.getInstance();

        etemail = (EditText) view.findViewById(R.id.email);
        etpass = (EditText) view.findViewById(R.id.password);
        signup = (Button)view.findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etemail.getText().toString();
                String password = etpass.getText().toString();
                Log.i(TAG,password);

                Intent inten = new Intent(getActivity(), UserDetails.class);
                inten.putExtra("email",email);
                inten.putExtra("pass",password);
                startActivity(inten);
            }
        });

        return view;
    }

}
