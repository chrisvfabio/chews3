package co.chagas.chews3.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by andreachagas on 27/04/15.
 */
public class MyDBhelper extends SQLiteOpenHelper {
    private static final String CREATE_TABLE = "create table " +
            Constants.TABLE_NAME + " (" +
            Constants.KEY_ID + " integer primary key autoincrement, " +
            Constants.TITLE_NAME + " text not null, " +
            Constants.ADDRESS_NAME + " text not null, " +
            Constants.TYPE_NAME + " text null, " +
            Constants.COMMENT_NAME + " text null)" ;

    public MyDBhelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        Log.v("MyDBhelper onCreate", "Creating all the tables");
        try{
            db.execSQL(CREATE_TABLE);
        } catch(SQLiteException ex){
            Log.v("Create table exception", ex.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.w("TaskDBAdapter", "Upgrading from version " + oldVersion + " to " + newVersion
                                                         + ", which will destroy all old data");
        db.execSQL("drop table if exists " + Constants.TABLE_NAME);
        onCreate(db);
    }
}
