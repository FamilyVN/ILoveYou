package com.tuananh.iloveyou;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener, View.OnTouchListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_ok).setOnClickListener(this);
        findViewById(R.id.button_no).setOnClickListener(this);
        findViewById(R.id.button_no).setOnTouchListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_ok:
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
        Log.d("-----------", "---------- event.getAction() = " + event.getAction());
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_BUTTON_PRESS:
//                Log.d("-----------", "---------- ACTION_BUTTON_PRESS");
//                return true;
//            case MotionEvent.ACTION_DOWN:
//                Log.d("-----------", "---------- ACTION_DOWN");
//                return true;
//            case MotionEvent.ACTION_UP:
//                Log.d("-----------", "---------- ACTION_UP");
//                return true;
//            default:
                return false;
//        }
    }
}
