package com.example.cursodroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class Activity2 extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_activity2, menu);
        return true;
    }

    
}
