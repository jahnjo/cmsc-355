package sprint1.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stwodaham on 4/3/2018.
 */

public class filteredResults extends Activity {

    private ListView mainListView;
    String exp;
    String purchase;
    double price;
    String location;
    int quantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filtered_results_layout);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference warehouseNames = database.getReference();
        //final String[] items = new String[30];
        final List<String> listNames = new ArrayList<String>();
        final ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listNames);


        ValueEventListener getNames = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Get map of users in datasnapshot
                for(DataSnapshot nameSnapshot : dataSnapshot.getChildren()) {
                    adapter.add(nameSnapshot.getKey().toString());
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                //handle databaseError
            }
        };

        warehouseNames.addListenerForSingleValueEvent(getNames);

        mainListView = (ListView) findViewById(R.id.mainList);

        mainListView.setAdapter(adapter);
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                final Intent intent = new Intent(filteredResults.this, item.class);
                String entry = (String) parent.getItemAtPosition(position);

                //    String purchase = parent.get.toString();

                final FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference singleName = database.getReference(entry);
                final String[] nameChildren = new String[5];

                intent.putExtra("Name of product", entry);

                ValueEventListener getOneName = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Get map of users in datasnapshot
                        int i = 0;
                        for(DataSnapshot nameSnapshot : dataSnapshot.getChildren()) {
                            if (i == 0) {
                                purchase = nameSnapshot.getValue().toString();

                                intent.putExtra("Purchase", purchase);
                                Log.d("FLAG", purchase);
                            }
                            if (i == 1) {
                                exp = nameSnapshot.getValue().toString();

                                intent.putExtra("Exp", exp);
                                Log.d("FLAG", exp);
                            }
                            if (i == 2) {
                                location = nameSnapshot.getValue().toString();

                                intent.putExtra("Location", location);
                                Log.d("FLAG", location);
                            }
                            if (i == 3) {
                                String temp = nameSnapshot.getValue().toString();
                                price = Double.parseDouble(temp);

                                intent.putExtra("Price", price);
                                Log.d("FLAG", temp);
                            }
                            if (i == 4) {
                                String temp2 = nameSnapshot.getValue().toString();
                                quantity = Integer.parseInt(temp2);

                                intent.putExtra("Quantity", quantity);
                                Log.d("FLAG This shit works", temp2);
                            }

                            i++;
//                            startActivity(intent);
                        }
                        startActivity(intent);
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                };
                singleName.addValueEventListener(getOneName);

                Log.d("FLAG", entry + purchase + exp + location + price + quantity);

                Log.d("FLAG", entry);

            }
        });


    }


    public void clickHomeWithinFilteredResults(View v) {
        if(v.getId() == R.id.homeButtonWithinFilteredResults) {
            Intent i = new Intent(filteredResults.this, MainActivity.class);
            startActivity(i);
        }
    }
}