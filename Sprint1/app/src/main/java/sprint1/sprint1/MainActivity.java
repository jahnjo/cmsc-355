package sprint1.sprint1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void clickSearch(View v) {
        if(v.getId() == R.id.search) {
            Intent i = new Intent(MainActivity.this, search.class);
            startActivity(i);
        }
    }
    public void clickFilter(View v) {
        if(v.getId() == R.id.filter) {
            Intent i = new Intent(MainActivity.this, filter.class);
            startActivity(i);
        }
    }
    public void clickAdd(View v) {
        if(v.getId() == R.id.add) {
            Intent i = new Intent(MainActivity.this, add.class);
            startActivity(i);
        }
    }
}
