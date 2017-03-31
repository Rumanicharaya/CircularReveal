package com.example.ideal.transitionanimation;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout revealView;
    View viewRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        revealView = (LinearLayout) findViewById(R.id.linear_layout);

    }

    public void onClick(View viewRoot) {

        int cx = (revealView.getLeft() + revealView.getRight())/2;
        int cy = (revealView.getTop() + revealView.getBottom())/2;
        int finalRadius = (int) Math.hypot((double) revealView.getWidth(), (double) revealView.getHeight());

        Animator anim = ViewAnimationUtils.createCircularReveal(revealView, cx, cy, 0, finalRadius);
        revealView.setVisibility(View.VISIBLE);
        anim.setDuration(1000);
        anim.setInterpolator(new LinearInterpolator());
        anim.start();

    }
}
