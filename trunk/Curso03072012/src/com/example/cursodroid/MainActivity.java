package com.example.cursodroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("Atividade", "Caiu no onCreate");
        
        setContentView(R.layout.activity_main);
        
        Button bt = (Button) this.findViewById(R.id.button1);
        final ImageView img= (ImageView) this.findViewById(R.id.imageView1);
        final EditText et = (EditText) this.findViewById(R.id.editText1);
        
        bt.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				img.setVisibility(View.INVISIBLE);
				
				if (et.getText() != null && et.getText().equals("")) {
					Toast.makeText(MainActivity.this, "Sr(a) " + et.getText().toString() + ", a Imagem foi removida com sucesso", Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(MainActivity.this, "Imagem  removida com sucesso", Toast.LENGTH_LONG).show();
				}
				
				Intent it = new Intent(MainActivity.this, Activity2.class);
				startActivity(it);
				
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
