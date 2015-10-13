package com.androidbegin.parselogintutorial;

import com.parse.ParseUser;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Welcome extends Activity {

    // Declare Variable
    Button logout;
    Button rating;
    Button signature;
    Button check;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.welcome);

        // Retrieve current user from Parse.com
        ParseUser currentUser = ParseUser.getCurrentUser();

        // Convert currentUser into String
        String struser = currentUser.getUsername().toString();

        // Locate TextView in welcome.xml
        TextView txtuser = (TextView) findViewById(R.id.txtuser);



            logout = (Button) findViewById(R.id.logout);

            // Logout Button Click Listener
            logout.setOnClickListener(new OnClickListener() {

                public void onClick(View arg0) {
                    Intent intent = new Intent(Welcome.this,
                            LoginSignupActivity.class);
                    ParseUser.logOut();
                    startActivity(intent);
                    finish();
                }
            });

            txtuser.setText("You are logged in as " + struser);

            rating = (Button) findViewById(R.id.button1);

            rating.setOnClickListener(new OnClickListener(){

                public void onClick(View arg0){
                    Intent intent = new Intent(Welcome.this,
                            Rating.class);
                    startActivity(intent);
                    finish();
                }
            });

            // Locate Button in welcome.xml
            logout = (Button) findViewById(R.id.logout);

            // Logout Button Click Listener
            logout.setOnClickListener(new OnClickListener() {

                public void onClick(View arg0) {
                    Intent intent = new Intent(Welcome.this,
                            LoginSignupActivity.class);
                    ParseUser.logOut();
                    startActivity(intent);
                    finish();
                }
            });
            //Signature Button Click Listener
            signature = (Button) findViewById(R.id.signature);

            signature.setOnClickListener(new OnClickListener() {

                public void onClick(View arg0) {
                    Intent intent = new Intent(Welcome.this,
                            Signature.class);
                    startActivity(intent);
                    finish();
                }
            });

            check = (Button) findViewById(R.id.check);

            check.setOnClickListener(new OnClickListener() {

                public void onClick(View arg0) {
                    Intent intent = new Intent(Welcome.this,
                            CheckLessonPercentage.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
   }