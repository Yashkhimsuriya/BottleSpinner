package com.yash.bottlespinner;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView bottleImage;
    int currentpoint;
    int nextpoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottleImage = findViewById(R.id.bottle);

        bottleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinTheBottle();
            }
        });
    }

    void spinTheBottle()
    {
        nextpoint = new Random().nextInt(10000);

        int pX = bottleImage.getWidth()/2;
        int pY = bottleImage.getHeight()/2;

        Animation rotate = new RotateAnimation(currentpoint,nextpoint,pX,pY);

        rotate.setDuration(3000);
        rotate.setFillAfter(true);

        currentpoint = nextpoint;

        bottleImage.startAnimation(rotate);
    }
}