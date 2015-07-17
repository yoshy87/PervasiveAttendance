package com.androidbegin.parselogintutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class CheckLessonPercentage extends Activity {

    Button button2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklessonpercentage);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Course_hour");
        query.whereEqualTo("Course", "Pervasive_System");

        // Retrieve the object by id
        query.getFirstInBackground(new GetCallback<ParseObject>() {
            public void done(ParseObject query, ParseException e) {
                ParseUser user = ParseUser.getCurrentUser();
                ParseQuery<ParseObject> query2 = ParseQuery.getQuery("Hours");
                final String course = user.get("corso").toString();


                String ore = query.get("Class_H").toString();
                final double hour = Double.parseDouble(ore);

                query2.whereEqualTo("Matricola", user.get("username").toString());
                query2.getFirstInBackground(new GetCallback<ParseObject>() {

                    public void done(ParseObject query2, ParseException e) {

                            String ore2 = query2.get(course).toString();
                            double hour2 = Double.parseDouble(ore2);
                            final double percentage = hour2/hour;

                            String no_exam = "You cannot do the exam: " + (percentage*100) +"% lesson attend";
                            String yes_exam = "You can do the exam: " + (percentage*100) +"% lesson attend";
                            if (percentage < 0.75) {
                                Toast.makeText(
                                    getApplicationContext(),
                                    no_exam,
                                    Toast.LENGTH_LONG).show();
                            }else
                                Toast.makeText(
                                    getApplicationContext(),
                                    yes_exam,
                                    Toast.LENGTH_LONG).show();
                        }
                    });
            }
        });

        button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(CheckLessonPercentage.this,
                        Welcome.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
