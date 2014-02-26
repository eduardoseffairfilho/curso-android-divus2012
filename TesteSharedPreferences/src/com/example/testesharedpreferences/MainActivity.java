package com.example.testesharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String editText1 = settings.getString("editText1", "");
        String editText2 = settings.getString("editText2", "");
        
        EditText resultado = (EditText) this.findViewById(R.id.editText3);
        resultado.setText("Resultado: " + editText1 + " :..:..: " + editText2);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    protected void onStop() {
    	// TODO Auto-generated method stub
    	super.onStop();
    	SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        EditText editText1 = (EditText) this.findViewById(R.id.editText1);
        EditText editText2 = (EditText) this.findViewById(R.id.editText2);
		editor.putString("editText1", editText1.getText().toString());
		editor.putString("editText2", editText2.getText().toString());

        // Commit the edits!
        editor.commit();
    }
    
}
