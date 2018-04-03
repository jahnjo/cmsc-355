package sprint1.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by stwodaham on 4/3/2018.
 */

public class add extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_layout);
    }

    public void clickEnter(View v) {
        if(v.getId() == R.id.enterButton) {
            Intent i = new Intent(add.this, MainActivity.class);
            startActivity(i);
        }
    }
}
