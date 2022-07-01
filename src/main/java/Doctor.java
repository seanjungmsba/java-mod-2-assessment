public class Doctor {
    
    private String name;
    private String provideSpecialty;

    public Doctor() {
        this.name = null;
        this.provideSpecialty = null;
    }

    public Doctor(String name, String provideSpecialty) {
        this.name = name;
        this.provideSpecialty = provideSpecialty;
    }

    public String getDoctorName() {
        return this.name;
    }

    public void setDoctorName(String name) {
        this.name = name;
    }

    public String getDoctorSpecialty() {
        return this.provideSpecialty;
    }

    public void setDoctorSpecialty(String provideSpecialty) {
        this.provideSpecialty = provideSpecialty;
    }

    @Override
    public String toString() {
        return "Doctor: [Name = " + name + ", Specialty = " + provideSpecialty  + "]";
    }
 
}
