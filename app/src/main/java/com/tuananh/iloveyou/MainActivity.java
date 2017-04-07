package com.tuananh.iloveyou;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener, View.OnTouchListener {
    private Button mButtonNo;
    private Button mButtonYes;
    private int mIndex;
    private int mHeight, mWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonNo = (Button) findViewById(R.id.button_no);
        mButtonYes = (Button) findViewById(R.id.button_yes);
        findViewById(R.id.button_yes).setOnClickListener(this);
        findViewById(R.id.button_no).setOnTouchListener(this);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        mHeight = displayMetrics.heightPixels;
        mWidth = displayMetrics.widthPixels;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_yes:
                showOk();
                break;
            case R.id.button_no:
                break;
        }
    }

    private void showOk() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
            .setMessage("Anh biết mà !")
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
        builder.show();
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                move();
                return true;
            default:
                return false;
        }
    }

    private void move() {
        mIndex += 1;
        switch (mIndex) {
            case 1:
                mButtonNo.setY(mButtonNo.getY() -
                    getResources().getDimensionPixelSize(R.dimen.margin_padding_150));
                break;
            case 2:
                mButtonNo.setY(mButtonNo.getY() +
                    getResources().getDimensionPixelSize(R.dimen.margin_padding_150));
                break;
            case 3:
                mButtonYes.setX(mWidth - mButtonYes.getWidth() -
                    getResources().getDimensionPixelSize(R.dimen.margin_padding_30));
                mButtonNo.setX(getResources().getDimensionPixelSize(R.dimen.margin_padding_30));
                break;
            case 4:
                mButtonNo.setX(mWidth - mButtonNo.getWidth() -
                    getResources().getDimensionPixelSize(R.dimen.margin_padding_30));
                mButtonYes.setX(getResources().getDimensionPixelSize(R.dimen.margin_padding_30));
                break;
            case 5:
                Animation moveRight =
                    AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_right);
                Animation moveLeft =
                    AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_left);
                mButtonNo.startAnimation(moveRight);
                mButtonYes.startAnimation(moveLeft);
                break;
        }
    }
}
