package com.example.app.taskapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class RegistrationFragment extends Fragment implements View.OnClickListener {

    private EditText mName;
    private EditText mEmail;
    private EditText mPassword;
    private Button mRegister;
    private FirebaseAuth auth;
    //private ProgressBar mBar;


    public RegistrationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration, container, false);

        auth = FirebaseAuth.getInstance();

        initElements(view);
        setOnClickListener();

        return view;
    }

    private void initElements(View view) {
        mName = view.findViewById(R.id.name);
        mEmail = view.findViewById(R.id.input_email_reg);
        mPassword = view.findViewById(R.id.input_password_reg);
        mRegister = view.findViewById(R.id.register_btn);
       // mBar = view.findViewById(R.id.progress_bar);
    }

    private void setOnClickListener() {
        mRegister.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_btn:
                userRegistration();
                break;
        }
    }

    private void userRegistration() {
        final String emailTxt = mEmail.getText().toString();
        String passwordTxt = mPassword.getText().toString();
        if (TextUtils.isEmpty(emailTxt)) {
            Toast.makeText(getActivity().getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(passwordTxt)) {
            Toast.makeText(getActivity().getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (passwordTxt.length() < 6) {
            Toast.makeText(getActivity().getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
            return;
        }
        //progressBar.setVisibility(View.VISIBLE);
        //create user
        auth.createUserWithEmailAndPassword(emailTxt, passwordTxt)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // progressBarInvisibility();
                        if (!task.isSuccessful()) {
                            Toast.makeText(getActivity(), "Register an account failed", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getActivity(), "Registration successfuly", Toast.LENGTH_SHORT).show();

                            LoginFragment loginFragment = new LoginFragment();
                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.container, loginFragment);
                            fragmentTransaction.addToBackStack("Login").commit();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //  progressBarInvisibility();
            }
        });
    }
}
