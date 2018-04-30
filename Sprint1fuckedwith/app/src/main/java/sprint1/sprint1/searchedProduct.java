package sprint1.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stwodaham on 4/3/2018.
 */

public class searchedProduct extends Activity {
    private ListView mainListView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searched_product_layout);
        Intent intent = getIntent();
        String name = intent.getStringExtra("Name of product");

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference singleName = database.getReference(name);

        final List<String> listNames = new ArrayList<String>();
        final ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listNames);

        adapter.add(singleName.toString());
        mainListView = (ListView) findViewById(R.id.searchList);
        mainListView.setAdapter(adapter);
    }

    public void clickHomeWithinSearch(View v) {
        if(v.getId() == R.id.homeButtonWithinSeach) {
            Intent i = new Intent(searchedProduct.this, MainActivity.class);
            startActivity(i);
        }
    }
}
