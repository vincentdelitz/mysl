package se.kth.ict.mysl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentContainer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

/**
 * Created by RafaelA on 2016-12-05.
 */

public class LoginActivity extends AppCompatActivity  {
    //extends FragmentActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.login);


    }

    public void openOffer(View view) {
        Intent intent = new Intent(this, NewOfferActivity.class);
        startActivity(intent);
    }
}

