package ModelStructure;

public class PartTimeTeacher extends Teacher{
    private double activeHoursPerWeek;

    public PartTimeTeacher(String name, double baseSalary, double activeHoursPerWeek) {
        super(name, baseSalary);
        this.activeHoursPerWeek = activeHoursPerWeek;
    }
    @Override
    public double getSalary() {
        return super.getSalary()*activeHoursPerWeek;
    }
}
