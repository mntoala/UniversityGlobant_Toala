import java.util.Scanner;

public class UniversitySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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