package Controller;
import Model.*;
import Model.Class;
import Controller.*;
import java.util.List;
import java.util.Scanner;
public class UniversirySystem {
    public static void teacherInformation(List<Teacher> teachers){
        int i=1;
        for (Teacher teacher: teachers){
            List<Class> classesTaught = University.findClassesByTeacher(teacher);
            teacher.classesTaught(i,classesTaught);
            i++;
        }
    }
    public static void classList(List<Class> classes){
        int i=1;
        for (Class aclass: classes){
            System.out.println(i+". "+aclass.getClassName());
            i++;
        }
    }
    public static void chooseClass(Scanner scanner, List<Class> classes){
        int classOption = Validations.getValidIntinRange(scanner,classes.size());
        Class aClass= classes.get(classOption-1);
        System.out.println(aClass.toString());
    }
    public static void getNewStudentInformation(Scanner scanner, List<Student> students){
        System.out.println("Student's id:");
        int newStudentId = Validations.getValidIdInput(scanner,students);
        System.out.println(newStudentId);
        System.out.println("Student's name:");
        String newStudentName = Validations.getValidNameInput(scanner);
        System.out.println("Student's age:");
        int newStudentAge = Validations.getIntInput(scanner);
        University.addStudent(new Student(newStudentId,newStudentName,newStudentAge));
    }
    public static void addStudentToClass(Scanner scanner, List<Class> classes, List<Student> students){
        System.out.println("\nAdd to a class:");
        classList(classes);
        //Choosing class and validate
        System.out.println("\nSelect the class");
        int classOpt= Validations.getValidIntinRange(scanner,classes.size());
        Class newStudentClass= classes.get(classOpt-1);
        //Selecting the last student added
        int sizeStudent=students.size()-1;
        Student newStudent= students.get(sizeStudent);
        newStudentClass.addStudent(newStudent);
    }
    public static Student getNewStudent(List<Student> students){
        int sizeStudent=students.size()-1;
        return students.get(sizeStudent);
    }

    public static void showStudentClasses(Student newStudent){
        List<Class> studentClasses = University.findClassesByStudent(newStudent);
        System.out.println("\nNew Student's Information");
        newStudent.printStudentClass(studentClasses);
    }

}
