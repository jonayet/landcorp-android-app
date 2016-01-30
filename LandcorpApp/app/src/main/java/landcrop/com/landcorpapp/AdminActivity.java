package landcrop.com.landcorpapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import helper.DataBase;

/**
 * Created by Amir on 30-Jan-16.
 */
public class AdminActivity extends AppCompatActivity{
    private DataBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity);

    }
}
