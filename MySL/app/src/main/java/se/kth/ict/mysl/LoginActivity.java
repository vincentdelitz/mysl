package se.kth.ict.mysl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by RafaelA on 2016-12-05.
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    public void openOffer(View view) {

        Intent intent = new Intent(this, NewOfferActivity.class);
        startActivity(intent);
    }
}

