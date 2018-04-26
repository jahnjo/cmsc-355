package sprint1.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by stwodaham on 4/3/2018.
 */

public class item extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        String exp;
        String purchase;
        double price;
        int what;
        String location;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_layout);
        Intent intent = getIntent();
        String name = intent.getStringExtra("Name of product");
        TextView textView1 = (TextView) findViewById(R.id.textView5);
        textView1.setText("Name: " + name);

        purchase = intent.getStringExtra("Purchase");
        TextView textView2 = (TextView) findViewById(R.id.textView6);
        textView2.setText("Purchase Date: " + purchase);

        exp = intent.getStringExtra("Exp");
        TextView textView3 = (TextView) findViewById(R.id.textView7);
        textView3.setText("Expiration Date: " + exp);

        location = intent.getStringExtra("location");
        TextView textView4 = (TextView) findViewById(R.id.textView8);
        textView4.setText("Location: " + location);

        price = intent.getIntExtra("price", -1);
        TextView textView5 = (TextView) findViewById(R.id.textView9);
        textView5.setText("Price: " + price);

    }

}