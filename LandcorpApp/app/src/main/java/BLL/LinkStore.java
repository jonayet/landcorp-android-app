package BLL;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import helper.DataBase;
import helper.DataBaseData;

public class LinkStore {
    private DataBase schema;
    private SQLiteDatabase db;
    private ArrayList<DataBaseData> dataList;
    ;

    public LinkStore(DataBase db) {
        this.schema = db;
        this.db = db.getWritableDatabase();
        initilizeDataList();

    }

    public void initilizeDataList() {
        Cursor cursor = db.rawQuery("SELECT * FROM " + schema.TABLE, null);
        dataList = new ArrayList<>();

        while (cursor.moveToNext()) {
            dataList.add(new DataBaseData(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
        }
        cursor.close();
    }

    public void updateBoth(String id,String name, String link) {
        db.execSQL("UPDATE " + schema.TABLE + " SET " + schema.LABEL + " ='" + name + "', " + schema.URL + " ='" + link + "' WHERE " + schema.ID + " ='" + id + "'");


    }

    public void updateLink(String id,String link) {
        db.execSQL("UPDATE "+schema.TABLE+" SET "+schema.URL+" ='"+link+"' WHERE "+schema.ID+" ='"+id+"'");


    }

    public void updateName(String id,String name) {
        db.execSQL("UPDATE "+schema.TABLE+" SET "+schema.LABEL+" ='"+name+"' WHERE "+schema.ID+" ='"+id+"'");



    }


    public String getLink(String buttonId){
        for (DataBaseData data: dataList
             ) {
            if (data.id.equals(buttonId)){
                return data.link;
            }
        }
        return null;
    }

    public DataBaseData getData(String buttonId){
        for (DataBaseData data: dataList
                ) {
            if (data.id.equals(buttonId)){
                return data;
            }
        }

        return null;
    }

    public String getName(int position){
        return dataList.get(position).name;
    }

    public String getId(int position){
        return dataList.get(position).id;
    }

    public CharSequence[] getDialogItemList(){
        CharSequence[] itemList=new CharSequence[8];
        for(int i=0;i<8;i++){
            itemList[i]=dataList.get(i).name;
        }
        return itemList;
    }




}
