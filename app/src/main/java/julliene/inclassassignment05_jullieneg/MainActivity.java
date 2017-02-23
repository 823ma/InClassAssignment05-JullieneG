package julliene.inclassassignment05_jullieneg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDayOne(View view) {
        Intent i = new Intent(this, Day1.class);
        startActivity(i);
    }

    public void openDayTwo(View view) {
        Intent i = new Intent(this, Day2.class);
        startActivity(i);
    }

    public void openDayThree(View view) {
        Intent i = new Intent(this, Day3.class);
        startActivity(i);
    }

    public void openDayFour(View view) {
        Intent i = new Intent(this, Day4.class);
        startActivity(i);
    }
}
