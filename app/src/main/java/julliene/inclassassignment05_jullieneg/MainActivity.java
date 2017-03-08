package julliene.inclassassignment05_jullieneg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDay(View view) {
        Intent intent = new Intent(this, DailyPlan.class);

       switch (view.getId()){

           case R.id.day1:

                   location = "Eiffel Tower";
               break;

           case R.id.day2:

                   location = "Notre Dame";
               break;

           case R.id.day3:

                   location = "Louvre Museum";
               break;

           case R.id.day4:

                   location = "Luxembourg Gardens";
               break;
       }
        intent.putExtra("Location", location);
        startActivity(intent);
    }

}
