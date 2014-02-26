package com.example.exemploabrebrowser;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	private String urlPadrao = "http://www.google.com.br/";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btAbrirBrowser = (Button) this.findViewById(R.id.bt_abrir_browser);
        btAbrirBrowser.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText campoUrl = (EditText) findViewById(R.id.etEndereco);
				if (campoUrl.getText().toString() == null || campoUrl.getText().toString().equals(""))
					campoUrl.setText(urlPadrao);
				
				Uri uri = Uri.parse(campoUrl.getText().toString());
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(intent);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
