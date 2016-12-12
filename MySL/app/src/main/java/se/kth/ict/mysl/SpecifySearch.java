package se.kth.ict.mysl;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;


public class SpecifySearch extends AppCompatActivity {

    EditText txtStart, txtEnd;

    static final int DIALOG_ID1 = 1;
    static final int DIALOG_ID2 = 2;
    int cur = 0;
    int year_x, month_x, day_x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specify_search);

        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);
        showDialogOnButtonClick();

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

    public void showDialogOnButtonClick() {

        txtStart = (EditText) findViewById(R.id.editText_spec);

        txtStart.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            showDialog(DIALOG_ID1);
                                        }
                                    }
        );

        txtEnd = (EditText) findViewById(R.id.editText2_spec);

        txtEnd.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          showDialog(DIALOG_ID2);
                                      }
                                  }
        );
    }

    @Override
    protected Dialog onCreateDialog(int id) {


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
                case 1:
                    txtStart.setText(date);
                    break;
                case 2:
                    txtEnd.setText(date);
                    break;
            }
        }
    };

   
    public void openOverviewFromSearch(View view) {
        Intent intent = new Intent(this, OverviewActivity.class);
        startActivity(intent);
    }


}
