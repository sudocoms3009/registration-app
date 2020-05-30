package com.example.facultyhandbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class GovernanceActivity extends AppCompatActivity {

    ImageView page1, page2, back;
    RelativeLayout right, left;
    private ScaleGestureDetector scaleGestureDetector;
    private float mScaleFactor = 1.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_governance);
        getSupportActionBar().hide();

        page1 = findViewById(R.id.page1);
        page2 = findViewById(R.id.page2);
        right = findViewById(R.id.box1);
        left = findViewById(R.id.box2);
        back = findViewById(R.id.back);
        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page1.setVisibility(View.GONE);
                page2.setVisibility(View.VISIBLE);
                right.setVisibility(View.GONE);
                left.setVisibility(View.VISIBLE);
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                page2.setVisibility(View.GONE);
                page1.setVisibility(View.VISIBLE);
                left.setVisibility(View.GONE);
                right.setVisibility(View.VISIBLE);

            }
        });


    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){

        scaleGestureDetector.onTouchEvent(motionEvent);

        return true;
    }

    private class ScaleListener extends  ScaleGestureDetector.SimpleOnScaleGestureListener{
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {

            mScaleFactor *= scaleGestureDetector.getScaleFactor();
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 10.0f));
            page1.setScaleX(mScaleFactor);
            page1.setScaleY(mScaleFactor);

            page2.setScaleX(mScaleFactor);
            page2.setScaleY(mScaleFactor);

            return true;
        }
    }
}
