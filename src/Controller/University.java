package Controller;

import Model.Class;
import Model.Student;
import Model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class University {
    private static List<Teacher> teachers = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();
    private static List<Class> classes = new ArrayList<>();


    public static void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static void addClass(Class clase) {
        classes.add(clase);
    }

    public static List<Teacher> getTeachers() {
        return teachers;
    }

    public static List<Student> getStudents() {
        return students;
    }

    public static List<Class> getClasses() {
        return classes;
    }

    public static List<Class> findClassesByStudent(Student student) {
        List<Class> studentClasses = new ArrayList<>();
        for (Class aClass : classes) {
            if (aClass.getStudents().contains(student)) {
                studentClasses.add(aClass);
            }
        }
        return studentClasses;
    }

    public static List<Class> findClassesByTeacher(Teacher teacher) {
        List<Class> teacherClasses = new ArrayList<>();
        for (Class aClass : classes) {
            if (aClass.getTeacher().equals(teacher)) {
                teacherClasses.add(aClass);
            }
        }
        return teacherClasses;
    }

}

