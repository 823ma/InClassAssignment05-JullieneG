package julliene.inclassassignment05_jullieneg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DailyPlan extends AppCompatActivity {

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

    public void openItinerary(View view) {
        Intent i = new Intent(this, TripSummary.class);
        startActivity(i);
    }



}
