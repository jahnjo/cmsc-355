package sprint1.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.util.Log;

/**
 * Created by stwodaham on 4/3/2018.
 */

public class filter extends Activity {

    //final CheckBox check = (CheckBox) findViewById(R.id.checkBox);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_layout);
    }
    public void clickFilterWithinFilter(View v) {
        if (v.getId() == R.id.filterButtonWithinFilter) {


            final CheckBox check = (CheckBox) findViewById(R.id.checkBox);
            if (check.isChecked())
                Log.d("FLAG","Check is True");

            //Filter by Price
            if (check.isChecked()) {
                Log.d("FLAG","hi2");
                Intent i = new Intent(filter.this, filteredResults2.class);
                startActivity(i);
            }

            //Filter by
            final CheckBox check2 = (CheckBox) findViewById(R.id.checkBox2);
            if (check2.isChecked()) {
                Log.d("FLAG","hi2");
                Intent i = new Intent(filter.this, filteredResults3.class);
                startActivity(i);
            }

            //Filter by
            final CheckBox check3 = (CheckBox) findViewById(R.id.checkBox3);
            if (check3.isChecked()) {
                Log.d("FLAG","hi2");
                Intent i = new Intent(filter.this, filteredResults4.class);
                startActivity(i);
            }

            //Filter by
            final CheckBox check4 = (CheckBox) findViewById(R.id.checkBox4);
            if (check4.isChecked()) {
                Log.d("FLAG","hi2");
                Intent i = new Intent(filter.this, filteredResults5.class);
                startActivity(i);
            }

            //Filter by
            final CheckBox check8 = (CheckBox) findViewById(R.id.checkBox8);
            if (check8.isChecked()) {
                Log.d("FLAG","hi2");
                Intent i = new Intent(filter.this, filteredResults6.class);
                startActivity(i);
            }

            //Filter by
            final CheckBox check6 = (CheckBox) findViewById(R.id.checkBox6);
            if (check6.isChecked()) {
                Log.d("FLAG","hi2");
                Intent i = new Intent(filter.this, filteredResults7.class);
                startActivity(i);
            }

            //Filter by
            final CheckBox check7 = (CheckBox) findViewById(R.id.checkBox7);
            if (check7.isChecked()) {
                Log.d("FLAG","hi2");
                Intent i = new Intent(filter.this, filteredResults8.class);
                startActivity(i);
            }

        }
    }


    public void clickHomeButtonInFilter(View v) {
        if (v.getId() == R.id.homeButtonInFilter) {
            Intent i = new Intent(filter.this, MainActivity.class);
            startActivity(i);
        }
    }
}
