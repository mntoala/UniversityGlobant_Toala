package Validations;
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
                System.out.println("Invalid name. Enter only letters and special characters.");
            }
        }
        return name;
    }
    public static boolean validateName(String name) {
        String regex = "^[a-zA-Z\\p{L}]+$";
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
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return numberInput;
    }


}
