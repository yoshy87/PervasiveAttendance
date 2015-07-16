package com.androidbegin.parselogintutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;

public class WelcomeProf extends Activity {

    // Declare Variable
    Button logout;
    Button signature;
    Button postsignature;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.welcomeprof);

        // Retrieve current user from Parse.com
        ParseUser currentUser = ParseUser.getCurrentUser();
        // Convert currentUser into String
        // Locate TextView in welcome.xml
        TextView txtuser = (TextView) findViewById(R.id.txtuser);

        // Set the currentUser String into TextView
        signature = (Button) findViewById(R.id.signature);

        signature.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent intent = new Intent(WelcomeProf.this,
                        SignatureProf.class);
                startActivity(intent);
                finish();
            }
        });

        //Signature Button Click Listener
        postsignature = (Button) findViewById(R.id.postsignature);

        postsignature.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent intent = new Intent(WelcomeProf.this,
                        PostSignatureProf.class);
                startActivity(intent);
                finish();
            }
        });

        logout = (Button) findViewById(R.id.logout);

        // Logout Button Click Listener
        logout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent intent = new Intent(WelcomeProf.this,
                        LoginSignupActivity.class);
                ParseUser.logOut();
                startActivity(intent);
                finish();
            }
        });

    }
}
