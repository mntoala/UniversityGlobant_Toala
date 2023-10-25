package Validations;
import ModelStructure.*;
import ModelStructure.Class;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class universityValidations {

    //Validacion nombres
    public static String getValidNameInput(Scanner scanner) {
        String name = "";
        while (true) {
            name = scanner.nextLine();
            if (validateName(name)) {
                break;
            } else {
                System.out.println("Invalid name. Enter correctly name.");
            }
        }
        return name;
    }
    public static boolean validateName(String name) {
        String regex = "^(?=.*[a-zA-Z\\p{L}])[a-zA-Z\\p{L}0-9\\s]+$";
        return name.matches(regex);
    }

    //validar enteros
    public static int getIntInput(Scanner scanner) {
        int numberInput = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                numberInput = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Unvalid input. Please enter a number.");
            }
        }
        return numberInput;
    }

    //Validar indices
    public static int getValidIntinRange(Scanner scanner, int max) {
        int numberEntered = 0;
        boolean isValid = false;
        do {
            try {
                numberEntered = getIntInput(scanner);
                if (numberEntered >= 1 && numberEntered <= max) {
                    isValid = true;
                } else {
                    System.out.println("Number out of range. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Unvalid entry. You must enter an integer.");
            }
        } while (!isValid);
        return numberEntered;
    }

    //validar al menos un estudiante en Add new Class
    public static void selectStudentsForClass(Scanner scanner, List<Student> students, Class newClass) {
        List<Student> selectedStudents = new ArrayList<>();

        do {
            System.out.println("Select students for the new class (Enter student numbers separated by spaces):");
            String input = scanner.nextLine();
            String[] studentNumbers = input.split(" ");

            boolean atLeastOneValid = false;

            for (String number : studentNumbers) {
                try {
                    int studentNumber = Integer.parseInt(number);
                    if (studentNumber >= 1 && studentNumber <= students.size()) {
                        Student selectedStudent = students.get(studentNumber - 1);
                        selectedStudents.add(selectedStudent);
                        atLeastOneValid = true;
                    } else {
                        System.out.println("Invalid student number: " + studentNumber);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: " + number);
                }
            }

            if (!atLeastOneValid) {
                System.out.println("You must select at least one valid student.");
            }
        } while (selectedStudents.isEmpty());

        // Add the selected students to the class
        for (Student selectedStudent : selectedStudents) {
            newClass.addStudent(selectedStudent);
        }
    }



}
