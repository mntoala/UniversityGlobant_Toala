package ModelStructure;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void studentClass(List<Class> studentClass) {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        sb.append("Id: ").append(id).append("\n");
        sb.append("Age: ").append(age).append(" years\n");
        sb.append("Clases:\n");
        for (Class aClass : studentClass) {
            sb.append(" - ").append(aClass.getClassName()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
