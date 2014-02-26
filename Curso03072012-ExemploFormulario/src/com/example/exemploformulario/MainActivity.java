package com.example.exemploformulario;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText nome;
	private EditText telefone;
	private EditText endereco;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button bt = (Button) this.findViewById(R.id.button1);
		nome = (EditText) this.findViewById(R.id.editText1);
		telefone = (EditText) this.findViewById(R.id.editText2);
		endereco = (EditText) this.findViewById(R.id.editText3);
        
        bt.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				
				String mensagemCadastro = ("Nome: " + nome.getText().toString() + "; mora no endereço: " + endereco.getText().toString() + "; seu telefone é: " + telefone.getText().toString());
				
				Toast.makeText(MainActivity.this, "Cadastro realizado com sucesso!\n" + mensagemCadastro, Toast.LENGTH_LONG).show();
				
				Bundle b= new Bundle();
		    	b.putString("nome", nome.getText().toString());
		    	b.putString("telefone", telefone.getText().toString());
		    	b.putString("endereco", endereco.getText().toString());
				
				Intent it = new Intent(MainActivity.this, Tela2.class);
				it.putExtras(b);
				startActivity(it);
			}
		});
        
        Button bt2 = (Button) this.findViewById(R.id.button2);
        bt2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				lerCodBarras();
			}
		});
        
    }
    
    private void lerCodBarras() {
    	Intent it = new Intent("com.google.zxing.client.android.SCAN");
    	startActivityForResult(it, 0);
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	if (requestCode==0) {
    		if (resultCode == RESULT_OK) {
    			String codBarras = data.getStringExtra("SCAN_RESULT");
    			Toast.makeText(MainActivity.this, "cod barras lido: " + codBarras, Toast.LENGTH_LONG).show();
    		}
    	}
    	
    	super.onActivityResult(requestCode, resultCode, data);
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
