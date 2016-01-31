package landcrop.com.landcorpapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import BLL.CreatorClass;
import BLL.LinkStore;
import helper.DataBase;
import helper.User;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<User> userList = new ArrayList<>();
    EditText userNameField, passField;
    Button loginBtn;
    String userName, pass;

    private DataBase db;
    private LinkStore linkStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        userNameField = (EditText) findViewById(R.id.user_name_field);
        passField = (EditText) findViewById(R.id.pass_field);
        loginBtn = (Button) findViewById(R.id.login_btn);

        db = CreatorClass.createDataBase(this,2);
        CreatorClass.createLinkStore(db);

        loginBtn.setOnClickListener(this);
        createUserList();

    }

    private void createUserList() {
        userList.add(new User("amir", "123", 1, true));
        userList.add(new User("jonayet", "123", 2, true));
        userList.add(new User("ahmad", "123", 3, false));
        userList.add(new User("jobeda", "123", 4, false));
    }


    @Override
    public void onClick(View v) {
        userName = userNameField.getText().toString();
        pass = passField.getText().toString();
        if (fieldCheck()) {
            if (authintication()) {
                runActivity();
            }
        }


    }

    private User user;

    private void runActivity() {
        Intent intent;
        if (user.IsAdmin) {
            intent = new Intent(this, AdminActivity.class);
            startActivity(intent);
        } else {
            intent = new Intent(this, UserActivity.class);
            startActivity(intent);
        }
    }

    private boolean fieldCheck() {
        if (userName.length() == 0) {
            Toast.makeText(this, "Enter your username", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (pass.length() == 0) {
            Toast.makeText(this, "Enter your password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean authintication() {

        for (User user : userList
                ) {
            if (user.Username.equals(userName)) {
                if (user.Password.equals(pass)) {
                    this.user = user;
                    return true;


                } else {
                    Toast.makeText(this, "Wrong password", Toast.LENGTH_SHORT).show();
                    return false;

                }
            }

        }

        Toast.makeText(this, "Wrong username", Toast.LENGTH_SHORT).show();
        return false;


    }



}
