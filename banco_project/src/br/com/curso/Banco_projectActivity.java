package br.com.curso;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class Banco_projectActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Database db = new Database(this);
        
        
        
        db.insertAluno("Eduardo", 25, "Adrainopolos");
        
        Toast.makeText(this, "inserido com sucesso", Toast.LENGTH_SHORT).show();
        
        
        
    }
}