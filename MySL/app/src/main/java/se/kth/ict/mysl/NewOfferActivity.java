package se.kth.ict.mysl;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Calendar;

public class NewOfferActivity extends AppCompatActivity {

    EditText txtDateEnd, txtDateStart, txtDatePickup;
    int year_x, month_x, day_x;
    EditText txtPlacePickup;
    static final int DIALOG_ID = 0;
    static final int DIALOG_ID1 = 1;
    static final int DIALOG_ID2 = 2;
    int cur = 99;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_offer);

        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);

        showDialogOnButtonClick();
        createCategoriesSpinner();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        db = openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS catalogue(mail TEXT NOT NULL, date_start TEXT NOT NULL, date_end TEXT NOT NULL, date_pickup TEXT NOT NULL);");

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

    public void createCategoriesSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categories, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    public void showDialogOnButtonClick() {
        txtDateStart = (EditText) findViewById(R.id.editText);

        txtDateStart.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                showDialog(DIALOG_ID);
                                            }
                                        }
        );

        txtDateEnd = (EditText) findViewById(R.id.editText3);

        txtDateEnd.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              showDialog(DIALOG_ID1);
                                          }
                                      }
        );


        txtDatePickup = (EditText) findViewById(R.id.editText4);

        txtDatePickup.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 showDialog(DIALOG_ID2);
                                             }
                                         }
        );
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        if (id == DIALOG_ID) {
            cur = DIALOG_ID;
            return new DatePickerDialog(this, dpickerListener, year_x, month_x, day_x);
        }
        if (id == DIALOG_ID1) {
            cur = DIALOG_ID1;
            return new DatePickerDialog(this, dpickerListener, year_x, month_x, day_x);
        }
        if (id == DIALOG_ID2) {
            cur = DIALOG_ID2;
            return new DatePickerDialog(this, dpickerListener, year_x, month_x, day_x);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int montOfYear, int dayOfMonth) {
            year_x = year;
            month_x = montOfYear;
            day_x = dayOfMonth;
            String date = day_x + "/" + (month_x + 1) + "/" + year_x;

            switch (cur) {
                case 0:
                    txtDateStart.setText(date);
                    break;
                case 1:
                    txtDateEnd.setText(date);
                    break;
                case 2:
                    txtDatePickup.setText(date);
                    break;
            }
        }
    };

    public void openOverview(View view) {

        db.execSQL("INSERT INTO catalogue VALUES('" + DataHolder.getMail() + "','" + txtDateStart.getText() + "','" + txtDateEnd.getText() + "','" + txtDatePickup.getText() + "');");

        Intent intent = new Intent(this, OverviewActivity.class);
        startActivity(intent);
    }


}
