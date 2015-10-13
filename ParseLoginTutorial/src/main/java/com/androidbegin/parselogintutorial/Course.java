package com.androidbegin.parselogintutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import com.parse.ParseUser;

public class Course extends Activity{

    Button button;
    Button button2;
    String selected;

    ParseUser user = ParseUser.getCurrentUser();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course);
        addListenerOnButtonClick();

        Spinner spinner = (Spinner)findViewById(R.id.testSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                new String[]{"Pervasive_System", "Algorithm_Design","Data_Management","Capacity_Planning"}
        );
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapter, View view,int pos, long id) {
                selected = (String)adapter.getItemAtPosition(pos);
                Toast.makeText(
                        getApplicationContext(),
                        "hai selezionato "+ selected,
                        Toast.LENGTH_LONG
                ).show();
            }
            public void onNothingSelected(AdapterView<?> arg0) {}
        });
    }

    public void addListenerOnButtonClick(){

        button=(Button)findViewById(R.id.button1);

        //Performing action on Button Click
        button.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0){

                user.put("corso", selected);
                user.saveInBackground();

                Intent intent = new Intent(Course.this,
                        ControlUser.class);
                startActivity(intent);
                finish();
            }
        });

        button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Course.this,
                        LoginSignupActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}