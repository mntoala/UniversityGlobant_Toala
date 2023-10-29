package Model;

import java.util.ArrayList;
import java.util.List;

public class Class {
    private String className;
    private String classroom;
    private Teacher teacher;
    private List<Student> students;

    public Class(String className, String classroom, Teacher teacher) {
        this.className = className;
        this.classroom = classroom;
        this.teacher = teacher;
        this.students = new ArrayList<>();
    }

    public String getClassName() {
        return className;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Agrega estudiante a la lista de estudiantes de la clasa
     * @param student Estudiante que se agregara
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Elimina estudiante de la lista de estudiantes de la clase
     * @param student Estudiate que se quitara
     */
    public void removeStudent(Student student) {
        students.remove(student);
    }

    /**
     * Metodo donde se obtienen el listado imprimible de los estudiantes de una clase
     * @param students listado de estudiantes pertenecientes a la clase
     * @return String con la lista de estudiantes ya iterada
     */
    public String printStudents(List<Student> students){
        StringBuilder sb = new StringBuilder();
        for (Student student: students) {
            sb.append("   - ").append(student.getName()).append("\n");
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return "* Class: " + className + '\n' +
                "  Classroom: " + classroom + '\n' +
                "  Teacher: " + teacher.getName() + '\n' +
                "  Students: \n" + printStudents(students);
    }
}
