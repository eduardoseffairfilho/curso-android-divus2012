package br.com.eseffair.logyourcall;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements SensorEventListener {
	SensorManager sensorManager;
	Sensor proximitySensor;
	Gravador gravador;
	boolean isRecording = false;
	boolean isDialing = false;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        /** Preparar os sensores. */
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        
		/** Prepara a gravação. */
		preparaGravacao();
		
		/** Prepara os botões. */
        prepareButtons();
    }

	
    
	@Override
	protected void onResume() {
		if (proximitySensor == null) {
			Toast.makeText(this, "Sensor de proximidade não disponível", Toast.LENGTH_SHORT).show();
		} else {
			sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
		}

		super.onResume();
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		sensorManager.unregisterListener(this);
		super.onDestroy();
	}
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		setContentView(R.layout.activity_main);
		
		prepareButtons();
	}
	
	protected void preparaGravacao() {
		/** Prepara a gravação. */
        String dataHora = new SimpleDateFormat("yyyyMMdd'-'HHmmss").format(new Date());
        gravador = new Gravador("appLogYourCall"+dataHora);
	}
	protected void prepareButtons() {
		/** Prepara os botões. */
		Button btGravarSomStart = (Button) findViewById(R.id.btGravarSomStart);
	    Button btGravarSomStop = (Button) findViewById(R.id.btBGravarSomStop);
	    
	    btGravarSomStart.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "Discando..", Toast.LENGTH_LONG).show();
				
				/** Recebe o Numero informado na tela. */
				EditText et = (EditText) findViewById(R.id.etNumero);
				String numero = "";
				if (et != null && et.getText() != null) {
					numero = et.getText().toString();
				}
				
				/** Efetua a Ligação. */
				if (!numero.isEmpty()) {
					isDialing = true;
					
					Uri urlNumero = Uri.parse("tel:"+numero);
					Intent intent = new Intent(Intent.ACTION_CALL, urlNumero);
					startActivity(intent);
				} else {
					Toast.makeText(MainActivity.this, "Informe um número...", Toast.LENGTH_LONG).show();
				}
			}
		});
	    
	    btGravarSomStop.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (isRecording) {
					try { 
						Toast.makeText(MainActivity.this, "Parando gravação..", Toast.LENGTH_LONG).show();
						gravador.stop();
						isRecording = false;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}

	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
			
			Log.d("Sensor de proximidade", "vendor:" + proximitySensor.getVendor());
			Log.d("Sensor de proximidade", "event.values[0]:"+event.values[0] + " <-> MaximumRange():" + proximitySensor.getMaximumRange());
			
			if (event.values[0] == 0.0) { //if (event.values[0] < proximitySensor.getMaximumRange()) {
				Toast.makeText(this, "Sensor - aproximou", Toast.LENGTH_SHORT).show();

				/** Inicia o gravador. */
				if ((isRecording == false) && (isDialing == true)) {
					try { 
						Toast.makeText(this, "Iniciando gravação..", Toast.LENGTH_LONG).show();
						gravador.start();
						isRecording = true;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				Toast.makeText(this, "Sensor - afastou", Toast.LENGTH_SHORT).show();
			}

		}
	}
}
