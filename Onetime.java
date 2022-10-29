package Inheritance2;

public class Onetime extends Appointment{
    public Onetime(int day, int month, int year, String description){
        super(day, month, year, description);
    }

    public String toString(){
        return "Onetime appt: " + super.toString();
    }

}
