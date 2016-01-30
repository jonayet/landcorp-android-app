package helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Amir on 30-Jan-16.
 */
public class DataBase extends SQLiteOpenHelper{
    private static final String DATA_BASE_NAME ="landcrop.db";

    private String TABLE_NAME="link_table";

    private String NAME_COLUMN="name";
    private String LINK_COLUMN="link";

    private String tableSql="CREATE TABLE `"+TABLE_NAME+"` (`name` TEXT NOT NULL,`link` TEXT NOT NULL,PRIMARY KEY(name) )";
    private String[] preInsertionSqls={
            "INSERT INTO "+TABLE_NAME+" ( "+NAME_COLUMN+ ", "+LINK_COLUMN+" ) VALUES ('button1','https://www.google.com/?gws_rd=cr,ssl&ei=seOXVO2PHdiWuATwjoCwDw&fg=1')",
            "INSERT INTO "+TABLE_NAME+" ( "+NAME_COLUMN+ ", "+LINK_COLUMN+" ) VALUES ('button2','https://www.youtube.com/')",
            "INSERT INTO "+TABLE_NAME+" ( "+NAME_COLUMN+ ", "+LINK_COLUMN+") VALUES ('button3','https://www.facebook.com/')",
            "INSERT INTO "+TABLE_NAME+" ( "+NAME_COLUMN+ ", "+LINK_COLUMN+" ) VALUES ('button4','https://github.com/')",
            "INSERT INTO "+TABLE_NAME+" ( "+NAME_COLUMN+ ", "+LINK_COLUMN+" ) VALUES ('button5','http://www.aiub.edu/')",
            "INSERT INTO "+TABLE_NAME+" ( "+NAME_COLUMN+ ", "+LINK_COLUMN+" ) VALUES ('button6','http://www.clipconverter.cc/')",
            "INSERT INTO "+TABLE_NAME+" ( "+NAME_COLUMN+ ", "+LINK_COLUMN+" ) VALUES ('button7','https://www.linkedin.com/')",
            "INSERT INTO "+TABLE_NAME+" ( "+NAME_COLUMN+ ", "+LINK_COLUMN+" ) VALUES ('button8','http://uhunt.felix-halim.net/')"
    };

    private SQLiteDatabase db;

    public DataBase(Context context,int version) {
        super(context, DATA_BASE_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tableSql);
        for (String sql:preInsertionSqls
             ) {
            db.execSQL(sql);
        }
        this.db=db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public int insertData(String name,String link){
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("link", link);
        int result= (int) db.insert(TABLE_NAME,null,contentValues);
        contentValues.clear();
        return result;
    }
}
