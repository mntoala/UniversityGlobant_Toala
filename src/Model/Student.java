package Model;

import java.util.List;

public class Student {
    private String id;
    private String name;
    private int age;

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    /**
     * Imprime los datos del estudiante y la lista de clases recibidas.
     * @param studentClass - Recibe lista de clases del estudiante
     */
    public void printStudentClass(List<Class> studentClass) {
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
