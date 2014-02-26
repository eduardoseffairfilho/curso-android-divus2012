package com.example.curso04072012_3;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CidadeAdapter extends BaseAdapter {
	
	private Context ctx;
	private LayoutInflater inflater;
	private String[] cidades;
	
	public CidadeAdapter(Context ctx, String[] cidades) {
		super();
		this.cidades = cidades;
		this.ctx = ctx;
		inflater = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return cidades.length;
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return cidades[position];
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Log.d("ADAPTER", "Chegou no adapter.... pos=" + position);
		
		String cidade = cidades[position];
		int layout = R.layout.lista_cidades_item;
		convertView = inflater.inflate(layout, null);
		TextView nomeCidade = (TextView) convertView.findViewById(R.id.tv_cidade_nome);
		nomeCidade.setText(cidade);
		return convertView;
	}

}
