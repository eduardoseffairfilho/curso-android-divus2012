package com.example.curso05072012_2;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

public class Notificacao extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		
		nm.cancel(R.string.app_name);
		
		TextView text = new TextView(this);
		text.setText("Notificação selecionada e executada!");
		setContentView(text);
	}

}
