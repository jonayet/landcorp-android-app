package BLL;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import helper.DataBase;

public class LinkStore {
    private DataBase schema;
    private SQLiteDatabase db;

    public LinkStore(DataBase db){
        this.schema = db;
        this.db = db.getWritableDatabase();
    }

    public String getLink(String id){
        Cursor cursor=db.rawQuery("SELECT " + schema.URL + " FROM " + schema.TABLE + " WHERE " + schema.ID + " ='" + id + "'", null);
        cursor.moveToFirst();
        String data=cursor.getString(0);
        cursor.close();
        return data;
    }

    public int insertData(String name,String link){
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("link", link);
        int result= (int) db.insert(schema.TABLE, null, contentValues);
        contentValues.clear();
        return result;
    }


}
