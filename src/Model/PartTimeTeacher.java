package Model;

public class PartTimeTeacher extends Teacher{
    private double activeHoursPerWeek;

    public PartTimeTeacher(String name, double baseSalary, double activeHoursPerWeek) {
        super(name, baseSalary);
        this.activeHoursPerWeek = activeHoursPerWeek;
        super.setSalary(getSalary());
    }

    /**
     * @return Salario diferenciado segun las horas trabajadas por semana
     */
    @Override
    public double getSalary() {
      return super.getBaseSalary()*activeHoursPerWeek;
    }
}
