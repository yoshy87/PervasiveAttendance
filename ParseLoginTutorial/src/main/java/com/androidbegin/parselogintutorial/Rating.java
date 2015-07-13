package com.androidbegin.parselogintutorial;

import android.app.Activity;
import android.content.Intent;
//import android.content.Context;
import android.os.Bundle;
//import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.TextView;
import android.widget.Toast;
import android.widget.RatingBar;
//import android.telephony.TelephonyManager;



import com.parse.*;




public class Rating extends Activity {  
    RatingBar ratingbar1;
    String advicetxt;
    EditText advice;
    Button button;
    
    ParseObject rating = new ParseObject("Rating");
    
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.rating);  
        addListenerOnButtonClick();  
    }  
  
    public void addListenerOnButtonClick(){  
        ratingbar1=(RatingBar)findViewById(R.id.ratingBar1);  
        advice = (EditText) findViewById(R.id.edit_advice);
        button=(Button)findViewById(R.id.button1);  
        
        //Performing action on Button Click  
        button.setOnClickListener(new OnClickListener(){  
  
            @Override  
            public void onClick(View arg0) {  
                //Getting the rating and displaying it on the toast  
                String rate=String.valueOf((ratingbar1.getRating()));  
                advicetxt = advice.getText().toString();
                double voto = ratingbar1.getRating();
                rating.put("rate", voto);
                rating.put("advice", advicetxt);
                rating.saveInBackground();
                Toast.makeText(getApplicationContext(), rate, Toast.LENGTH_LONG).show(); 
                Intent intent = new Intent(Rating.this,
						Welcome.class);
                startActivity(intent);
				finish();
            }  
              
        });  
    }  
	
	
}
