import java.util.Scanner;

public class HospitalWorld {

    static Hospital hospital;

    /* HospitalWorld method */
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
                System.out.println("---------- Doctor " + num + " ----------");
                Doctor doc = createDoctor(scanner);
                hospital.addDoctor(doc);
            }

            System.out.println("=============== ENTERING PATIENT INFO ===============");
            System.out.print("How many patient(s) do you want in '" + hospitalName + "' hospital? ");

            int numberofPatients = getInputInt(scanner, 1, 2147483647);

            for (int i = 0; i < numberofPatients; i++) {
                int num = i + 1;
                System.out.println("---------- Patient " + num + " ----------");
                hospital.addPatient(createPatient(scanner));
            }
            hospital.printHospitalInfo();
        } catch (Exception e) {
            log(e.toString());
        }
        scanner.close();
    }

    /* creating a Patient object from user input */
    private static Patient createPatient(Scanner sc) {
        String name;
        int symptomIndex;
        Symptom symptom;
        HospitalWorld.log("Enter the name of the patient: ");
        name = HospitalWorld.getInputString(sc);

        HospitalWorld.log("What is the symptom the patient is experiencing? ");
        HospitalWorld.log("\n");
        for (Symptom s : Symptom.values()) {
            System.out.println(s.getIndex() + ": " + s);
        }

        HospitalWorld.log("Enter the symptom of the patient by the number (1-5): ");
        symptomIndex = HospitalWorld.getInputInt(sc, 1, 5);
        symptom = Symptom.values()[symptomIndex - 1];
        return new Patient(name, symptom);
    }

    /* creating a Doctor object from user input */
    private static Doctor createDoctor(Scanner sc) {
        String name;
        Specialty specialty;
        HospitalWorld.log("Enter the name of the doctor: ");
        name = HospitalWorld.getInputString(sc);
        HospitalWorld.log("Which of the following specialty the doctor is specialized in? ");
        HospitalWorld.log("\n");
        for (Specialty s : Specialty.values()) {
            System.out.println(s.getIndex() + ": " + s);
        }
        HospitalWorld.log("Enter the specialty of the doctor by the number (1-5): ");
        int specialIndex = HospitalWorld.getInputInt(sc, 1, 5);
        specialty = Specialty.values()[specialIndex - 1];
        return new Doctor(name, specialty);
    }

    /* exception handling from user input for integer values */
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

    /* exception handling from user input for string values */
    public static String getInputString(Scanner sc) {
        try {
            String s = sc.nextLine();
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

    // System.out.print() helper
    public static void log(String str) {
        System.out.print(str);
    }
}