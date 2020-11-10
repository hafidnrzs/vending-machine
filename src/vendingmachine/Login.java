package vendingmachine;

import java.util.Scanner;
import java.io.File;

public class Login {
    private static Scanner x;
    public static void userLogin() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Masukkan username:");
        String username = userInput.nextLine();
        System.out.println("Masukkan password:");
        String password = userInput.nextLine();
        userInput.close();

        String filepath = "userinfo/user.txt";

        verifyLogin(username, password, filepath);
    }

    public static void verifyLogin(String username, String password, String filepath) {
        boolean found = false;
        String tempUsername = "";
        String tempPassword = "";

        try {
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while(x.hasNext() && !found) {
                tempUsername = x.next();
                tempPassword = x.next();

                if(tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())) {
                    found = true;
                }
            }
            x.close();
            System.out.println(found);

        } catch(Exception e) {
            System.out.println("Error");
        }
    }
}
