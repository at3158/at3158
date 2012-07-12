package COM.TQC.GDD02;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class mySQLiteOpenHelper extends SQLiteOpenHelper
{
	private static final String DATABASE_NAME = "note_db";
	  private static final int DATABASE_VERSION = 1;
	  public static final String FIELD_TEXT = "note_text";
	  public static final String FIELD_id = "_id";
	  private static final String TABLE_NAME = "note_table";

	  public mySQLiteOpenHelper(Context paramContext)
	  {
	    super(paramContext, "note_db", null, 1);
	  }

	  public void delete(int paramInt)
	  {
	    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
	    String[] arrayOfString = new String[1];
	    String str = Integer.toString(paramInt);
	    arrayOfString[0] = str;
	    int i = localSQLiteDatabase.delete("note_table", "_id = ?", arrayOfString);
	  }

	  public long insert(String paramString)
	  {
	    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
	    ContentValues localContentValues = new ContentValues();
	    localContentValues.put("note_text", paramString);
	    return localSQLiteDatabase.insert("note_table", null, localContentValues);
	  }

	  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
	  {
	    paramSQLiteDatabase.execSQL("CREATE TABLE note_table (_id INTEGER primary key autoincrement,  note_text text)");
	  }

	  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
	  {
	    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS note_table");
	    onCreate(paramSQLiteDatabase);
	  }

	  public Cursor select()
	  {
	    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
	    String str1 = null;
	    String[] arrayOfString = null;
	    String str2 = null;
	    String str3 = null;
	    String str4 = null;
	    return localSQLiteDatabase.query("note_table", null, str1, arrayOfString, str2, str3, str4);
	  }

	  public void update(int paramInt, String paramString)
	  {
	    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
	    String[] arrayOfString = new String[1];
	    String str = Integer.toString(paramInt);
	    arrayOfString[0] = str;	    
	    ContentValues localContentValues = new ContentValues();
	    localContentValues.put("note_text", paramString);
	    int i = localSQLiteDatabase.update("note_table", localContentValues, "_id = ?", arrayOfString);
	  }
	}