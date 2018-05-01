package sprint1.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by stwodaham on 4/3/2018.
 */

public class searchedProduct extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searched_product_layout);
    }

    public void clickHomeWithinSearch(View v) {
        if(v.getId() == R.id.homeButtonWithinSeach) {
            Intent i = new Intent(searchedProduct.this, MainActivity.class);
            startActivity(i);
        }
    }
}
