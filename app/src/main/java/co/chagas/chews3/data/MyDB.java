package co.chagas.chews3.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

/**
 * Created by andreachagas on 27/04/15.
 */
public class MyDB {
    private SQLiteDatabase db;
    private final Context context;
    private final MyDBhelper dbhelper;

    public MyDB(Context c) {
        context = c;
        dbhelper = new MyDBhelper(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    public void close(){
        db.close();
    }

    public void open() throws SQLiteException{
        try {
            db = dbhelper.getWritableDatabase();
        } catch (SQLiteException ex){
            Log.v("Open database exception caught", ex.getMessage());
            db = dbhelper.getReadableDatabase();
        }
    }

    public long insertRestaurant(String title, String address, String type, String comments){
        try{
            ContentValues newTaskValue = new ContentValues();
            newTaskValue.put(Constants.TITLE_NAME, title);
            newTaskValue.put(Constants.ADDRESS_NAME, address);
            newTaskValue.put(Constants.TYPE_NAME, type);
            newTaskValue.put(Constants.COMMENT_NAME, comments);

            return db.insert(Constants.TABLE_NAME, null, newTaskValue);
        }catch (SQLiteException ex){
            Log.v("Insert into database exception caught", ex.getMessage());
            return -1;
        }
    }

    public Cursor getRestuarants(){
        Cursor c = db.query(Constants.TABLE_NAME, null, null, null, null, null, null);
        return c;
    }
}
