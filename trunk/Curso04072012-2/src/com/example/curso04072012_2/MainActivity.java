package com.example.curso04072012_2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final String  cidades[] = new String[] {"Manaus", "Boa Vista", "Belém", "São Paulo"};
        
        Spinner spinner = (Spinner) this.findViewById(R.id.cidades);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cidades);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        	
        	public void onItemSelected(AdapterView<?> arg0, View arg1,
        			int arg2, long arg3) {
        		Toast.makeText(MainActivity.this, "Cidade escolhida:" + cidades[arg2], Toast.LENGTH_LONG).show();
        	}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
