package Inheritance2;

import java.util.ArrayList;

public class Appointment {
        protected String description;
        protected int day;
        protected int month;
        protected int year;

        public Appointment(int day, int month, int year, String description){
            this.description = description;
            this.day = day;
            this.month = month;
            this.year = year;
        }

        public int getDay(){
            return day;
        }

        public int getMonth(){
            return month;
        }

        public int getYear(){
            return year;
        }

        public String getDescription(){
            return description;
        }

        public boolean occursOn(ArrayList<String> arr, String day, String month, String year){
            for(String a : arr){
                if(a.contains(month + "/" + day + "/" + year)){
                    return true;
                }
            }
            return false;
        }

        public String toString(){
            return getDescription() + " on: " + getMonth() + "/" + getDay() + "/" + getYear() + "\n";
        }
    }

