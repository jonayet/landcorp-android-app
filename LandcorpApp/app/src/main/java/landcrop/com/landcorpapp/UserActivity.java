package landcrop.com.landcorpapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import BLL.CreatorClass;
import BLL.LinkStore;
import helper.DataBase;

/**
 * Created by Amir on 30-Jan-16.
 */
public class UserActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1, button2, button3, button4, button5, button6, button7, button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity);
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
    }

    private void initilizeBtns() {
        button1 = (Button) findViewById(R.id.user_button1);
        button2 = (Button) findViewById(R.id.user_button2);
        button3 = (Button) findViewById(R.id.user_button3);
        button4 = (Button) findViewById(R.id.user_button4);
        button5 = (Button) findViewById(R.id.user_button5);
        button6 = (Button) findViewById(R.id.user_button6);
        button7 = (Button) findViewById(R.id.user_button7);
        button8 = (Button) findViewById(R.id.user_button8);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_button1:
                goToUrl("button1");
                break;
            case R.id.user_button2:
                goToUrl("button2");
                break;
            case R.id.user_button3:
                goToUrl("button3");
                break;
            case R.id.user_button4:
                goToUrl("button4");
                break;
            case R.id.user_button5:
                goToUrl("button5");
                break;
            case R.id.user_button6:
                goToUrl("button6");
                break;
            case R.id.user_button7:
                goToUrl("button7");
                break;
            case R.id.user_button8:
                goToUrl("button8");
                break;
        }
    }

    private void goToUrl(String buttonId) {
        String url= CreatorClass.linkStore.getLink(buttonId);
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
