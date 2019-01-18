package Practical_Code.JavaFX;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Elhosany on 9/10/2016.
 */
public class Person
{
    private StringProperty firstname = new SimpleStringProperty("TheFirstName");
    /*Means on changing Value of it or set it an action will make*/


/**  Lma age a3ml Property Instance lazem ykon leh getter w setter le value bta3o w kman function btrg3
 *  el property object*/


    //return the value
    public String getFirstname() {
        return firstname.get();
    }
    //return the Object
    public StringProperty firstnameProperty() {
        return firstname;
    }
    //set the value
    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }
}
