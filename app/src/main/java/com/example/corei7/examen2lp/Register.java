package com.example.corei7.examen2lp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.corei7.examen2lp.bean.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Register extends AppCompatActivity {

    private EditText txtName;
    private EditText txtLastNameF;
    private EditText txtLastNameM;
    private EditText txtAddress;
    private Spinner spinnerSex;
    private int personId;
    private List<String> listSex;

    private RadioButton radioActive, radioInactive;
    private RadioGroup radioGroupStatus;

    private Switch switchMarried;
    private TextView textViewMarried;

    private TextInputLayout tilName, tilSex;

    private RatingBar ratingBarScore;
    private String score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loadFiles();
//        editLoad();
        savePerson();


    }

    public void loadFiles() {
        txtName = (EditText) findViewById(R.id.txtNombre);
        txtLastNameF = (EditText) findViewById(R.id.txtLastNameF);
        txtLastNameM = (EditText) findViewById(R.id.txtLastNameM);
        tilName = (TextInputLayout) findViewById(R.id.tilName);


    }

//    public void editLoad(){
//        // para obtener valores enviados de la otra actividad
//        Bundle parameters = getIntent().getExtras();
//        personId = (int) parameters.getInt("personId");
//        if(personId!=0){
//
//            Person person = getPersonById(personId);
//            txtName.setText(person.getName());
//            txtLastNameF.setText(person.getLastNameF());
//            txtLastNameM.setText(person.getLastNameM());
//
//            ratingBarScore.setRating(Float.parseFloat(person.getScore()));
//
//        }
//    }

    public void savePerson() {
        Button btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

    //            boolean a = isFileValid(txtName.getText().toString());
//                boolean b = isNullSex();
//
//                if (a || b) {
//                    return;
//                }
//
//                if(personId==0){
//                    newPerson();
//                }else{
//                    updatePerson();
//                }
//                goMain();
//
            }
        });
    }


    public void newPerson() {
        Random rn = new Random();
        int answer = rn.nextInt(1000) + 1;

        Person person = new Person();
        person.setId(answer);
        person.setName(txtName.getText().toString());
        person.setLastNameF(txtLastNameF.getText().toString());
        person.setLastNameM(txtLastNameM.getText().toString());

        person.setScore(score);

        Login.listPerson.add(person);


    }

    public void updatePerson() {
        List<Person> listPerson2 = new ArrayList<Person>();
        for (Person person : Login.listPerson) {
            if (person.getId() == personId) {
                person.setName(txtName.getText().toString());
                person.setLastNameF(txtLastNameF.getText().toString());
                person.setLastNameM(txtLastNameM.getText().toString());

            }
            person.setScore(score);

            Login.listPerson.add(person);
        }
//        listPerson2.add(person);
//        }
//
//
//    public void goMain(){
//        Intent i = new Intent(this,Login.class);
//        startActivity(i);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_register, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.action_back:
//                Intent i = new Intent(this,Login.class);
//                startActivity(i);
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

//
//            public Person getPersonById(int personId) {
//                List<Person> listPerson = Login.listPerson;
//
//                for (Person person : listPerson) {
//                    if (person.getId() == personId) {
//                        return person;
//                    }
//                }
//                return null;
//            }


//            private boolean isFileValid(String file) {
//                tilName.setError(null);
//                if (validarFile(file, 30)) {
//                    tilName.setError("Campo inválido");
//                    return true;
//                }
//                return false;
//            }

//            private boolean validarFile(String file, int sizeFile) {
////        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
////        return patron.matcher(nombre).matches() || nombre.length() > sizeFile;
//                return file.length() > sizeFile;
//
//            }

    }
}