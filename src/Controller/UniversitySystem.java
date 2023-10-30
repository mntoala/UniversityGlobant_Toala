package Controller;
import Model.*;
import Model.Class;

import java.util.List;
import java.util.Scanner;
public class UniversitySystem {
    /**
     * Se obtiene la informacion de los maestros
     * @param teachers lista de profesores
     */
    public static void teacherInformation(List<Teacher> teachers){
        int i=1;
        for (Teacher teacher: teachers){
            List<Class> classesTaught = University.findClassesByTeacher(teacher);
            teacher.classesTaught(i,classesTaught);
            i++;
        }
    }

    /**
     * Presenta un listado de clases
     * @param classes listado de clases
     */
    public static void classList(List<Class> classes){
        int i=1;
        for (Class aclass: classes){
            System.out.println(i+". "+aclass.getClassName());
            i++;
        }
    }

    /**
     * Permite escoger una de las opciones listadas en la clase
     * @param scanner
     * @param classes
     */
    public static void chooseClass(Scanner scanner, List<Class> classes){
        int classOption = Validations.getValidIntinRange(scanner,classes.size());
        Class aClass= classes.get(classOption-1);
        System.out.println(aClass.toString());
    }

    /**
     * Obtiene los datos y agrega un nuevo estudiante
     * @param scanner
     * @param students listado de estudiantes al que se agrega
     * @param classes listado de clases que recibira
     */
    public static void getAddNewStudentInformation(Scanner scanner, List<Student> students, List<Class> classes){
        System.out.println("Student's id:");
        String newStudentId = Validations.getValidIdInput(scanner,students);
        System.out.println("Student's name:");
        String newStudentName = Validations.getValidNameInput(scanner);
        System.out.println("Student's age:");
        int newStudentAge = Validations.getIntInput(scanner);
        University.addStudent(new Student(newStudentId,newStudentName,newStudentAge));
        addStudentToClass(scanner, classes, students);
    }

    /**
     * Agrega un estudiante a la clase seleccionada
     * @param scanner
     * @param classes listado de clases para print
     * @param students
     */
    public static void addStudentToClass(Scanner scanner, List<Class> classes, List<Student> students){
        System.out.println("\nAdd to a class:");
        //Selecting the last student added
        Student newStudent= getNewStudent(students);
        classList(classes);
        //Choosing class and validate
        Validations.validSelecttionClassesForStudent(scanner,classes,newStudent);
    }

    /**
     * SE obtiene el nuevo estudiante
     * @param students listado de estudiantes del que se obtiene al nuevo
     * @return nuevo estudiante
     */
    public static Student getNewStudent(List<Student> students){
        int sizeStudent=students.size()-1;
        return students.get(sizeStudent);
    }

    /**
     * Muestra las clases del estudiante escogido
     * @param newStudent
     */
    public static void showStudentClasses(Student newStudent){
        List<Class> studentClasses = University.findClassesByStudent(newStudent);
        System.out.println("\nNew Student's Information");
        newStudent.printStudentClass(studentClasses);
    }

    /**
     * Se obtienen los datos y se agrega una nueva clase
     * @param scanner
     * @param teachers listado de maestros a escoger
     * @param students listado de estudiantes a escoger
     */
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

    /**
     * Se obtiene al maestro para la nueva clase
     * @param teachers listado de maestros
     * @return maestro de la nueva clase
     */
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

    /**
     * Se escogen los estudiantes para la nueva clase
     * @param students lista de estudiantes
     * @param newClass la nueva clase
     */
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

    /**
     * Se permite escoger un estudiante y se muestra su informacion de clase.
     * @param students listado de estudiante
     */
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
