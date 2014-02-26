package br.com.curso;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class Database extends OpenHelper {

	private SQLiteDatabase db;

	Database(Context context) {
		super(context);
	}

	public void insertAluno(String nome, int idade, String endereco) {

		ContentValues cv = new ContentValues();

		cv.put("nome_aluno", nome);
		cv.put("idade_aluno", idade);
		cv.put("endereco", endereco);

		this.db = getWritableDatabase();

		this.db.insert("aluno", null, cv);

		db.close();
	}

	public void atualizarAluno(String nome, int idade, String endereco, long id) {

		ContentValues cv = new ContentValues();

		cv.put("nome_aluno", nome);
		cv.put("idade_aluno", idade);
		cv.put("endereco", endereco);

		this.db = getWritableDatabase();

		db.update("aluno", cv, BaseColumns._ID + " = ?",
				new String[] { String.valueOf(id) });
	}

	public void excluirAluno(long id) {
		this.db = getWritableDatabase();

		this.db.delete("aluno", BaseColumns._ID + " = ?",
				new String[] { String.valueOf(id) });

	}

	public List<Aluno> listarAlunos() {

		db = this.getReadableDatabase();
		Cursor cursor = db.query("aluno", null, null, null, null, null, null);
	
		
		List<Aluno> list = new ArrayList<Aluno>();

		while (cursor.moveToNext()) {
			Aluno aluno = new Aluno();
			aluno.setNomeAluno(cursor.getString(cursor
					.getColumnIndex("nome_aluno")));
			aluno.setIdadeAluno(cursor.getInt(cursor
					.getColumnIndex("idade_aluno")));
			aluno.setEnderecoAluno(cursor.getString(cursor
					.getColumnIndex("endereco")));
			list.add(aluno);
		}
		cursor.close();
		db.close();

		return list;

	}

}

class OpenHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "curso_android.db";
	private static final int DATABASE_VERSION = 1;

	OpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		this.createTables(db);
	}

	private void createTables(SQLiteDatabase db) {
		StringBuilder sql = new StringBuilder();
		sql.append("CREATE TABLE aluno (");
		sql.append(BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ");
		sql.append("nome_aluno VARCHAR(100), ");
		sql.append("idade_aluno INTEGER(100), ");
		sql.append(" endereco VARCHAR(200)); ");

		db.execSQL(sql.toString());

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);

		onCreate(db);
	}
}
