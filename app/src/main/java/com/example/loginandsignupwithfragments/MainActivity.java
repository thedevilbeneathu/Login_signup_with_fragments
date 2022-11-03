package com.example.loginandsignupwithfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail,etpass,confirmpass,etEmail2,etPASS2;
    private Button btn,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     connectcomponents();
    }
    public void connectcomponents(){
        etEmail= findViewById(R.id.etEmail);
        etpass= findViewById(R.id.etpass2);
        confirmpass= findViewById(R.id.confirmpassword2);
        btn=findViewById(R.id.newuser);
        btn2=findViewById(R.id.signin);
        etEmail2=findViewById(R.id.email);
        etPASS2=findViewById(R.id.pass);
        btn3=findViewById(R.id.forgot);
    }



    private boolean ispasswordvalid(String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();
    }

    public boolean isEmailvalid(String email){
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void signup(View view) {
        String email,password,confirmpassword;
        email = etEmail.getText().toString();
        password = etpass.getText().toString();
        confirmpassword= confirmpass.getText().toString();
        if( email.trim().isEmpty() || password.trim().isEmpty() || confirmpassword.trim().isEmpty())
        {
            Toast.makeText(this, "some feilds are missing!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!isEmailvalid(email))
        {
            Toast.makeText(this, "Email is incorrect!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!ispasswordvalid(password))
        {
            Toast.makeText(this, "Email is incorrect!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!password.equals(confirmpassword))
        {
            Toast.makeText(this, "the confirmed password is not identical", Toast.LENGTH_SHORT).show();
        }

    }

    public void Newuser(View view) {

        btn.setVisibility(View.GONE);
        etPASS2.setVisibility(View.GONE);
        etEmail2.setVisibility(View.GONE);
        btn2.setVisibility(View.GONE);
        btn3.setVisibility(View.GONE);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FrameLayout, new SIGNUP());
        ft.commit();
    }



    public void signin(View view) {
        String email,password,confirmpassword;
        email = etEmail.getText().toString();
        password = etpass.getText().toString();
    }

    public void forgotpass(View view) {
            btn.setVisibility(View.GONE);
            etPASS2.setVisibility(View.GONE);
            etEmail2.setVisibility(View.GONE);
            btn2.setVisibility(View.GONE);
            btn3.setVisibility(View.GONE);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.FrameLayout, new forgotpassword());
            ft.commit();

    }
}