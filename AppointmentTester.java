package Inheritance2;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class AppointmentTester {
    BufferedWriter writer = null;
    Scanner in = new Scanner(System.in);

    public AppointmentMaker(){
    }

    public void menuPrint() throws FileNotFoundException, IOException{
        System.out.println("Welcome to the appointment maker.");
        System.out.println("From here, you may: ");
        System.out.println("1) Save a new appointment");
        System.out.println("2) View appointments");
        System.out.println("3) Exit");
        int choice = Integer.parseInt(in.nextLine());
        menuSwitch(choice);
        menuPrint();
    }

    public void menuSwitch(int c) throws FileNotFoundException, IOException{
        switch(c){
            case 1: saveAppointmentMenu();
                break;
            case 2: viewAppointmentMenu();
                break;
            case 3: System.exit(0);
        }
    }

    public void saveDailyAppointment(){
        ArrayList<String> arr = new ArrayList<String>();
        char c = '\0';
        do{
            System.out.print("Enter your new Daily appointment: ");
            Daily d = new Daily(in.nextLine());
            String newD = d.toString();
            arr.add(newD);
            System.out.println("Appointment saved.\n");
            System.out.print("Add another Daily appointment? (y/n): ");
            c = in.next().charAt(0);
            in.nextLine();
        }while(c == 'y' || c == 'Y');
        writeDailyAppointment(arr);
    }

    public void writeDailyAppointment(ArrayList<String> arr){
        try {
            writer = new BufferedWriter(new FileWriter("./Appointments.txt", true));
            for(String str: arr) {
                writer.write(str);
            }
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }

    public void saveMonthlyAppointment(){
        ArrayList<String> arr = new ArrayList<String>();
        char c = '\0';
        Pattern dayMonth = Pattern.compile("\\d\\d");
        do{
            System.out.print("Enter your new Monthly appointment description: ");
            String a = in.nextLine();
            System.out.print("\nEnter what day of the month this new appointment will fall on (dd): ");
            String dayString = in.nextLine();
            Matcher mD = dayMonth.matcher(dayString);
            if(!mD.find()){
                System.out.println("Day value entered incorrectly. Please us 'dd' format.");
                saveMonthlyAppointment();
            }
            int b = Integer.parseInt(dayString);
            Monthly m = new Monthly(b,1,1,a);
            String newM = m.toString();
            if((m.occursOn(arr, dayString))){
                System.out.print("You have an appointment on that day. Please select another date: \n");
                in.nextLine();
                saveMonthlyAppointment();
            }
            arr.add(newM);
            System.out.println("Appointment saved.\n");
            System.out.print("Add another Monthly appointment? (y/n): ");
            c = in.next().charAt(0);
            in.nextLine();
        }while(c == 'y' || c == 'Y');
        in.nextLine();
        writeMonthlyAppointment(arr);
    }

    public void writeMonthlyAppointment(ArrayList<String> arr){
        try {
            writer = new BufferedWriter(new FileWriter("./Appointments.txt", true));
            for(String str: arr) {
                writer.write(str);
            }
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }

    public void saveOnetimeAppointment(){
        ArrayList<String> arr = new ArrayList<String>();
        Pattern dayMonth = Pattern.compile("\\d\\d");
        Pattern year = Pattern.compile("\\d\\d\\d\\d");
        char e = '\0';
        do{
            System.out.print("Enter your new Onetime appointment date beginning with the day (dd): ");
            String dayString = in.nextLine();
            Matcher mD = dayMonth.matcher(dayString);
            if(!mD.find()){
                System.out.println("Day value entered incorrectly. Please us 'dd' format.");
                saveOnetimeAppointment();
            }
            int a = Integer.parseInt(dayString);
            System.out.print("\nEnter what number month this new appointment will fall on (mm): ");
            String monthString = in.nextLine();
            Matcher mM = dayMonth.matcher(monthString);
            if(!mM.find()){
                System.out.println("Month value entered incorrectly. Please us 'mm' format.");
                saveOnetimeAppointment();
            }
            int b = Integer.parseInt(monthString);
            System.out.print("\nEnter what year this new appointment will fall on (yyyy): ");
            String yearString = in.nextLine();
            Matcher mY = year.matcher(yearString);
            if(!mY.find()){
                System.out.println("Year value entered incorrectly. Please us 'yyyy' format.");
                saveOnetimeAppointment();
            }
            int c = Integer.parseInt(yearString);
            System.out.print("\nFinally, enter a description of this new appointment: ");
            String d = in.nextLine();
            Onetime o = new Onetime(a, b, c, d);
            String newO = o.toString();
            if((o.occursOn(arr, dayString, monthString, yearString))){
                System.out.println("You have an appointment on that day. Please select another date: ");
                in.nextLine();
                saveOnetimeAppointment();
            }
            arr.add(newO);
            System.out.println("Appointment saved.\n");
            System.out.print("Add another Onetime appointment? (y/n): ");
            e = in.next().charAt(0);
            in.nextLine();
        }while(e == 'y' || e == 'Y');
        in.nextLine();
        writeOnetimeAppointment(arr);
    }

    public void writeOnetimeAppointment(ArrayList<String> arr){
        try {
            writer = new BufferedWriter(new FileWriter("./Appointments.txt", true));
            for(String str: arr) {
                writer.write(str);
            }
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }

    public void saveAppointmentMenu() throws FileNotFoundException, IOException{
        System.out.println("Welcome to the appointment saver.");
        System.out.println("From here, you may: ");
        System.out.println("1) Save a new Daily appointment");
        System.out.println("2) Save a new Monthly appointment");
        System.out.println("3) Save a new Onetime appointment");
        System.out.println("4) Return to Main Menu");
        System.out.println("5) Exit program");
        int choice = Integer.parseInt(in.nextLine());
        saveAppointmentSwitch(choice);
        saveAppointmentMenu();
    }

    public void saveAppointmentSwitch(int c) throws FileNotFoundException, IOException{
        switch(c){
            case 1: saveDailyAppointment();
                break;
            case 2: saveMonthlyAppointment();
                break;
            case 3: saveOnetimeAppointment();
                break;
            case 4: menuPrint();
                break;
            case 5: System.exit(0);
        }
    }

    public void viewAppointmentMenu() throws FileNotFoundException, IOException{
        System.out.println("Welcome to the appointment viewer.");
        System.out.println("From here, you may: ");
        System.out.println("1) View your Daily appointments");
        System.out.println("2) View your Monthly appointments");
        System.out.println("3) View your Onetime appointments");
        System.out.println("4) View all appointments");
        System.out.println("5) Return to Main Menu");
        System.out.println("6) Exit program");
        int choice = Integer.parseInt(in.nextLine());
        viewAppointmentSwitch(choice);
        viewAppointmentMenu();
    }

    public void viewAppointmentSwitch(int c) throws FileNotFoundException, IOException{
        switch(c){
            case 1: dailyPrint();
                break;
            case 2: monthlyPrint();
                break;
            case 3: onetimePrint();
                break;
            case 4: allPrint();
                break;
            case 5: menuPrint();
                break;
            case 6: System.exit(0);
        }
    }

    public void dailyPrint() throws FileNotFoundException{
        File file = new File("./Appointments.txt");
        Scanner in = null;
        try {
            in = new Scanner(file);
            System.out.println("\nYour Daily Appointments are: ");
            while(in.hasNext()){
                String line = in.nextLine();
                if(line.contains("Daily:"))
                    System.out.println(line);
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }

    public void monthlyPrint() throws FileNotFoundException{
        File file = new File("./Appointments.txt");
        Scanner in = null;
        try {
            in = new Scanner(file);
            System.out.println("\nYour Monthly Appointments are: ");
            while(in.hasNext()){
                String line = in.nextLine();
                if(line.contains("Monthly:"))
                    System.out.println(line);
            }
            System.out.println();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void onetimePrint() throws FileNotFoundException{
        File file = new File("./Appointments.txt");
        Scanner in = null;
        try {
            in = new Scanner(file);
            System.out.println("\nYour Onetime Appointments are: ");
            while(in.hasNext()){
                String line = in.nextLine();
                if(line.contains("Onetime appt:"))
                    System.out.println(line);
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }

    public void allPrint() throws IOException{
        try {
            BufferedReader br = new BufferedReader(new FileReader("./Appointments.txt"));
            String line = null;
            System.out.println("Your appointments are: ");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
