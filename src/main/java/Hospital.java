import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Hospital {

    private String hospitalName;
    private List<Doctor> doctors;
    private List<Patient> patients;
    private Map<Symptom, Specialty> symptomToSpecialty; // matching symptom and specialty
    private Map<Doctor, List<Patient>> patientMap; // matching doctors with patients
    private Map<Specialty, List<Doctor>> doctorMap; // return doctors based on speciality

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new LinkedList<Doctor>();
        this.patients = new LinkedList<Patient>();
        this.symptomToSpecialty = new HashMap<Symptom, Specialty>();
        symptomToSpecialty.put(Symptom.ATOPY, Specialty.DERMATOLOGY);
        symptomToSpecialty.put(Symptom.CYSTITIS, Specialty.UROLOGY);
        symptomToSpecialty.put(Symptom.DWARFISM, Specialty.PEDIATRICS);
        symptomToSpecialty.put(Symptom.OSTEOARTHRITIS, Specialty.ORTHOPEDICS);
        symptomToSpecialty.put(Symptom.EPILEPSY, Specialty.NEUROLOGY);
        patientMap = new HashMap<>();
        doctorMap = new HashMap<>();
    }

    public List<Doctor> getDoctorNames() {
        return doctors;
    }

    public List<Patient> getPatientNames() {
        return patients;
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

    public void addDoctor(Doctor doctor) {
        Specialty specialty = doctor.getSpecialty();
        this.doctors.add(doctor);
        List<Doctor> doctorList = new LinkedList<Doctor>();
        doctorList.add(doctor);
        doctorMap.put(specialty, doctorList);
    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);
        Specialty specialty = findSpecialty(patient.getSymptom()); // find specialty based on patient symptom
        Doctor doctor = findDoctor(specialty); // find doctor based on specialty

        if (patientMap.containsKey(doctor)) { // handling a doctor who needs to take care more than one patient
            List<Patient> patientList = patientMap.get(doctor);
            patientList.add(patient);
            if (doctor != null) { // if the key is not null, add it to patientMap
                patientMap.put(doctor, patientList);
            }
        } else { // handling a doctor who needs to take care of new patient
            List<Patient> newPatientList = new LinkedList<Patient>();
            newPatientList.add(patient);
            if (doctor != null) { // if the key is not null, add it to patientMap
                patientMap.put(doctor, newPatientList);
            }
        }
    }

    public Doctor findDoctor(Specialty specialty) {
        List<Doctor> doctorList = doctorMap.get(specialty);
        if (isEmpty(doctorList)) {
            return null;
        }
        for (Doctor doctor : doctorList) {
            return doctor;
        }
        return null;
    }

    public Specialty findSpecialty(Symptom symptom) {
        return symptomToSpecialty.get(symptom);
    }

    public void returnSpecialty() {
        for (Map.Entry<Symptom, Specialty> entry : symptomToSpecialty.entrySet()) {
            System.out.println("Specialty: " + entry.getValue().toString());
        }
    }

    public void returnSymptom() {
        for (Map.Entry<Symptom, Specialty> entry : symptomToSpecialty.entrySet()) {
            System.out.println("Symptom: " + entry.getKey());
        }
    }

    public Map<Symptom, Specialty> getSymptomToSpecialty() {
        return symptomToSpecialty;
    }

    public Map<Doctor, List<Patient>> getPatientMap() {
        return patientMap;
    }

    public Map<Specialty, List<Doctor>> getDoctorMap() {
        return doctorMap;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    @Override
    public String toString() {
        return "Name of the hospital: " + this.hospitalName;
    }

    public void printHospitalInfo() {
        System.out.println();
        System.out.println("=========== PRINTING HOSPITAL INFO ===========");
        System.out.println("Hosptial Name: " + getHospitalName());
        System.out.println("Available Specialties: \n" + Arrays.asList(Specialty.values()));
        System.out.println("Available Symptoms: \n" + Arrays.asList(Symptom.values()));
        System.out.println("---------------------------");
        System.out.println("Doctors in the hospital: ");
        System.out.println(getDoctorNames());
        System.out.println("---------------------------");
        System.out.println("Patients in the hospital: ");
        System.out.println(getPatientNames());
        System.out.println("---------------------------");
        System.out.println("Matching patient(s) with doctor(s) based on the symptom and specialty:");
        System.out.println(patientMap);
    }

}
