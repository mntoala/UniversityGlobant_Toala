package ModelStructure;


public class FullTimeTeacher extends Teacher{
    private double experienceYears;
    private static final double hoursPerWeek= 40;
    public FullTimeTeacher(String name, double baseSalary, double experienceYears) {
        super(name, baseSalary);
        this.experienceYears = experienceYears;
        super.setSalary(getSalary());
    }
    /**
     * @return salario diferenciado segun sus anios de experiencia y las horas trabajados a la semana
     */
    public double getSalary() {
        return super.getBaseSalary() * (1.10 * experienceYears)*hoursPerWeek;
    }
}
