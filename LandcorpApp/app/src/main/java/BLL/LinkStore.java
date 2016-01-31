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

    public void update(String id,String name, String link) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("link", link);
       // int result = db.update(schema.TABLE,contentValues);
        contentValues.clear();
        return ;
    }
//    public int update(String name) {
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name", name);
//        //contentValues.put("link", link);
//        int result = (int) db.insert(schema.TABLE, null, contentValues);
//        contentValues.clear();
//        return result;
//    }
//    public int update(String link) {
//        ContentValues contentValues = new ContentValues();
//       // contentValues.put("name", name);
//        contentValues.put("link", link);
//        int result = (int) db.insert(schema.TABLE, null, contentValues);
//        contentValues.clear();
//        return result;
//    }

    public String getLink(String buttonId){
        for (DataBaseData data:allDataList
             ) {
            if (data.id.equals(buttonId)){
                return data.link;
            }
        }
        return null;
    }

    public DataBaseData getData(int position){
        return allDataList.get(position);
    }



}
