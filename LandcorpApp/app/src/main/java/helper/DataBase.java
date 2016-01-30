package helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {
    private static final String DATA_BASE_NAME = "landcrop.db";

    public static final String TABLE = "link_table";
    public static final String ID = "id";
    public static final String LABEL = "label";
    public static final String COLOR = "color";
    public static final String URL = "url";

    public DataBase(Context context, int version) {
        super(context, DATA_BASE_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db);
        seedData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }

    private void createTable(SQLiteDatabase db) {
        String tableSql = "CREATE TABLE IF NOT EXISTS'" + TABLE + "'('id' TEXT NOT NULL, 'label' TEXT, 'color' TEXT, 'url' TEXT, PRIMARY KEY(id))";
        db.execSQL(tableSql);
    }

    private void seedData(SQLiteDatabase db) {
        String[] seedDataSqlList = {
                "INSERT INTO " + TABLE + " ( " + ID + ", " + LABEL + ", " + COLOR + ", " + URL + " ) VALUES ('button1','Button 1', '#000000', 'https://www.google.com/?gws_rd=cr,ssl&ei=seOXVO2PHdiWuATwjoCwDw&fg=1')",
                "INSERT INTO " + TABLE + " ( " + ID + ", " + LABEL + ", " + COLOR + ", " + URL + " ) VALUES ('button2','Button 2', '#000000', 'https://www.youtube.com/')",
                "INSERT INTO " + TABLE + " ( " + ID + ", " + LABEL + ", " + COLOR + ", " + URL + " ) VALUES ('button3','Button 3', '#000000', 'https://www.facebook.com/')",
                "INSERT INTO " + TABLE + " ( " + ID + ", " + LABEL + ", " + COLOR + ", " + URL + " ) VALUES ('button4','Button 4', '#000000', 'https://github.com/')",
                "INSERT INTO " + TABLE + " ( " + ID + ", " + LABEL + ", " + COLOR + ", " + URL + " ) VALUES ('button5','Button 5', '#000000', 'http://www.aiub.edu/')",
                "INSERT INTO " + TABLE + " ( " + ID + ", " + LABEL + ", " + COLOR + ", " + URL + " ) VALUES ('button6','Button 6', '#000000', 'http://www.clipconverter.cc/')",
                "INSERT INTO " + TABLE + " ( " + ID + ", " + LABEL + ", " + COLOR + ", " + URL + " ) VALUES ('button7','Button 7', '#000000', 'https://www.linkedin.com/')",
                "INSERT INTO " + TABLE + " ( " + ID + ", " + LABEL + ", " + COLOR + ", " + URL + " ) VALUES ('button8','Button 8', '#000000', 'http://uhunt.felix-halim.net/')"
        };
        for (String sql : seedDataSqlList) {
            db.execSQL(sql);
        }
    }
}
