package org.mdsd2017.android.dummyandroidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by hilda on 23/01/17.
 */


public class MainActivity extends Activity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView myTInfo;

    @Override
    public void onCreate(Bundle savedInstances){
        super.onCreate(savedInstances);
        setContentView(R.layout.activity_main);

        Button btnStartActivity = (Button) findViewById(R.id.btn_main_activity_start_activity);
        btnStartActivity.setOnClickListener(this);

        Button btn2StartActivity = (Button) findViewById(R.id.btn_2_main_activity_start_activity);
        btn2StartActivity.setOnClickListener(this);

        Button btn3StartActivity = (Button) findViewById(R.id.btn_3_main_activity_start_activity);
        btn3StartActivity.setOnClickListener(this);

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        this.myTInfo = (TextView) findViewById(R.id.tv_info_main_activity);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "onResume", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(this, "onPause", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, "onStop", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(this, "onRestart", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View whichView) {
        if(whichView.getId() == R.id.btn_main_activity_start_activity){
            Log.e("OnClickClass", "Button 1 clicked");

        }else if(whichView.getId() == R.id.btn_2_main_activity_start_activity){
            Log.e("OnClickClass", "Button 2 clicked");

            Intent intent = new Intent(this, SecondActivity.class);
//            startActivity(intent);
            startActivityForResult(intent, 0);

        }else{
            Log.e("OnClickClass", "Button 3 clicked");

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.w(MainActivity.TAG, "In-onActivityResult");

        if(requestCode == 0 && resultCode == Activity.RESULT_OK){
            String returnData = data.getStringExtra("MyMessage");
            Log.e(MainActivity.TAG, returnData);

            this.myTInfo.setText(returnData);

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle SavedInstanceState) {
        super.onSaveInstanceState(SavedInstanceState);
        SavedInstanceState.putString("my texview value", this.myTInfo.getText().toString());
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String returnString = savedInstanceState.getString("my texview value", "nothing to return");
        this.myTInfo.setText(returnString);
    }
}
