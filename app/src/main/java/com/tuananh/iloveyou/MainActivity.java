package com.tuananh.iloveyou;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener, View.OnTouchListener {
    private Button mButtonNo;
    private Button mButtonYes;
    private int mIndex;
    private int mX1, mX2, mY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonNo = (Button) findViewById(R.id.button_no);
        mButtonYes = (Button) findViewById(R.id.button_yes);
        mButtonYes.setOnClickListener(this);
        mButtonNo.setOnTouchListener(this);
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
            .setMessage("Anh biết mà, <3")
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

    private void reset() {
        mButtonYes.setX(mX1);
        mButtonYes.setY(mY);
        mButtonNo.setX(mX2);
        mButtonNo.setY(mY);
    }

    private void move() {
        mIndex = mIndex < 7 ? mIndex += 1 : 1;
        switch (mIndex) {
            case 0:
                reset();
                break;
            case 1:
                mButtonNo.setY(mButtonNo.getY() -
                    getResources().getDimensionPixelSize(R.dimen.margin_padding_100));
                mX1 = (int) mButtonYes.getX();
                mX2 = (int) mButtonNo.getX();
                mY = (int) mButtonYes.getY();
                break;
            case 2:
                mButtonNo.setY(mButtonNo.getY() +
                    getResources().getDimensionPixelSize(R.dimen.margin_padding_100));
                break;
            case 3:
                mButtonYes.setX(mX2);
                mButtonNo.setX(mX1);
                break;
            case 4:
                mButtonYes.setX(mX1);
                mButtonNo.setX(mX2);
                break;
            case 5:
                mButtonNo.setY(mButtonNo.getY() +
                    getResources().getDimensionPixelSize(R.dimen.margin_padding_100));
                break;
            case 6:
                mButtonNo.setY(mButtonNo.getY() -
                    getResources().getDimensionPixelSize(R.dimen.margin_padding_200));
                break;
            case 7:
                mButtonNo.setY(mButtonNo.getY() +
                    getResources().getDimensionPixelSize(R.dimen.margin_padding_100));
                break;
        }
    }
}
