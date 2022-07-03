import java.util.Scanner;
import java.util.Map;

public class HospitalWorld {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            Hospital hospital = new Hospital();
            System.out.println("Welcome to the Hospital World!");
            System.out.print("Please enter the name of the hospital: ");
            String hospitalName = getValidStringInput(sc);

            System.out.print("How many doctors do you want in " + hospitalName + "? ");

            int numberofDoctors = getValidIntegerInput(sc);

            for (int i = 0; i < numberofDoctors; i++) {
                askDoctorInfo(hospital, sc);
            }

            System.out.println("=======================================================");
            System.out.print("How many patients do you want in " + hospitalName + "? ");
            int numberofPatients = getValidIntegerInput(sc);

            for (int i = 0; i < numberofPatients; i++) {
                askPatientInfo(hospital, sc);
            }

            displayHospitalInfo(hospital, hospitalName);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void askDoctorInfo(Hospital hospital, Scanner sc) {

        try {
            System.out.print("Enter the NAME of doctor: ");
            String doctorName = getValidStringInput(sc);

            System.out.print("Enter the SPECIALTY of doctor from the following: ");
            hospital.returnSpecialty();
            int doctorSpecialty = getValidIntegerInput(sc);
            hospital.addDoctor(doctorName);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void printDoctors(Hospital hospital) {
        System.out.println("We have the following doctors in our hospital: ");
        hospital.printAllDoctors();
    }

    public static void askPatientInfo(Hospital hospital, Scanner sc) {

        try {
            System.out.print("Enter the NAME of patient: ");
            String patientName = getValidStringInput(sc);

            System.out.print("Enter the SYMPTOM which the patient experiences: ");
            String patientSpecialty = getValidStringInput(sc);

            hospital.addPatient(patientName, patientSpecialty);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void printPatients(Hospital hospital) {
        System.out.println("We have the following patients in our hospital: ");
        hospital.printAllPatients();
    }

    public static int getValidIntegerInput(Scanner sc) {

        try {
            String s = sc.nextLine();
            int i = Integer.parseInt(s);
            return i;
        } catch (Exception e) {
            System.out.print("ERORR: Re-enter the valid input: ");
            return getValidIntegerInput(sc);
        }

    }

    public static String getValidStringInput(Scanner sc) {
        try {
            String s = sc.nextLine(); // ""
            if (s.equals("")) {
                System.out.print("ERROR: ENTER THE VALID INPUT: ");
                return getValidStringInput(sc);
            }
            return s;
        } catch (Exception e) {
            System.out.print("ERROR: ENTER THE VALID INPUT: ");
            return getValidStringInput(sc);
        }
    }

    public static void displayHospitalInfo(Hospital hospital, String hospitalName) {
        System.out.println("================ DISPLAYING HOSPITAL WORLD ================");
        System.out.println("Hospital Name: " + hospitalName);
        System.out.print("\n");
        printDoctors(hospital);
        System.out.print("\n");
        printPatients(hospital);
        System.out.print("\n");
        System.out.println("------------ Match Result ------------");
        hospital.matchPatientWithDoctor();
    }

}
