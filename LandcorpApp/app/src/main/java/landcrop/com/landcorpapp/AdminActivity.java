package landcrop.com.landcorpapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import BLL.CreatorClass;
import helper.DataBase;

/**
 * Created by Amir on 30-Jan-16.
 */
public class AdminActivity extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {

    private DataBase db;
    private Button button1, button2, button3, button4, button5, button6, button7, button8, settingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity);
        initilizeBtns();
        setClickListener();

    }

    private void setClickListener() {
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        settingButton.setOnClickListener(this);
    }

    private void initilizeBtns() {
        button1 = (Button) findViewById(R.id.adnin_button1);
        button2 = (Button) findViewById(R.id.admin_button2);
        button3 = (Button) findViewById(R.id.admin_button3);
        button4 = (Button) findViewById(R.id.admin_button4);
        button5 = (Button) findViewById(R.id.admin_button5);
        button6 = (Button) findViewById(R.id.admin_button6);
        button7 = (Button) findViewById(R.id.admin_button7);
        button8 = (Button) findViewById(R.id.admin_button8);
        settingButton = (Button) findViewById(R.id.setting_btn);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.adnin_button1:
                goToUrl("button1");
                break;
            case R.id.admin_button2:
                goToUrl("button2");
                break;
            case R.id.admin_button3:
                goToUrl("button3");
                break;
            case R.id.admin_button4:
                goToUrl("button4");
                break;
            case R.id.admin_button5:
                goToUrl("button5");
                break;
            case R.id.admin_button6:
                goToUrl("button6");
                break;
            case R.id.admin_button7:
                goToUrl("button7");
                break;
            case R.id.admin_button8:
                goToUrl("button8");
                break;
            case R.id.setting_btn:
                createAlertDialog();
                break;

        }
    }

    private void createAlertDialog() {
        CharSequence[] itemList = {"Button 1", "Button 2", "Button 3", "Button 4", "Button 5", "Button 6", "Button 7", "Button 8"};
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("Select Button to Edit");
        alertBuilder.setItems(itemList, this);

        alertBuilder.show();
    }

    private void goToUrl(String buttonId) {
        String url = CreatorClass.linkStore.getLink(buttonId);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
}
