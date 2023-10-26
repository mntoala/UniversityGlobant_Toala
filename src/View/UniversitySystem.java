package View;

import Model.*;
import Model.Class;
import Controller.*;
import java.util.List;
import java.util.Scanner;


public class UniversitySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Teachers
        Teacher teacher1 = new FullTimeTeacher("Dr. Juan Perez",23, 2.3); University.addTeacher(teacher1);
        Teacher teacher2 = new FullTimeTeacher("Ing. Jeremy Smith",23, 5); University.addTeacher(teacher2);
        Teacher teacher3 = new PartTimeTeacher("Dr. Genesis Black",23, 20); University.addTeacher(teacher3);
        Teacher teacher4 = new PartTimeTeacher("Ing. Nicky Elliott",23, 20); University.addTeacher(teacher4);
        //Students
        Student student1= new Student(988230486, "Sofia Blum", 23); University.addStudent(student1);
        Student student2= new Student(983335486, "Kevin Mendez", 20); University.addStudent(student2);
        Student student3= new Student(988373825, "Soraya Zapata", 21); University.addStudent(student3);
        Student student4= new Student(930307809, "David Suarez", 20); University.addStudent(student4);
        Student student5= new Student(938765434, "Melanie Torres", 21); University.addStudent(student5);
        Student student6= new Student(933838943, "Alex Spencer", 22); University.addStudent(student6);
        //Classes
        Class math1= new Class("Math 1","AULA 114", teacher2);
        math1.addStudent(student1);math1.addStudent(student2);math1.addStudent(student6); University.addClass(math1);
        Class math2= new Class("Math 2","AULA 116", teacher4);
        math2.addStudent(student2);math2.addStudent(student3);math2.addStudent(student4); University.addClass(math2);
        Class ecology= new Class("Ecology","AULA 320", teacher3);
        ecology.addStudent(student3);ecology.addStudent(student4);ecology.addStudent(student5); University.addClass(ecology);
        Class ecology2= new Class("Ecology Advanced","AULA 323", teacher1);
        ecology2.addStudent(student3);ecology2.addStudent(student5);ecology2.addStudent(student6); University.addClass(ecology2);

        //Listas
        List<Teacher> teachers= University.getTeachers();
        List<Student> students = University.getStudents();
        List<Class> classes = University.getClasses();


        System.out.println("******** Welcome to the University System ********\n");
        boolean start = true;
        while(start){
            System.out.println("\nSelect the option:\n" +
                    "1. Teachers Information.\n" +
                    "2. Classes Information.\n" +
                    "3. Add new Student.\n" +
                    "4. Add new Class.\n" +
                    "5. Search for a student's classes.\n" +
                    "6. Exit System.");
            int numberOption= universityValidations.getIntInput(scanner);

            switch (numberOption){
                // 1. Teachers Information.
                case(1):
                    int i=1;
                    for (Teacher teacher: teachers){
                        List<Class> classesTaught = University.findClassesByTeacher(teacher);
                        teacher.classesTaught(i,classesTaught);
                        i++;
                    }
                    break;

                // 2. Classes Information.
                case(2):
                    i=1;
                    //Printing class list
                    System.out.println("\nClass List\n");
                    for (Class aclass: classes){
                        System.out.println(i+". "+aclass.getClassName());
                        i++;
                    }
                    //Choosing class and validate
                    System.out.println("\nSelect the class");
                    int classOption = universityValidations.getValidIntinRange(scanner,classes.size());
                    Class aClass= classes.get(classOption-1);
                    //Print details
                    System.out.println(aClass.toString());
                    break;

                // 3. Add new Student.
                case(3):
                    System.out.println("\nAdd new student\n");
                    //Student's Information
                    System.out.println("Student's id:");
                    int newStudentId = universityValidations.validateAndAdjustId(scanner,students);
                    System.out.println("Student's name:");
                    String newStudentName = universityValidations.getValidNameInput(scanner);
                    System.out.println("Student's age:");
                    int newStudentAge = universityValidations.getIntInput(scanner);
                    University.addStudent(new Student(newStudentId,newStudentName,newStudentAge));
                    //Add to a class with a list of an existing classes
                    System.out.println("\nAdd to a class:");
                    i=1;
                    for (Class aclass: classes){
                        System.out.println(i+". "+aclass.getClassName());
                        i++;
                    }
                    //Choosing class and validate
                    System.out.println("\nSelect the class");
                    int classOpt=universityValidations.getValidIntinRange(scanner,classes.size());
                    Class newStudentClass= classes.get(classOpt-1);
                    //Selecting the last student added
                    int sizeStudent=students.size()-1;
                    Student newStudent= students.get(sizeStudent);
                    //Adding student in selected class
                    newStudentClass.addStudent(newStudent);
                    //Showing the student's classes
                    List<Class> studentClasses = University.findClassesByStudent(newStudent);
                    System.out.println("\nNew Student's Information");
                    newStudent.studentClass(studentClasses);
                    break;

                // 4. Add new Class.
                case(4):
                    System.out.println("\nAdd new Class\n");
                    //Student's Information
                    System.out.println("What is the class name?");
                    String newClassName=universityValidations.getValidNameInput(scanner);
                    System.out.println("Where is the classroom?");
                    String newClassRoom=scanner.nextLine();
                    //Selecting Teacher
                    System.out.println("Who is the teacher?");
                    System.out.println("\nSelect Teacher:");
                    i=1;
                    for (Teacher teacher: teachers){
                        System.out.println(" "+i+". "+teacher.getName());
                        i++;
                    }
                    int teacherSelected= universityValidations.getValidIntinRange(scanner, teachers.size());
                    Teacher teacherNewClass =teachers.get(teacherSelected-1);
                    //Adding the new class
                    Class newClass= new Class(newClassName, newClassRoom, teacherNewClass);
                    //Adding Students
                    System.out.println("\nWho are students in this class?");
                    i=1;
                    for (Student student: students){
                        System.out.println(" "+i+". "+student.getName());
                        i++;
                    }
                    //Entering numbers of students and validate that
                    universityValidations.selectStudentsForClass(scanner,students,newClass);
                    //Adding class to University
                    University.addClass(newClass);
                    break;

                // 5. Search for a student's classes.
                case(5):
                    System.out.println("Students List:");
                    i=1;
                    for (Student student: students){
                        System.out.println(" "+i+". "+student.getName()+" - id: 0"+student.getId());
                        i++;
                    }
                    //Selecting student to show information and validate
                    int numberStudentSelected = universityValidations.getValidIntinRange(scanner, students.size())-1;
                    Student studentSelected = students.get(numberStudentSelected);
                    List<Class> studentSelectedClasses= University.findClassesByStudent(studentSelected);
                    System.out.println("\n"+studentSelected.getName()+" Classes");
                    for(Class clase: studentSelectedClasses){
                        System.out.println(" - "+clase.getClassName());
                    }
                    break;
                // 6. Exit System.
                case(6):
                    System.out.println("Bye bye!");
                    start= false;
                // wrong number
                default:
                    System.out.println("Try again in the specified range");
            }

        }




        scanner.close();
    }
}