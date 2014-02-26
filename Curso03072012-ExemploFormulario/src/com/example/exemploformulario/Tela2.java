package com.example.exemploformulario;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Tela2 extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_tela2);
        
       Bundle b = getIntent().getExtras();
       String nome = b.getString("nome");
       String telefone = b.getString("telefone");
       String endereco = b.getString("endereco");
       String mensagemCadastro = ("Nome: " + nome + "; mora no endereço: " + endereco + "; seu telefone é: " + telefone);
       //Toast.makeText(Tela2.this, mensagemCadastro, Toast.LENGTH_LONG).show();
       
       EditText et = (EditText) this.findViewById(R.id.editText4);
       et.getEditableText().append(mensagemCadastro);
       
        
        final String nomes[] = new String[] {"Eduardo", "Jorge", "Aucar", "Seffair", "Filho"};
        
        ListView listViewNomes = (ListView) this.findViewById(R.id.listView1);
        ArrayAdapter<String> nomesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomes);
        listViewNomes.setAdapter(nomesAdapter);
        listViewNomes.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {
				Toast.makeText(Tela2.this, "clicou em.. " + nomes[pos], Toast.LENGTH_LONG).show();
				
			}
        	
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_tela2, menu);
        return true;
    }

    
    
}
