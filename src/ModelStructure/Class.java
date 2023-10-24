package ModelStructure;

import java.util.ArrayList;
import java.util.Collection;
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

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }
    @Override
    public String toString() {
        return "Class: '" + className + '\'' +
                ", Classroom: '" + classroom + '\'' +
                ", Teacher: " + teacher +
                ", Students: " + students;
    }
}
