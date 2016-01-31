package landcrop.com.landcorpapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import BLL.CreatorClass;
import BLL.LinkStore;
import helper.DataBaseData;

/**
 * Created by Amir on 31-Jan-16.
 */
public class SettingActivity extends AppCompatActivity implements View.OnClickListener {
    private LinkStore linkStore;
    private Button demoButton, doneBtn;
    private TextView linkView;
    private EditText newNameField,newLinkField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity);

        linkStore = CreatorClass.linkStore;
        int btnPos = getIntentData();

        demoButton = (Button) findViewById(R.id.demo_btn);
        doneBtn = (Button) findViewById(R.id.done_btn);
        linkView = (TextView) findViewById(R.id.link_view);
        newNameField= (EditText) findViewById(R.id.new_name_field);
        newLinkField= (EditText) findViewById(R.id.new_link_field);

        DataBaseData data = linkStore.getData(btnPos);
        setDemoButtonInfo(data);

    }

    private void setDemoButtonInfo(DataBaseData data) {

        demoButton.setText(data.name);
        linkView.setText(data.link);


    }

    private int getIntentData() {
        Intent intent = getIntent();
        return intent.getExtras().getInt("btnPos");
    }
    String newName,newLink;
    @Override
    public void onClick(View v) {
        newName=newNameField.getText().toString();
        newLink=newLinkField.getText().toString();

        processInfo();
    }

    private void processInfo() {
        if(newName.length()==0&& newLink.length()==0){
            return;
        }else if(newName.length()==0){

        }else if(newLink.length()==0){

        }else {
            //linkStore.update(newName,newLink);
        }
    }
}
