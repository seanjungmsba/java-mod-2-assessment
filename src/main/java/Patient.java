public class Patient {

    private String name;
    private String needSpecialty;

    public Patient() {
        this.name = null;
        this.needSpecialty = null;
    }

    public Patient(String name, String needSpecialty) {
        this.name = name;
        this.needSpecialty = needSpecialty;
    }

    public String getName() {
        return name;
    }

    public String getNeedSpecialty() {
        return needSpecialty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNeedSpecialty(String needSpecialty) {
        this.needSpecialty = needSpecialty;
    }

    @Override
    public String toString() {
        return "Patient: [Name = " + name + ", Need specialty = " + needSpecialty + "]";
    }

}
