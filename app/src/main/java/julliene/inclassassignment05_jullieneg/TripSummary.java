package julliene.inclassassignment05_jullieneg;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class TripSummary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_summary);
        getSupportActionBar().setTitle("Trip Summary");
        Intent intent = getIntent();
        String tripMessage = intent.getStringExtra("Trip Message");
        TextView display = (TextView)findViewById(R.id.fullItinerary);
        display.setText(tripMessage);
    }

    public void shareNow(View view) {
        TextView display = (TextView)findViewById(R.id.fullItinerary);

        String mailContext = display.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Come join the trip!");
        intent.putExtra(Intent.EXTRA_TEXT, mailContext);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

        }
    }
}
