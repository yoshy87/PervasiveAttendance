package com.androidbegin.parselogintutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;

public class ControlUser extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParseUser currentUser = ParseUser.getCurrentUser();

        if (currentUser.getBoolean("Professor")) {
            Intent intent = new Intent(ControlUser.this,
                    WelcomeProf.class);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(ControlUser.this,
                    Welcome.class);
            startActivity(intent);
            finish();
        }
    }
}

