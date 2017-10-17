// Zachary Gibson
// 60975
// Program 5

package cback;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Program 5 by Zachary Gibson");
        if (args.length == 2) {
            try {
                ArrayList<Patient> patients = new ArrayList<>();
                Scanner scan = new Scanner(new File(args[0]));

                while (scan.hasNext()) {
                    String line = scan.nextLine();
                    String[] tokens = line.split(",");

                    String last = tokens[0];
                    String first = tokens[1];
                    int age = Integer.parseInt(tokens[2]);
                    int room = Integer.parseInt(tokens[3]);

                    Patient p = new Patient(last, first, age, room);
                    patients.add(p);
                }

                String sortType = args[1];
                if (sortType.equalsIgnoreCase("last")) {
                    Collections.sort(patients, new PatientLastComparator());
                } else if (sortType.equalsIgnoreCase("first")) {
                    Collections.sort(patients, new PatientFirstComparator());
                } else if (sortType.equalsIgnoreCase("age")) {
                    Collections.sort(patients, new PatientAgeComparator());
                } else if (sortType.equalsIgnoreCase("room")) {
                    Collections.sort(patients, new PatientRoomComparator());
                } else {
                    printUsage();
                    return;
                }

                System.out.printf("%-15s%-15s%-5s%-5s\n", "Last", "First", "Age", "Room");
                System.out.println("----------------------------------------");
                for (int i = 0; i < patients.size(); i++) {
                    System.out.println(patients.get(i).toString());
                }

            } catch (FileNotFoundException e) {
                printUsage();
            }
        } else {
            printUsage();
        }
    }

    public static void printUsage() {
        System.out.println("Invalid arguments. fileName and sortBy required.");
    }
}
