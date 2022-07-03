import java.util.Scanner;

public class Main {
    static Hospital hospital;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Welcome to virtual hospital World!");
            System.out.print("To start off, please enter the name of the hospital: ");
            String hospitalName = getInputString(scanner);
            Hospital hospital = new Hospital(hospitalName);

            System.out.println("=============== ENTERING DOCTOR INFO ===============");
            System.out.print("How many doctor(s) do you want in '" + hospitalName + "' hospital? ");

            int numberofDoctors = getInputInt(scanner, 1, 2147483647);

            for (int i = 0; i < numberofDoctors; i++) {
                int num = i + 1;
                System.out.println("----- Doctor " + num + " -----");
                Doctor doc = createDoctor(scanner);
                hospital.addDoctor(doc);
            }

            System.out.println("=============== ENTERING PATIENT INFO ===============");
            System.out.print("How many patient(s) do you want in '" + hospitalName + "' hospital? ");

            int numberofPatients = getInputInt(scanner, 1, 2147483647);

            for (int i = 0; i < numberofPatients; i++) {
                int num = i + 1;
                System.out.println("----- Patient " + num + " -----");
                hospital.addPatient(createPatient(scanner));
            }
            hospital.printHospitalInfo();
            // hospital.printPatientChart();
        } catch (Exception e) {
            log(e.toString());
        }
        scanner.close();
    }

    private static Patient createPatient(Scanner sc) {
        String name;
        int symptomIndex;
        Symptom symptom;
        Main.log("Enter the name of the patient: ");
        name = Main.getInputString(sc);

        Main.log("What is the symptom the patient is experiencing? ");
        Main.log("\n");
        for (Symptom s : Symptom.values()) {
            System.out.println(s.getIndex() + ": " + s);
        }

        Main.log("Enter the symptom of the patient by the number (1-5): ");
        symptomIndex = Main.getInputInt(sc, 1, 5);
        symptom = Symptom.values()[symptomIndex - 1];
        return new Patient(name, symptom);
    }

    private static Doctor createDoctor(Scanner sc) {

        String name;
        Specialty specialty;

        Main.log("Enter the name of the doctor: ");
        name = Main.getInputString(sc);

        Main.log("Which of the following specialty the doctor is specialized in? ");
        Main.log("\n");
        for (Specialty s : Specialty.values()) {
            System.out.println(s.getIndex() + ": " + s);
        }
        Main.log("Enter the specialty of the doctor by the number (1-5): ");
        int specialIndex = Main.getInputInt(sc, 1, 5);
        specialty = Specialty.values()[specialIndex - 1];
        return new Doctor(name, specialty);
    }

    public static int getInputInt(Scanner sc, int min, int max) {

        try {
            String s = sc.nextLine();
            int i = Integer.parseInt(s);
            if (!(i >= min && i <= max)) {
                log("ERROR: Re-enter the valid input: ");
                return getInputInt(sc, min, max);
            }
            return i;
        } catch (Exception e) {
            log("ERROR: Re-enter the valid input: ");
            return getInputInt(sc, min, max);
        }

    }

    public static String getInputString(Scanner sc) {
        try {
            String s = sc.nextLine(); // ""
            if (s.equals("")) {
                System.out.print("ERROR: ENTER THE VALID INPUT: ");
                return getInputString(sc);
            }
            return s;
        } catch (Exception e) {
            System.out.print("ERROR: ENTER THE VALID INPUT: ");
            return getInputString(sc);
        }
    }

    public static void log(String str) {
        System.out.print(str);
    }
}