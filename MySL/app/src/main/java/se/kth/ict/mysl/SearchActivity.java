package se.kth.ict.mysl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    public void openSpecifySearch(View view) {
        Intent intent = new Intent(this, SpecifySearch.class);
        startActivity(intent);
    }
}
