package sprint1.sprint1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Collection;

import static android.content.ContentValues.TAG;

/**
 * Created by stwodaham on 4/3/2018.
 */

public class filteredResults2 extends Activity {//implements Comparable

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

        //*******************************************************************

        //mainListView.setAdapter(adapter.orderByChild("Price"));
        Query myMostViewedPostsQuery = warehouseNames.child("Name").orderByChild("Price");
        myMostViewedPostsQuery.addChildEventListener(new ChildEventListener()  {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d(TAG, "onChildAdded:" + dataSnapshot.getKey());

                // A new comment has been added, add it to the displayed list
                Comment comment = dataSnapshot.getValue(Comment.class);

                // ...
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d(TAG, "onChildChanged:" + dataSnapshot.getKey());

                // A comment has changed, use the key to determine if we are displaying this
                // comment and if so displayed the changed comment.
                Comment newComment = dataSnapshot.getValue(Comment.class);
                String commentKey = dataSnapshot.getKey();

                // ...
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.d(TAG, "onChildRemoved:" + dataSnapshot.getKey());

                // A comment has changed, use the key to determine if we are displaying this
                // comment and if so remove it.
                String commentKey = dataSnapshot.getKey();

                // ...
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d(TAG, "onChildMoved:" + dataSnapshot.getKey());

                // A comment has changed position, use the key to determine if we are
                // displaying this comment and if so move it.
                Comment movedComment = dataSnapshot.getValue(Comment.class);
                String commentKey = dataSnapshot.getKey();

                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "postComments:onCancelled", databaseError.toException());
                Context mContext;
                //Toast.makeText(mContext, "Failed to load comments.", Toast.LENGTH_SHORT).show();
            }
        });
        //warehouseNames.addChildEventListener(childEventListener);

        //adapter.getFilter().getFilter.().orderByChild("Price");

        warehouseNames.addListenerForSingleValueEvent(getNames);
        warehouseNames.orderByChild("Price");

        warehouseNames.orderByChild("Price");
        adapter.getFilter();

        //mainListView.setAdapter(adapter.getFilter().filter("Price"));
   // );

        database.getReference().orderByChild("Price");
        mainListView = (ListView) findViewById(R.id.mainList);


       // Query myMostViewedPostsQuery = warehouseNames.child("Name").orderByChild("Price");
        //myMostViewedPostsQuery.addChildEventListener(new ChildEventListener() {
            // TODO: implement the ChildEventListener methods as documented above
            // ...
       // });

        //*****************************************************************************

        mainListView.setAdapter(adapter);
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Intent intent = new Intent(filteredResults2.this, item.class);
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
                                Log.d("FLAG This shit wroks", temp2);
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
            Intent i = new Intent(filteredResults2.this, MainActivity.class);
            startActivity(i);
        }
    }

    //@Override
    public int compareTo(@NonNull Object o) {
        return 0;
    }
}