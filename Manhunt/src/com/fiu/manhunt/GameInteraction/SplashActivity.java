package com.fiu.manhunt.GameInteraction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.fiu.manhunt.R;

public class SplashActivity extends Activity  { 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash); 
		
		Button startButton = (Button) findViewById(R.id.startButton);
		
		startButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), GameActivity.class);
				startActivity(intent);				
			}
		});
		
	}
 
} 

