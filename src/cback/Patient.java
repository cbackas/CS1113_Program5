// Zachary Gibson
// 60975
// Program 5

package cback;

import java.util.Comparator;

class PatientFirstComparator implements Comparator<Patient> {
    public int compare(Patient p1, Patient p2) {
        String name1 = p1.getFirst();
        String name2 = p2.getFirst();
        return name1.compareTo(name2);
    }
}

class PatientLastComparator implements Comparator<Patient> {
    public int compare(Patient p1, Patient p2) {
        String name1 = p1.getLast();
        String name2 = p2.getLast();
        return name1.compareTo(name2);
    }
}

class PatientAgeComparator implements Comparator<Patient> {
    public int compare(Patient p1, Patient p2) {
        int age1 = p1.getAge();
        int age2 = p2.getAge();
        return age1 - age2;
    }
}

class PatientRoomComparator implements Comparator<Patient> {
    public int compare(Patient p1, Patient p2) {
        int room1 = p1.getRoom();
        int room2 = p2.getRoom();
        return room1 - room2;
    }
}

public class Patient {
    private String lastName;
    private String firstName;
    private int age;
    private int roomNum;

    public Patient(String lastName, String firstName, int age, int roomNum) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.roomNum = roomNum;
    }

    public String toString() {
        String s = String.format("%-15s%-15s%5d%5d", lastName, firstName, age, roomNum);
        return s;
    }

    public String getLast() {
        return lastName;
    }

    public String getFirst() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public int getRoom() {
        return roomNum;
    }
}
