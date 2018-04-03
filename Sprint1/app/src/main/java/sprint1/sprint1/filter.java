package sprint1.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by stwodaham on 4/3/2018.
 */

public class filter extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_layout);
    }
    public void clickFilterWithinFilter(View v) {
        if(v.getId() == R.id.filterButtonWithinFilter) {
            Intent i = new Intent(filter.this, filteredResults.class);
            startActivity(i);
        }
    }
}
