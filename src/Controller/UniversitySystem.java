package Controller;
import Model.*;
import Model.Class;

import java.util.List;
import java.util.Scanner;
public class UniversitySystem {
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
    public static void getAddNewStudentInformation(Scanner scanner, List<Student> students, List<Class> classes){
        System.out.println("Student's id:");
        String newStudentId = Validations.getValidIdInput(scanner,students);
        System.out.println(newStudentId);
        System.out.println("Student's name:");
        String newStudentName = Validations.getValidNameInput(scanner);
        System.out.println("Student's age:");
        int newStudentAge = Validations.getIntInput(scanner);
        University.addStudent(new Student(newStudentId,newStudentName,newStudentAge));
        addStudentToClass(scanner, classes, students);
    }
    public static void addStudentToClass(Scanner scanner, List<Class> classes, List<Student> students){
        System.out.println("\nAdd to a class:");
        //Selecting the last student added
        Student newStudent= getNewStudent(students);
        classList(classes);
        //Choosing class and validate
        Validations.selectClassesForStudent(scanner,classes,newStudent);
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
    public static void getAddNewClassInformation(Scanner scanner, List<Teacher> teachers, List<Student> students){
        //Student's Information
        System.out.println("What is the class name?");
        String newClassName= Validations.getValidNameInput(scanner);
        System.out.println("Where is the classroom?");
        String newClassRoom=scanner.nextLine();
        //Selecting teacher
        Teacher teacherNewClass = getTeacherNewClass(scanner, teachers);
        //Adding the new class
        Class newClass= new Class(newClassName, newClassRoom, teacherNewClass);
        selectingStudentsInNewClass(scanner, students, newClass);


    }
    public static Teacher getTeacherNewClass(Scanner scanner,List<Teacher> teachers){
        System.out.println("Who is the teacher?");
        System.out.println("\nSelect Teacher:");
        int i=1;
        for (Teacher teacher: teachers){
            System.out.println(" "+i+". "+teacher.getName());
            i++;
        }
        int teacherSelected= Validations.getValidIntinRange(scanner, teachers.size());
        return teachers.get(teacherSelected-1);
    }
    public static void selectingStudentsInNewClass(Scanner scanner, List<Student> students, Class newClass){
        //Adding Students
        System.out.println("\nWho are students in this class?");
        int i=1;
        for (Student student: students){
            System.out.println(" "+i+". "+student.getName());
            i++;
        }
        //Entering numbers of students and validate that
        Validations.selectStudentsForClass(scanner,students,newClass);
        //Adding class to University
        University.addClass(newClass);
    }
    public static void searchStudentClasses(Scanner scanner, List<Student> students){
        System.out.println("Students List:");
        Validations.validateStudentList(students);
        //Selecting student to show information and validate
        int numberStudentSelected = Validations.getValidIntinRange(scanner, students.size())-1;
        Student studentSelected = students.get(numberStudentSelected);
        List<Class> studentSelectedClasses= University.findClassesByStudent(studentSelected);
        System.out.println("\n"+studentSelected.getName()+" Classes");
        for(Class clase: studentSelectedClasses){
            System.out.println(" - "+clase.getClassName());
        }
    }

}
