package se.kth.ict.mysl;

import se.kth.ict.mysl.FeedReaderContract.FeedEntry;

import android.content.Intent;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by RafaelA on 2016-12-05.
 */

public class OverviewActivity extends AppCompatActivity {
    FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(getApplicationContext());

    SQLiteDatabase db = mDbHelper.getReadableDatabase();

    // Define a projection that specifies which columns from the database
// you will actually use after this query.
    String[] projection = {
            FeedEntry._ID,
            FeedEntry.EMAIL,
            FeedEntry.START_DATE,
            FeedEntry.END_DATE,
            FeedEntry.PICKUP_DATE
    };

    // Filter results WHERE "title" = 'My Title'
    String selection = FeedEntry._ID + " = ?";
    String[] selectionArgs = {"1"};

    // How you want the results sorted in the resulting Cursor
    String sortOrder =
            FeedEntry.START_DATE + " DESC";

    Cursor c = db.query(
            FeedEntry.TABLE_NAME,                     // The table to query
            projection,                               // The columns to return
            selection,                                // The columns for the WHERE clause
            selectionArgs,                            // The values for the WHERE clause
            null,                                     // don't group the rows
            null,                                     // don't filter by row groups
            sortOrder                                 // The sort order
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overview);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

    public void openDetails(View view) {
        Intent intent = new Intent(this, OfferDetails.class);
        startActivity(intent);

    }
}
