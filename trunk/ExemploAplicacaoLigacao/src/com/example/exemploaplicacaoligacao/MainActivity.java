package com.example.exemploaplicacaoligacao;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btLigar = (Button) this.findViewById(R.id.bt_ligar);
        btLigar.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText et = (EditText) findViewById(R.id.etTelefone);
				String numero = "";
				if (et != null && et.getText() != null) {
					numero = et.getText().toString();
				}
				
				if (!numero.isEmpty()) {
					Uri urlNumero = Uri.parse("tel:"+numero);
					Intent intent = new Intent(Intent.ACTION_CALL, urlNumero);
					startActivity(intent);
				} else {
					Toast.makeText(MainActivity.this, "Informe um número...", Toast.LENGTH_LONG).show();
				}
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
