package julliene.inclassassignment05_jullieneg;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static julliene.inclassassignment05_jullieneg.R.id.location;

public class DailyPlan extends AppCompatActivity {
    public String tripMessage;
    ArrayList<TripPlan> tripList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_plan);
        tripList = new ArrayList<>();
        getSupportActionBar().setTitle("Daily Plan");

        Intent intent = getIntent();

        ImageView picture = (ImageView) findViewById(R.id.locationPicture);

        TextView name = (TextView) findViewById(location);

        String location = intent.getStringExtra("Location");

        switch (location){
            case "Eiffel Tower":
                picture.setImageResource(R.drawable.eiffeltower);
                name.setText("Location: Eiffel Tower");
                break;

            case "Notre Dame":
                picture.setImageResource(R.drawable.notredame);
                name.setText("Location: Notre Dame");
                break;

            case "Louvre Museum":
                picture.setImageResource(R.drawable.louvremuseum);
                name.setText("Location: Louvre Museum");
                break;

            case "Luxembourg Gardens":
                picture.setImageResource(R.drawable.luxembourggardens);
                name.setText("Location: Luxembourg Gardens");
                break;
        }

        SharedPreferences sharedPref = getPreferences(MODE_PRIVATE);
        String key = name.getText().toString();
        String listItem = sharedPref.getString(key + "item", "");
        String places = sharedPref.getString(key + "places", "");
        ((EditText) findViewById(R.id.list_item)).setText(listItem);
        ((EditText) findViewById(R.id.places_to_go)).setText(places);
    }

    public void saveNow(View view){

        TextView locationText = (TextView) findViewById(location);
        String name = locationText.getText().toString();

        EditText itemsList = (EditText) findViewById(R.id.list_item);
        String items = itemsList.getText().toString();

        EditText places = (EditText) findViewById(R.id.places_to_go);
        String toDo = places.getText().toString();


        SharedPreferences sharedPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(name + "item", items);
        editor.putString(name + "places", toDo);
        editor.commit();

        TripPlan tripPlan = new TripPlan(items,toDo);

        tripList.add(tripPlan);

        tripMessage = tripMessage + name + "\n" + tripPlan.toString();
        itemsList.setText(null);
        places.setText(null);


        Toast t=Toast.makeText(this,"Plan Saved!",Toast.LENGTH_SHORT);
        t.show();
    }

    public void openItinerary(View view) {
        Intent i = new Intent(this, TripSummary.class);
        i.putExtra("Trip Message", tripMessage);
        startActivity(i);
    }
}
