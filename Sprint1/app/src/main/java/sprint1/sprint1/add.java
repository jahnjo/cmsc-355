package sprint1.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by stwodaham on 4/3/2018.
 */

public class add extends Activity {

    private static String name;
    private static double price = 0.0;
    private static String exp;
    private static String date;
    private static String location;
    private static int quantity;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_layout);
    }

    public void userData() {
        EditText et1 = (EditText) findViewById(R.id.editText1);
        EditText et2 = (EditText) findViewById(R.id.editText2);
        EditText et3 = (EditText) findViewById(R.id.editText3);
        EditText et4 = (EditText) findViewById(R.id.editText4);
        EditText et5 = (EditText) findViewById(R.id.editText5);
        EditText et6 = (EditText) findViewById(R.id.editText6);

        name = et1.getText().toString();
        Log.d("NAME", name);


        String priceString = et2.getText().toString();
        price = Double.parseDouble(priceString);

        String quantityString = et3.getText().toString();
        quantity = Integer.parseInt(quantityString);

        date = et4.getText().toString();
        exp = et5.getText().toString();



        location = et6.getText().toString();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(name);
        myRef.child("Price").setValue(price);
        myRef.child("Quantity").setValue(quantity);
        myRef.child("Date").setValue(date);
        myRef.child("Expiration").setValue(exp);
        myRef.child("Location").setValue(location);
    }

    public void clickEnter(View v) {
        if(v.getId() == R.id.enterButton) {
            Intent i = new Intent(add.this, MainActivity.class);
            userData();
            startActivity(i);

        }
    }
}
