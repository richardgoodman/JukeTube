package com.richardgoodman.juketube;

import com.example.myfirstapp.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	private float x1,x2,y1,y2;
	static final int MIN_DISTANCE = 150;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void speakButtonClicked(View v)
    {
	    Intent i = new Intent(MainActivity.this, VoiceRecognition.class);
	    startActivity(i);
	    finish();
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {     
        switch(event.getAction())
        {
          	case MotionEvent.ACTION_DOWN:
          		x1 = event.getX();
          		y1 = event.getY();
          		break;         
          	case MotionEvent.ACTION_UP:
          		x2 = event.getX();
          		y2 = event.getY();
          		float deltaX = x2 - x1;
          		float deltaY = y2 - y1;
          		
          		if (deltaX > deltaY)
          		{
          			if (Math.abs(deltaX) > MIN_DISTANCE)
	          		{
	          			if (x2 > x1)
	          			{
	          				Toast.makeText(this, "Left to Right swipe", Toast.LENGTH_SHORT).show ();
	          			}
	          			else
	          			{
	          				Toast.makeText(this, "Right to Left swipe", Toast.LENGTH_SHORT).show ();
	          			}
	          		}
          		}
          		else
          		{
          			if (Math.abs(deltaY) > MIN_DISTANCE)
	          		{
	          			if (y2 > y1)
	          			{
	          				Toast.makeText(this, "Down to Up swipe", Toast.LENGTH_SHORT).show ();
	          			}
	          			else
	          			{
	          				Toast.makeText(this, "Up to Down swipe", Toast.LENGTH_SHORT).show ();
	          			}
	          		}
          		}
          		break;   
        	}           
        	return super.onTouchEvent(event);       
    }
}
