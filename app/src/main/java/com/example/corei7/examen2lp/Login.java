package com.example.corei7.examen2lp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.corei7.examen2lp.bean.Person;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity{

        public static List<Person> listPerson = new ArrayList<Person>();

        public int personId=0;

        final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button button = (Button) findViewById(R.id.btnEntrar);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String usuario = ((EditText) findViewById(R.id.etUsuario)).getText().toString();
                String contraseña = ((EditText) findViewById(R.id.etContraseña)).getText().toString();
                if (usuario.equals("admin") && contraseña.equals("123456")) {

                    Intent nuevo = new Intent(Login.this , Menus.class);
                    startActivity(nuevo);

                } else {
                    Toast.makeText(getApplicationContext(), "Usuario incorrecto", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    public void btnOlvide(View v) {
        Intent olv = new Intent(this, Olvide.class);
        startActivity(olv);
    }
    public void btnRegister(View v) {
        Intent reg = new Intent(this, Register.class);
        startActivity(reg);
}}