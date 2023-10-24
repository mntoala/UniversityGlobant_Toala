import ModelStructure.*;
import ModelStructure.Class;

import java.util.Scanner;

public class UniversitySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        University university= new University();
        //Teachers
        Teacher teacher1 = new FullTimeTeacher("Dr. Juan Perez",23, 2.3);
        Teacher teacher2 = new FullTimeTeacher("Ing. Jeremy Smith",20.5, 5);
        Teacher teacher3 = new PartTimeTeacher("Dr. Genesis Black",23, 32);
        Teacher teacher4 = new PartTimeTeacher("Ing. Nicky Elliott",20.5, 32);
        //Students
        Student student1= new Student(988239487, "Sofia Montenegro", 23);
        Student student2= new Student(983335486, "Karin Mendez", 20);
        Student student3= new Student(988373825, "Soraya Zapata", 21);
        Student student4= new Student(930307809, "David Suarez", 20);
        Student student5= new Student(938765434, "Melanie Torres", 21);
        Student student6= new Student(933838943, "Alex Spencer", 22);
        //Classes
        Class math1= new Class("Math 1","AULA 114", teacher2);
        math1.addStudent(student1);math1.addStudent(student2);math1.addStudent(student6);
        Class math2= new Class("Math 2","AULA 116", teacher4);
        math2.addStudent(student2);math2.addStudent(student3);math2.addStudent(student4);
        Class ecology= new Class("Ecology","AULA 320", teacher3);
        ecology.addStudent(student3);ecology.addStudent(student4);ecology.addStudent(student5);
        Class ecology2= new Class("Ecology Advanced","AULA 323", teacher3);
        ecology.addStudent(student3);ecology.addStudent(student5);ecology.addStudent(student6);


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
            int numberOption;
            try {
                numberOption = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            switch (numberOption){
                // 1. Teachers Information.
                case(1):
                    break;
                // 2. Classes Information.
                case(2):
                    break;
                // 3. Add new Student.
                case(3):
                    break;
                // 4. Add new Class.
                case(4):
                    break;
                // 5. Search for a student's classes.
                case(5):
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