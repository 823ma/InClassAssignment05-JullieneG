package julliene.inclassassignment05_jullieneg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DailyPlan extends AppCompatActivity {
    public String tripMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_plan);
        getSupportActionBar().setTitle("Daily Plan");

        Intent intent = getIntent();

        ImageView picture = (ImageView) findViewById(R.id.locationPicture);

        TextView name = (TextView) findViewById(R.id.location);

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

    }

    public void saveNow(View view){

        TextView locationText = (TextView) findViewById(R.id.location);
        String name = locationText.getText().toString();

        TextView itemsList = (TextView) findViewById(R.id.list_item);
        String items = itemsList.getText().toString();

        TextView places = (TextView) findViewById(R.id.places_to_go);
        String toDo = places.getText().toString();

        TripPlan tripPlan = new TripPlan(items,toDo);

        tripMessage = name + "\n" +tripPlan.toString();

        Toast t=Toast.makeText(this,"Plan Saved!",Toast.LENGTH_SHORT);
        t.show();



    }

    public void openItinerary(View view) {
        Intent i = new Intent(this, TripSummary.class);
        i.putExtra("Trip Message", tripMessage);
        startActivity(i);
    }




}
