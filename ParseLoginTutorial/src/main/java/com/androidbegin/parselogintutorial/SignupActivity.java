package com.androidbegin.parselogintutorial;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.telephony.TelephonyManager;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
//Cryptography for IMEI
//import com.parse.ParseACL;
//import com.parse.ParseObject;

public class SignupActivity extends Activity {
	
	// Declare Variables
	Button signup;
	String usernametxt;
	String passwordtxt;
	String nametxt;
	String surnametxt;
	String emailtxt;
	String imeitxt;
	String imeitext;

	EditText name;
	EditText surname;
	EditText email;
	EditText password;
	EditText username;
	
	TextView imei;
	
	
	
	  static String IV = "AAAAAAAAAAAAAAAA";
	   String plaintext; /*Note null padding*/
	  static String encryptionKey = "0123456789abcdef";
	
	
	public static byte[] encrypt(String plainText, String encryptionKey) throws Exception {
	    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	    SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
	    cipher.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
	    return cipher.doFinal(plainText.getBytes("ISO-8859-1"));
	  }
	 
	  public static String decrypt(byte[] cipherText, String encryptionKey) throws Exception{
	    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	    SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
	    cipher.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
	    return new String(cipher.doFinal(cipherText),"ISO-8859-1");
	  }
	  
	  
	//Get IMEI control from the phone
	String getDeviceID(TelephonyManager phonyManager){
		String plaintext = phonyManager.getDeviceId();
		if(plaintext == null) plaintext = "not available";
		return plaintext;
	}
	
	//Called when the activity is first created. 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from main.xml
		setContentView(R.layout.signupactivity);
		

		// Locate Buttons in signupactivity.xml
		//Signup = (Button) findViewById(R.id.signup);
		signup = (Button) findViewById(R.id.signup);
        name = (EditText) findViewById(R.id.edit_name);
        surname = (EditText) findViewById(R.id.edit_surname);
        email = (EditText) findViewById(R.id.edit_email);
        username = (EditText) findViewById(R.id.edit_username);
		password = (EditText) findViewById(R.id.edit_password);
		imei = (TextView) findViewById(R.id.edit_imei);
		TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
		imei.setText(getDeviceID(telephonyManager));
		
		// Sign up Button Click Listener
		signup.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// Retrieve the text entered from the EditText
				nametxt = name.getText().toString();
				surnametxt = surname.getText().toString();
				emailtxt = email.getText().toString();
				usernametxt = username.getText().toString();
				passwordtxt = password.getText().toString();
				imeitxt = imei.getText().toString();
				
				// Force user to fill up the form
				if (nametxt.equals("") && surnametxt.equals("") && emailtxt.equals("") && usernametxt.equals("") && passwordtxt.equals("")) {
					Toast.makeText(getApplicationContext(),
							"Please complete the sign up form",
								Toast.LENGTH_LONG).show();

				} else {
					
					// Save new user data into Parse.com Data Storage
					ParseUser user = new ParseUser();
					user.put("name", nametxt);
					user.put("surname", surnametxt);
					user.setEmail(emailtxt);
					user.setUsername(usernametxt);
					user.setPassword(passwordtxt);
					
					//Get Encripted IMEI
					//plaintext = imeitxt;
					
					try{
						
						Toast.makeText(getApplicationContext(),
								"Sono entrato nel try.",
								Toast.LENGTH_LONG).show();
						
						byte[] cipher = encrypt(imeitxt, encryptionKey);
						imeitext = new String(cipher, "ISO-8859-1");
						/*imeitext += "0";
						
						
						imeitxt = imeitext;
						
						
						*/
						user.put("imei", imeitext);
						
					}catch(Exception e){
						Writer writer = new StringWriter();
						PrintWriter pwr = new PrintWriter(writer);
						e.printStackTrace(pwr);
						
						Toast.makeText(getApplicationContext(),
								writer.toString(),
								Toast.LENGTH_LONG).show();
						
						e.printStackTrace();
					}
					
					//Callback
					user.signUpInBackground(new SignUpCallback() {
						public void done(ParseException e) {
							if (e == null) {
								
								// Show a simple Toast message upon successful registration
								Toast.makeText(getApplicationContext(),
										"Successfully Signed up, please log in.",
										Toast.LENGTH_LONG).show();
								
								// If user exist and authenticated, send user to Welcome.class
								Intent intent = new Intent(
										SignupActivity.this,
										Welcome.class);
								startActivity(intent);
							} else {
								Toast.makeText(getApplicationContext(),
										"Sign up Error", Toast.LENGTH_LONG)
										.show();
							}
						}
					});
				}

			}
		});

	}
	
}