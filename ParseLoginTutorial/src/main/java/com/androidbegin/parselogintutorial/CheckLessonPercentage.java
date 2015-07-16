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

    int min_hours;
    Button button2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklessonpercentage);
        ParseUser user = ParseUser.getCurrentUser();

        String course = user.get("corso").toString();
        String follow = user.get(course).toString();
        final int hours = Integer.parseInt(follow);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Course_hour");
        query.whereEqualTo("Course", "Pervasive_System");

        // Retrieve the object by id
        query.getFirstInBackground(new GetCallback<ParseObject>() {
            public void done(ParseObject query, ParseException e) {
                TextView txtuser = (TextView) findViewById(R.id.txtuser);

                if (query == null) {
                    Log.d("score", "The getFirst request failed.");
                } else {
                    String min = query.get("Class_H").toString();
                    min_hours = Integer.parseInt(min);
                    Log.d("score", "Retrieved the object.");
                    int percentage = (hours/min_hours);
                    if (percentage < 0.75) {
                        txtuser.setText("You cannot do the exam: " + percentage*100+"% lesson attend");
                    }else
                        txtuser.setText("You can do the exam: " + percentage*100+"% lesson attend");
                }
            }
        });
    }
}
