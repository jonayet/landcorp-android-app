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
import BLL.LinkStore;
import helper.DataBase;
import helper.DataBaseData;

/**
 * Created by Amir on 30-Jan-16.
 */
public class AdminActivity extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {
    private LinkStore linkStore;
    private Button[] buttonList = new Button[9];
    private int[] idList = {R.id.adnin_button1, R.id.admin_button2, R.id.admin_button3, R.id.admin_button4, R.id.admin_button5, R.id.admin_button6, R.id.admin_button7, R.id.admin_button8, R.id.setting_btn};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity);
//        linkStore = CreatorClass.linkStore;
//        btnInitilizeAndListen();
//        setButtonLabel();
    }

    @Override
    protected void onResume() {
        DataBase db = CreatorClass.createDataBase(this,2);
        CreatorClass.createLinkStore(db);
        linkStore = CreatorClass.linkStore;
        btnInitilizeAndListen();
        setButtonLabel();
        super.onResume();
    }


    private void btnInitilizeAndListen() {
        for (int i = 0; i < 9; i++) {
            buttonList[i] = (Button) findViewById(idList[i]);
            buttonList[i].setOnClickListener(this);
        }

    }

    private void setButtonLabel() {

        for (int i = 0; i < 8; i++) {
            buttonList[i].setText(linkStore.getName(i));
        }


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

    private CharSequence[] itemList = {"Button 1", "Button 2", "Button 3", "Button 4", "Button 5", "Button 6", "Button 7", "Button 8"};

    private void createAlertDialog() {

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("Select Button to Edit");
        alertBuilder.setItems(itemList, this);

        alertBuilder.show();
    }

    private void goToUrl(String buttonId) {
        String url = linkStore.getLink(buttonId);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public void onClick(DialogInterface dialog, int position) {
        Intent intent = new Intent(this, SettingActivity.class);
        intent.putExtra("btnId",linkStore.getId(position));
        startActivity(intent);
        finish();

    }
}
