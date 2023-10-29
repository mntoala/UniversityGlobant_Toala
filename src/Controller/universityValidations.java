package Controller;
import Model.*;
import Model.Class;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class universityValidations {

    /**
     * Se obtiene y el nombre ingresado por el usuario. Se repite hasta que se ingrese un nombre correcto
     * @param scanner
     * @return el nombre ingresado por el usuario
     */
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

    /**
     * Se valida que el nombre cumpla con tener solo letras, espacios, sea mayuscula o minuscula
     * y no tenga numeros por que los nombres no llevan numeros.
     * @param name
     * @return boolean si cumple o no la validacion.
     */
    public static boolean validateName(String name) {
        String regex = "^(?=.*[a-zA-Z\\p{L}])[a-zA-Z\\p{L}0-9\\s]+$";
        return name.matches(regex);
    }

    /**
     * Metodo que solicita y valida enteros.
     * @param scanner
     * @return el numero ingresado
     */
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

    /**
     * Metodo que solicita y valida que el numero ingresado se encuentre dentro el listado de opciones
     * @param scanner
     * @param max tamano de la lista de opciones brindadas al usuario
     * @return el numero ingresado
     */
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

    /**
     * Valida que al menos un estudiante esta siendo ingresado a la clase nueva
     * @param scanner
     * @param students lista de estudiantes en la clase nueva
     * @param newClass clase nueva que se encuentra en proceso de creacion.
     */
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

    /**
     * Metodo que solicita y valida que el numero ingresado como id sea valido
     * @param scanner
     * @param students lista de estudiantes para verificar que no exista previamente ese id
     * @return Devuelve el id del estudiante
     */
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

    /**
     * Valida que el id cumpla con tener 10 digitos y todos sean numeros
     * @param id id ingresado por estudiante
     * @return booleano de si cumple o no
     */
    public static boolean validateId(String id) {
        return id.matches("^\\d{10}$");
    }

    /**
     * Valida que al imprimir el id de los estudiantes se agregue un 0 si solo tienen 9 digitos
     * y se mantenga tal cual si tiene 10
     * @param students lista de estudiantes
     */
    public static void validateStudentList(List<Student> students){
        int i=1;
        for (Student student: students){
            String id= String.valueOf(student.getId());
            if (id.length()==9){
                System.out.println(" "+i+". "+student.getName()+" - id: 0"+student.getId());
                i++;
            }else if(id.length()==10){
                System.out.println(" "+i+". "+student.getName()+" - id: "+student.getId());
                i++;
            }
        }
    }




}
