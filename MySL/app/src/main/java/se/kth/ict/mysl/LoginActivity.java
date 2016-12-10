package se.kth.ict.mysl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentContainer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

/**
 * Created by RafaelA on 2016-12-05.
 */

public class LoginActivity extends AppCompatActivity {
    //extends FragmentActivity
    EditText email;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.login);

        email = (EditText) findViewById(R.id.editText9);
        password = (EditText) findViewById(R.id.editText11);
    }

    public void openOffer(View view) {
        if ((email.getText().toString().equals("") || password.getText().toString().equals(""))&&!DataHolder.isLoggedin()) {
            Context context = getApplicationContext();
            CharSequence text = "Email or password missing!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            DataHolder.setMail(email.getText().toString());
            DataHolder.setLoggedin(true);
            Intent intent = new Intent(this, NewOfferActivity.class);
            startActivity(intent);
        }
    }
}

