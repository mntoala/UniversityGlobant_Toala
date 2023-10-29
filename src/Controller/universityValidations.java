package Controller;
import Model.*;
import Model.Class;

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

    //Validar id
    public static int validateAndAdjustId(Scanner scanner, List<Student> students) {
        boolean validId = false;
        int id = 0;

        while (!validId) {
            // Leer un ID del usuario
            String inputId = scanner.nextLine();
            // Eliminar ceros iniciales y verificar la longitud
            String idString = inputId.replaceFirst("^0+", "");
            if (idString.length() == 9) {
                id = Integer.parseInt(idString);
                // Verificar duplicados
                boolean isDuplicate = false;
                for (Student student : students) {
                    if (student.getId() == id) {
                        System.out.println("This student ID is already in use. Please enter a new ID:");
                        isDuplicate = true;
                        break;
                    }
                }
                if (!isDuplicate) {
                    validId = true;
                }
            } else {
                System.out.println("Invalid student ID. It must have 10 digits and start with 0. Please enter a new ID:");
            }
        }
        return id;
    }

    //Validacion id
    public static int getValidIdInput(Scanner scanner, List<Student> students) {
        int id = 0;
        boolean validId = false;
        while (!validId) {
            String inputID = scanner.nextLine();
            if (validateId(inputID)) {
                id = Integer.parseInt(inputID);
                // Verificar duplicados
                boolean isDuplicate = false;
                for (Student student : students) {
                    if (student.getId() == id) {
                        System.out.println("This student ID is already in use. Please enter a new ID:");
                        isDuplicate = true;
                        break;
                    }
                }
                if (!isDuplicate) {
                    validId = true;
                }
            } else {
                System.out.println("Invalid ID. Please enter a 10-digit numeric ID.");
            }
        }
        return id;
    }
    public static boolean validateId(String input) {
        return input.matches("^\\d{10}$");
    }
    //




}
