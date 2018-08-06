package com.example.app.taskapp;

import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private EditText mEmail;
    private EditText mPassword;
    private Button mSignIn;
    private TextView mRegistration;
    //    private ProgressBar mBar;
    private FirebaseAuth mAuth;


    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        mAuth = FirebaseAuth.getInstance();

        initElements(view);
        setOnClickListener();

        return view;
    }

    private void initElements(View view) {
        mEmail = view.findViewById(R.id.input_email);
        mPassword = view.findViewById(R.id.input_password);
        mSignIn = view.findViewById(R.id.login_btn);
        mRegistration = view.findViewById(R.id.register_btn);
    }

    private void setOnClickListener() {
        mSignIn.setOnClickListener(this);
        mRegistration.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn:
                clickSingInBtn();
                break;
            case R.id.register_btn:
                clickRegisterBtn();
                break;
        }
    }

    private void clickRegisterBtn() {
        RegistrationFragment registrationFragment = new RegistrationFragment();
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, registrationFragment).addToBackStack("login").commit();
    }

    private void clickSingInBtn() {
        String email = mEmail.getText().toString();
        final String password = mPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getActivity().getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getActivity().getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }

        //progressBar.setVisibility(View.VISIBLE);

        //authenticate user
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        //  progressBar.setVisibility(View.GONE);
                        if (!task.isSuccessful()) {
                            if (password.length() < 6) {
                                mPassword.setError(getString(R.string.messageForShortPassword));
                            } else {
                                Toast.makeText(getActivity(), getString(R.string.messageForInvalidEmailOrPassword),
                                        Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Intent intent = new Intent(getActivity(), HomeActivity.class);
                            startActivity(intent);
                        }
                    }
                });
    }
}
