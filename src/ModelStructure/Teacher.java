package ModelStructure;

import java.util.List;

public class Teacher implements Employee{
    private String name;
    private double baseSalary;
    private double salary;
    public Teacher(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }
    @Override
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void classesTaught(int i, List<Class> classesTaught) {
        StringBuilder sb = new StringBuilder();
        sb.append(i).append(". Teacher: ").append(name).append("\n");
        sb.append("   Salary: ").append(salary).append("\n");
        sb.append("   Clases Taught:\n");
        for (Class aClass : classesTaught) {
            sb.append("   - ").append(aClass.getClassName()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
