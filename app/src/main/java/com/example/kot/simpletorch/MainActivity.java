package com.example.kot.simpletorch;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.hardware.Camera;
import android.support.v4.widget.CompoundButtonCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.ToggleButton;


import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import static android.widget.CompoundButton.*;

public class MainActivity extends AppCompatActivity {

    ToggleButton myToggleButton;
    Camera myCamera;
    //ImageView myImageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton myToggleButton = (ToggleButton) findViewById(R.id.toggleButtonMain);
        final ImageView myImageView = (ImageView) findViewById(R.id.imageViewMain);



        myToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {




                if(isChecked){

                    //myImageView.setImageResource(R.drawable.light);
                   // myImageView.setBackgroundColor(getResources().getColor(R.color.colorMyBulbOn));
                   // myImageView.setBackgroundResource();
                    //myImageView.setBackgroundResource(0);
                    myImageView.setBackgroundResource(R.drawable.light);
                    torchOn();


                    }else{
                   // myImageView.setBackgroundColor(getResources().getColor(R.color.colorMyBulbOff));
                   //myImageView.setImageResource(R.drawable.black);
                    //myImageView.setBackgroundResource();
                   // myImageView.setBackgroundResource(0);
                    myImageView.setBackgroundResource(R.drawable.black);
                    torchOff();
            }
        }});





    }
    public void torchOn(){
        myCamera=Camera.open();
        Camera.Parameters parameters = myCamera.getParameters();
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        myCamera.setParameters(parameters);
        myCamera.startPreview();
    }
    public void torchOff(){

        myCamera.stopPreview();
        myCamera.release();
    }



}








