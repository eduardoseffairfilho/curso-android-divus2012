package com.example.curso04072012;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private static final int SETTINGS = 0;
	private static final int SAVE = 1;
	private static final int EDIT = 2;
	private static final int EXIT = 3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        
        setContentView(R.layout.tela2);
        
        setContentView(R.layout.tela3);
                
        LinearLayout ll = (LinearLayout) this.findViewById(R.id.llScroll);
        
        for (int i = 0; i <= 30; i++) {
        	TextView tv = new TextView(this);
        	tv.setText("Teste: " + i);
        	ll.addView(tv);
        }
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        
        /*MenuItem item = menu.add(menu.NONE, SETTINGS, 0, "Settings");
        
        
        SubMenu sub = menu.addSubMenu("+");
        sub.add(0,5,0,"Search");
        sub.add(0,5,0,"Print");
        */
        return true;
    }

    
}
