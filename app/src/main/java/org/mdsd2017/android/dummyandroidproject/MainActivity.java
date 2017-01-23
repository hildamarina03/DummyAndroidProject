package org.mdsd2017.android.dummyandroidproject;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

/**
 * Created by hilda on 23/01/17.
 */

public class MainActivity extends Activity{

    @Override
    public void onCreate(Bundle savedInstances, PersistableBundle persistenceState){
        super.onCreate(savedInstances, persistenceState);
        setContentView(R.layout.activity_main);
    }
}
