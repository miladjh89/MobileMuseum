package com.moozemobile.mobilemuseum;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sign_in extends AppCompatActivity {


    EditText input_firstname ,input_lastname ,input_age ,input_e_mail ,input_username ;
    Button btn_signin ,btn_signout ;
    SharedPreferences pref ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(getSupportActionBar()!= null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        pref = getPreferences(MODE_PRIVATE);

        initViews();

        
    }

    private void initViews() {
        input_firstname = (EditText) findViewById(R.id.input_firstname);
        input_lastname = (EditText) findViewById(R.id.input_lastname);
        input_username = (EditText) findViewById(R.id.input_username);
        input_age = (EditText) findViewById(R.id.input_age);
        input_e_mail = (EditText) findViewById(R.id.input_e_mail);
        btn_signin = (Button) findViewById(R.id.btn_signin);
        btn_signout = (Button) findViewById(R.id.btn_signout);

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstname = input_firstname.getText().toString().trim();
                String lastname = input_lastname.getText().toString().trim();
                String username = input_username.getText().toString().trim();
                String ageStr = input_age.getText().toString().trim();
                String e_mail = input_e_mail.getText().toString().trim();
                if (!firstname.isEmpty() && !lastname.isEmpty() && !username.isEmpty() && !ageStr.isEmpty() && !e_mail.isEmpty()) {
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("firstname", firstname);
                    editor.putString("lastname", lastname);
                    editor.putString("username", username);
                    editor.putString("e_mail", e_mail);
                    editor.putInt("age", Integer.valueOf(ageStr));
                    editor.apply();
                    Toast.makeText(Sign_in.this, "Registered", Toast.LENGTH_SHORT).show();

                }

            }

        });

        btn_signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstname = pref.getString("firstname","NOT FOUND");
                String lastname = pref.getString("lastname","NOT FOUND");
                String username = pref.getString("username","NOT FOUND");
                String e_mail = pref.getString("e_mail","NOT FOUND");
                int age = pref.getInt("age",-1);

                new AlertDialog.Builder(Sign_in.this)
                        .setTitle("pref.Valuse")
                        .setMessage("Firstname :" + firstname + "\n" +
                                "Lastname :" + lastname + "\n" +
                                "Username :" + username + "\n" +
                                "E_mail :" + e_mail + "\n" +
                                "age :" + (age == -1 ? "NOTFOUND" : age))
                        .show();

                Intent intent = new Intent(Sign_in.this,MenuMainActivity.class);
                intent.putExtra("username", username);
                Sign_in.this.startActivity(intent);


            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            Sign_in.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
