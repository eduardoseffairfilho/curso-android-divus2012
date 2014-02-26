package com.example.curso04072012_3;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final String[] cidades = new String[] {"Manaus", "Sao Paulo", "Rio de Janeiro", "Belo Horizinte",
        		"Fortaleza", "Floripa", "Porto Alegre", "Brasilia"};
        
        ListView listViewCidades = (ListView) this.findViewById(R.id.ListViewCidades);
        CidadeAdapter cidadeAdapter = new CidadeAdapter(this, cidades);
        listViewCidades.setAdapter(cidadeAdapter);
        listViewCidades.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "Clicou em: " + cidades[arg2], Toast.LENGTH_LONG).show();
			}
        	
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
