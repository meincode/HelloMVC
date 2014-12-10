package com.example.hellomvc;
 
import java.util.Observable;  
import java.util.Observer;  

import com.example.hellomvc.model.Model;

import android.app.Activity;  
import android.os.Bundle;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.widget.Button;  

public class MainActivity extends Activity implements Observer, OnClickListener{  
    private Model mModel;  
    private Button mButton1, mButton2;  
         
    /** Called when the activity is first created. */  
    @Override  
    public void onCreate(Bundle savedInstanceState) {   
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
        mModel = new Model();  
        mModel.addObserver(this);  
        mButton1 = (Button)findViewById(R.id.button1);  
        mButton2 = (Button)findViewById(R.id.button2);  
        mButton1.setOnClickListener(this);  
        mButton2.setOnClickListener(this);  
    }   
         
    public void onClick(View arg0) {   
        // TODO Auto-generated method stub  
        switch(arg0.getId()){  
        case R.id.button1:  
            mModel.setDataAtIndex(0);  
            break;  
        case R.id.button2:  
            mModel.setDataAtIndex(1);  
            break;  
        }   
    }   
    public void update(Observable observable, Object data) {   
        // TODO Auto-generated method stub  
        mButton1.setText("Count : " + mModel.getDataAtIndex(0));  
        mButton2.setText("Count : " + mModel.getDataAtIndex(1));  
    }   
}