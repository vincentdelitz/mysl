package se.kth.ict.mysl;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class OfferDetails extends AppCompatActivity {

    TextView pickupplace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pickupplace = (TextView) findViewById(R.id.pickupplacevalue);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void openMap(View view){
        Intent intent = new Intent(this, MapsActivity.class);

        intent.putExtra("Locationname", pickupplace.getText().toString());
        startActivity(intent);
    }
}
