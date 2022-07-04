public class Doctor {

    private String name;
    private Specialty specialty;

    public Doctor() {
        this.name = null;
        this.specialty = null;
    }

    public Doctor(String name, Specialty specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public String getDoctorName() {
        return this.name;
    }

    public void setDoctorName(String name) {
        this.name = name;
    }

    public Specialty getSpecialty() {
        return this.specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Doctor: [Name: " + name + ", Specialty: " + specialty + "]";
    }

}
