package julliene.inclassassignment05_jullieneg;

import java.io.Serializable;



public class TripPlan implements Serializable {
    private String items;
    private String toDo;

    public TripPlan(String items, String thingsToDo) {
        this.items = items;
        this.toDo = thingsToDo;
    }

    @Override
    public String toString() {
        return "Items to Bring: " + items + "\n" +
                "\nPlaces to Go: " + toDo + "\n" +
                "\nHope to see you there!";
    }
}
