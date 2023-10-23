package ModelStructure;

public class FullTimeTeacher extends Teacher{
    private double experienceYears;

    public FullTimeTeacher(String name, double baseSalary, double experienceYears) {
        super(name, baseSalary);
        this.experienceYears = experienceYears;
    }

    public double getSalary() {
        return super.getSalary() * (1.1 * experienceYears);
    }
}
