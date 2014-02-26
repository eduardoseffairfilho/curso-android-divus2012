package com.example.curso05072012_2;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class CriaNotificacao extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        
        TextView text = new TextView(this);
        text.setText("Notificação recebida.....");
        setContentView(text);
        
        String msgBarraStatus = "Você recebeu uma nova mensagem!!";
        CharSequence titulo = "Hello Divus";
        CharSequence mensagem = "Exemplo de Notificação";
        
        criarNotificacao(msgBarraStatus, titulo, mensagem, CriaNotificacao.class);
        
    }

    protected void criarNotificacao(String msgBarraStatus, CharSequence titulo,
			CharSequence mensagem, Class<?>activity) {
		// TODO Auto-generated method stub
		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		
		Notification n = new Notification(R.drawable.ic_launcher, msgBarraStatus, System.currentTimeMillis());
		
		PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, activity), 0);
		
		n.setLatestEventInfo(this, titulo, mensagem, pi);
		
		n.vibrate = new long[] {100, 250, 100, 500};
		
		nm.notify(R.string.app_name, n);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
