package se.kth.ict.mysl;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
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
    static final int DIALOG_ID = 0;



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

    }

    public void createCategoriesSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categories, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    public void showDialogOnButtonClick() {
        txtDateEnd = (EditText) findViewById(R.id.editText3);

        txtDateEnd.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           showDialog(DIALOG_ID);
                                       }
                                   }
        );

        txtDateStart = (EditText) findViewById(R.id.editText);

        txtDateStart.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              showDialog(DIALOG_ID);
                                          }
                                      }
        );

        txtDatePickup = (EditText) findViewById(R.id.editText4);

        txtDatePickup.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              showDialog(DIALOG_ID);
                                          }
                                      }
        );
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        if (id == DIALOG_ID) {
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
            Toast.makeText(NewOfferActivity.this, date, Toast.LENGTH_LONG).show();
            txtDateEnd.setText(date);
        }
    };

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radioButton2:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }



}
