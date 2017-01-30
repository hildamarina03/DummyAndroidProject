package org.mdsd2017.android.dummyandroidproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btnDoSomething = (Button) findViewById(R.id.btn_second_activity_return_info);
        btnDoSomething.setOnClickListener(this);
    }

    @Override
    public void onClick(View whichView) {

        if(whichView.getId() == R.id.btn_second_activity_return_info){

            Log.e("OnClickClass", "Button in second activity clicked");
            Intent returnIntent = new Intent();
            returnIntent.putExtra("MyMessage", "Hello World");
            setResult(Activity.RESULT_OK, returnIntent);
            finish();

        }
    }
}
