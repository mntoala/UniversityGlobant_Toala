package ModelStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class University {
    private List<Teacher> teachers;
    private List<Student> students;
    private List<Class> classes;

    public University() {
        teachers = new ArrayList<>();
        students = new ArrayList<>();
        classes = new ArrayList<>();
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addClass(Class clase) {
        classes.add(clase);
    }

    public List<Class> findClassesByStudent(Student student) {
        List<Class> studentClasses = new ArrayList<>();
        for (Class aClass : classes) {
            if (aClass.getStudents().contains(student)) {
                studentClasses.add(aClass);
            }
        }
        return studentClasses;
    }

    public List<Class> findClassesByTeacher(Teacher teacher) {
        List<Class> teacherClasses = new ArrayList<>();
        for (Class aClass : classes) {
            if (aClass.getTeacher().equals(teacher)) {
                teacherClasses.add(aClass);
            }
        }
        return teacherClasses;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Class> getClasses() {
        return classes;
    }

}

