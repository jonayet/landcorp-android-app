package BLL;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import helper.DataBase;
import helper.DataBaseData;

public class LinkStore {
    private DataBase schema;
    private SQLiteDatabase db;
    private ArrayList<DataBaseData> allDataList = new ArrayList<>();
    ;

    public LinkStore(DataBase db) {
        this.schema = db;
        this.db = db.getWritableDatabase();
        getDataBaseData();

    }

    private void getDataBaseData() {
        Cursor cursor = db.rawQuery("SELECT * FROM " + schema.TABLE, null);

        while (cursor.moveToNext()) {
            allDataList.add(new DataBaseData(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
        }
        cursor.close();
    }

    public void updateBoth(String id,String name, String link) {
        db.execSQL("UPDATE "+schema.TABLE+" SET "+schema.LABEL+" ='"+name+"', "+schema.URL+" ='"+link+"' WHERE "+schema.ID+" ='"+id+"'");

    }

    public void updateLink(String id,String link) {
        db.execSQL("UPDATE "+schema.TABLE+" SET "+schema.URL+" ='"+link+"' WHERE "+schema.ID+" ='"+id+"'");


    }

    public void updateName(String id,String name) {
        db.execSQL("UPDATE "+schema.TABLE+" SET "+schema.LABEL+" ='"+name+"' WHERE "+schema.ID+" ='"+id+"'");



    }


    public String getLink(String buttonId){
        for (DataBaseData data:allDataList
             ) {
            if (data.id.equals(buttonId)){
                return data.link;
            }
        }
        return null;
    }

    public DataBaseData getData(String buttonId){
        for (DataBaseData data:allDataList
                ) {
            if (data.id.equals(buttonId)){
                return data;
            }
        }

        return null;
    }

    public String getName(int position){
        return allDataList.get(position).name;
    }

    public String getId(int position){
        return allDataList.get(position).id;
    }




}
