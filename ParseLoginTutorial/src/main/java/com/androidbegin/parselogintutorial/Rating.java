package com.androidbegin.parselogintutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.RatingBar;
import com.parse.*;

public class Rating extends Activity {  
    RatingBar ratingbar1;
    RatingBar ratingbar2;
    RatingBar ratingbar3;
    String advicetxt;
    String advicetxt2;
    String advicetxt3;
    EditText advice;
    EditText advice2;
    EditText advice3;
    Button button;
    Button button2;

    ParseObject rating = new ParseObject("Rating");
    
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.rating);  
        addListenerOnButtonClick();
    }  
  
    public void addListenerOnButtonClick(){  
        ratingbar1=(RatingBar)findViewById(R.id.ratingBar1);
        ratingbar2=(RatingBar)findViewById(R.id.ratingBar2);
        ratingbar3=(RatingBar)findViewById(R.id.ratingBar3);
        advice = (EditText) findViewById(R.id.edit_advice);
        advice2 = (EditText) findViewById(R.id.edit_advice2);
        advice3 = (EditText) findViewById(R.id.edit_advice3);
        button=(Button)findViewById(R.id.button1);  
        
        //Performing action on Button Click  
        button.setOnClickListener(new OnClickListener(){  
  
            @Override  
            public void onClick(View arg0){
                //Getting the rating and displaying it on the toast
                String rate = String.valueOf((ratingbar1.getRating()));
                advicetxt = advice.getText().toString();

                String rate2 = String.valueOf((ratingbar2.getRating()));
                advicetxt2 = advice2.getText().toString();

                String rate3 = String.valueOf((ratingbar3.getRating()));
                advicetxt3 = advice3.getText().toString();

                double voto = ratingbar1.getRating();
                double voto2 = ratingbar2.getRating();
                double voto3 = ratingbar3.getRating();

                rating.put("Listening", voto);
                rating.put("ListeningLesson", advicetxt);
                rating.saveInBackground();

                rating.put("Interest", voto2);
                rating.put("InterestLesson", advicetxt2);
                rating.saveInBackground();

                rating.put("Understanding", voto3);
                rating.put("UnderstandingLesson", advicetxt3);
                rating.saveInBackground();

                Toast.makeText(getApplicationContext(), "Thank you for rating", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Rating.this,
						Welcome.class);
                startActivity(intent);
            }
              
        });

        button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Rating.this,
                        Welcome.class);
                startActivity(intent);
                finish();
            }
        });
    }  
	
	
}
