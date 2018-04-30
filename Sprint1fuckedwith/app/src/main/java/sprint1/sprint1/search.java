package sprint1.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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

public class search extends Activity {
    public static String name;
    public static String searchedProduct;
    public static String exp;
    public static String purchase;
    public static double price;
    public static String location;
    public static int quantity;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);
        //searchName();
        name = "";
    }

    public void userData(){
        EditText et1 = (EditText) findViewById(R.id.editTextSearch1);
        name = et1.getText().toString().toLowerCase();
        Log.d("FLAG", name);

        final Intent intent = new Intent(search.this, item.class);
        intent.putExtra("Name of product", name);

    }

    public void searchName() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference singleName = database.getReference();

        //final List<String> listNames = new ArrayList<String>();
        // final ArrayAdapter<String> adapter =
        //       new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listNames);
        Log.d("FLAG", "before value event lsitener in search name");
        ValueEventListener getNames = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("FLAG", "before for loop");
                //Get map of users in datasnapshot
                for(DataSnapshot nameSnapshot : dataSnapshot.getChildren()) {
                    Log.d("FLAG", nameSnapshot.getKey().toString());
                    Log.d("FLAG", name);

                    if(name.equals(nameSnapshot.getKey().toString())) {
                        Log.d("FLAG", "INSIDE IF STATEMENT");
                        searchedProduct = name;
                        Log.d("FLAG", searchedProduct);
                        getSearchedProductInfo();
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                //handle databaseError
            }
        };
        singleName.addValueEventListener(getNames);
        Log.d("FLAG", "going into searchedproduct info");

    }

    public void getSearchedProductInfo() {
        Log.d("FLAG","ENTERING PRODUCT INFO STUFF");
        final FirebaseDatabase database2 = FirebaseDatabase.getInstance();
        final DatabaseReference dbInfo = database2.getReference(searchedProduct);
        //final String[] nameChildren = new String[5];

        //.putExtra("Name of product", searchedProduct);

        ValueEventListener getInfo = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Get map of users in datasnapshot
                int i = 0;
                for(DataSnapshot nameSnapshot : dataSnapshot.getChildren()) {
                    if (i == 0) {
                        purchase = nameSnapshot.getValue().toString();

                        // i.putExtra("Purchase", purchase);
                        Log.d("FLAG", purchase);
                    }
                    if (i == 1) {
                        exp = nameSnapshot.getValue().toString();

                        // i.putExtra("Exp", exp);
                        Log.d("FLAG", exp);
                    }
                    if (i == 2) {
                        location = nameSnapshot.getValue().toString();

                        // i.putExtra("Location", location);
                        Log.d("FLAG", location);
                    }
                    if (i == 3) {
                        String temp = nameSnapshot.getValue().toString();
                        price = Double.parseDouble(temp);

                        // i.putExtra("Price", price);
                        Log.d("FLAG", temp);
                    }
                    if (i == 4) {
                        String temp2 = nameSnapshot.getValue().toString();
                        quantity = Integer.parseInt(temp2);

                        // i.putExtra("Quantity", quantity);
                        Log.d("FLAG This shit works", temp2);
                    }

                    i++;
//                            startActivity(intent);
                }
                //startActivity(i);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                //handle databaseError
            }
        };
        dbInfo.addValueEventListener(getInfo);

        //mainListView = (ListView) findViewById(R.id.searchList);
        //mainListView.setAdapter(adapter);
    }

    public void clickSearchWithinSearch(View v) {
        if(v.getId() == R.id.searchButton) {
            Intent i = new Intent(search.this, item.class);
            Log.d("FLAG", "before userdata()");
            userData();
            Log.d("FLAG", "before searchName");
            searchName();
           // print();
            Log.d("FLAG", "put extra portion");
            i.putExtra("Name of product", searchedProduct);
            Log.d("FLAG", name);
            i.putExtra("Purchase", purchase);
            i.putExtra("Exp", exp);
            i.putExtra("Location", location);
            i.putExtra("Price", price);
            i.putExtra("Quantity", quantity);
            startActivity(i);
        }
    }
}