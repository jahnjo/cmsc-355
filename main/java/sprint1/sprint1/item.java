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
        int quantity;
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

        location = intent.getStringExtra("Location");
        TextView textView4 = (TextView) findViewById(R.id.textView8);
        textView4.setText("Location: " + location);

        price = intent.getDoubleExtra("Price", 0.00);
        TextView textView5 = (TextView) findViewById(R.id.textView9);
        textView5.setText("Price: " + price);

        quantity = intent.getIntExtra("Quantity", 0);
        TextView textView6 = (TextView) findViewById(R.id.textView10);
        textView6.setText("Quantity: " + quantity);
    }

    public void clickHomeButtonInSearch(View v) {
        if(v.getId() == R.id.homeButtonInItem) {
            Intent i = new Intent(item.this, MainActivity.class);
            startActivity(i);
        }
    }
    public void clickDeleteItem(View v) {
        if(v.getId() == R.id.deleteItem) {
            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            Intent intent = getIntent();
            String name = intent.getStringExtra("Name of product");
            DatabaseReference singleName = database.getReference(name);
            singleName.removeValue();
            Intent i = new Intent(item.this, MainActivity.class);
            this.startActivity(i);
        }
    }

    public void clickIncreaseQuantity(View v) {
        if(v.getId() == R.id.increaseQuantity) {
            Intent intent = getIntent();
            int quantity = intent.getIntExtra("Quantity", 0);
            String name = intent.getStringExtra("Name of product");
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference(name);
            myRef.child("Quantity").setValue(quantity + 1);
        }
    }

    public void clickReduceQuantity(View v) {
        if(v.getId() == R.id.reduceQuantity) {
            Intent intent = getIntent();
            int quantity = intent.getIntExtra("Quantity", 0);
            String name = intent.getStringExtra("Name of product");
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference(name);
            if (quantity - 1 == 0) {
                myRef.removeValue();

            }
            else
                myRef.child("Quantity").setValue(quantity - 1);
        }
    }

}