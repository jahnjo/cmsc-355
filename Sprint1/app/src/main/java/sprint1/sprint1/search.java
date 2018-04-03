package sprint1.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by stwodaham on 4/3/2018.
 */

public class search extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);
    }

    public void clickSearchWithinSearch(View v) {
        if(v.getId() == R.id.searchButton) {
            Intent i = new Intent(search.this, searchedProduct.class);
            startActivity(i);
        }
    }
}