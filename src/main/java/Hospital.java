import java.util.List;
import java.util.LinkedList;

public class Hospital {

    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital() {
        this.doctors = new LinkedList<Doctor>();
        this.patients = new LinkedList<Patient>();
    }

    public Hospital(LinkedList<Doctor> doctors, LinkedList<Patient> patients) {
        this.doctors = doctors;
        this.patients = patients;
    }

    public void addDoctor(String doctorName, String doctorSpecialty) {
        Doctor doctorToAdd = new Doctor(doctorName, doctorSpecialty);
        doctors.add(doctorToAdd);
    }

    public void addPatient(String patientName, String needSpecialty) {
        Patient patientToAdd = new Patient(patientName, needSpecialty);
        patients.add(patientToAdd);

    }

    public void printAllDoctors() {
        for (Doctor d : doctors) {
            System.out.println(d);
        }
    }

    public void printAllPatients() {
        for (Patient p : patients) {
            System.out.println(p);
        }
    }

    public void matchPatientWithDoctor() {
        for (Doctor d : doctors) {
            for (Patient p : patients) {
                if (d.getDoctorSpecialty().equals(p.getNeedSpecialty())) {
                    System.out.println("doctor " + d.getDoctorName() + " is matched with patient " + p.getName());
                }
            }
        }
    }

}
