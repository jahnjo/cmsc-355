package sprint1.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by stwodaham on 4/3/2018.
 */

public class filteredResults extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filtered_results_layout);
    }

    public void clickHomeWithinFilteredResults(View v) {
        if(v.getId() == R.id.homeButtonWithinFilteredResults) {
            Intent i = new Intent(filteredResults.this, MainActivity.class);
            startActivity(i);
        }
    }
}