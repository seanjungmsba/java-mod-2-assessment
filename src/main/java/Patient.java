public class Patient {

    private String name;
    private Symptom symptom;

    public Patient() {
        this.name = null;
        this.symptom = null;
    }

    public Patient(String name, Symptom symptom) {
        this.name = name;
        this.symptom = symptom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symptom getSymptom() {
        return this.symptom;
    }

    public void setSymptom(Symptom symptom) {
        this.symptom = symptom;
    }

    @Override
    public String toString() {
        return "Patient: [Name: " + name + ", Symptom: " + symptom + "]";
    }

}
