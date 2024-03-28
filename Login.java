import java.util.*;

public class Login {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int log = 0;
        boolean loggedIn = false;

        while (log < 3 && !loggedIn) {
            try {
                System.out.print("Enter password: ");
                String password = input.nextLine();

                if (!password.equals("password")) {
                    log++;
                    throw new InvalidAttemptException("Invalid password. Please try again.");
                }

                loggedIn = true;
                System.out.println("Login successful!");

            }
            catch (InvalidAttemptException e) {
                System.out.println(e.getMessage());
            }
        }

        if (!loggedIn) {
            try {
                throw new MaxAttemptsException("Maximum login attempts exceeded.");
            }
            catch (MaxAttemptsException e) {
                System.out.println(e.getMessage());
            }
        }

        input.close();
        System.out.println("Program is terminated");
    }
}