package julliene.inclassassignment05_jullieneg;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TripSummary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_summary);
    }
    public void shareNow(View view) {

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Come join the trip!");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

        }
    }

//    public String createTripPlan(){
//
//        EditText itemsList = (EditText) findViewById(R.id.list_item);
//        String items = itemsList.getText().toString();
//
//        EditText places = (EditText) findViewById(R.id.places_to_go);
//        String toDo = places.getText().toString();
//
//        String tripMessage = "Location: Eiffel Tower" + "\n" +
//                "\nItems to Bring: " + items + "\n" +
//                "\nPlaces to Go: " + toDo + "\n" +
//                "\nHope to see you there!";
//
//        return tripMessage;

    }
}
