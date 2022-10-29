package Inheritance2;

    import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

    public class Monthly extends Appointment
    {
        public Monthly(int day, int month, int year, String description) {
            super(day, month, year, description);
        }
        public boolean occursOn(ArrayList<String> arr, String day) {
            for(String a : arr){
                if(a.contains(day)){
                    return true;
                }
            }
            return false;
        }

        public String toString(){
            return "Monthly: " + description + " on every " + day + " of the month\n";
        }
    }


