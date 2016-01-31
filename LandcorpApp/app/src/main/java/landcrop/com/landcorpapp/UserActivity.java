package landcrop.com.landcorpapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import BLL.CreatorClass;
import BLL.LinkStore;

/**
 * Created by Amir on 30-Jan-16.
 */
public class UserActivity extends AppCompatActivity implements View.OnClickListener {
    private LinkStore linkStore;
    private Button[] buttonList=new Button[8];
    private int[] idList={R.id.user_button1,R.id.user_button2,R.id.user_button3,R.id.user_button4,R.id.user_button5,R.id.user_button6,R.id.user_button7,R.id.user_button8};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity);
        linkStore=CreatorClass.linkStore;
        btnInitilizeAndListen();
        setButtonLabel();


    }



    private void btnInitilizeAndListen() {
        for(int i=0;i<8;i++){
            buttonList[i]=(Button)findViewById(idList[i]);
            buttonList[i].setOnClickListener(this);
        }

    }

    private void setButtonLabel(){

        for(int i=0;i<buttonList.length;i++){
            buttonList[i].setText(linkStore.getData(i).name);
        }


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
        String url= linkStore.getLink(buttonId);
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
