package julliene.inclassassignment05_jullieneg;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Day1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day1);
        getSupportActionBar().setTitle("Day 1");
    }

    public void shareNow(View view) {
        String tripMessage = createTripPlan();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Come join the trip!");
        intent.putExtra(Intent.EXTRA_TEXT, tripMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

        }
    }

    public String createTripPlan(){

        EditText itemsList = (EditText) findViewById(R.id.list_item);
        String items = itemsList.getText().toString();

        EditText places = (EditText) findViewById(R.id.places_to_go);
        String toDo = places.getText().toString();

        String tripMessage = "Location: Eiffel Tower" + "\n" +
                "\nItems to Bring: " + items + "\n" +
                "\nPlaces to Go: " + toDo + "\n" +
                "\nHope to see you soon!";

        return tripMessage;

    }
}
