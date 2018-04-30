package sprint1.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * Created by stwodaham on 4/3/2018.
 */

public class search extends Activity {
    private static String name;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);
    }

    public void userData(){
        EditText et1 = (EditText) findViewById(R.id.editTextSearch1);
        name = et1.getText().toString();
        Log.d("FLAG", name);

        final Intent intent = new Intent(search.this, searchedProduct.class);
        intent.putExtra("Name of product", name);

    }

    public void clickSearchWithinSearch(View v) {
        if(v.getId() == R.id.searchButton) {
            Intent i = new Intent(search.this, searchedProduct.class);
            userData();
            startActivity(i);
        }
    }
}