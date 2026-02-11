import java.util.HashMap;
import java.util.Scanner;

public class PasswordManager {
    private HashMap<String, String> passwordStore;

    public PasswordManager() {
        passwordStore = new HashMap<>();
    }

    public void addPassword(String website, String password) {
        passwordStore.put(website, password);
    }

    public String getPassword(String website) {
        return passwordStore.get(website);
    }

    public void showPasswords() {
        for (String website : passwordStore.keySet()) {
            System.out.println("Website: " + website + " | Password: " + passwordStore.get(website));
        }
    }

    public static void main(String[] args) {
        PasswordManager manager = new PasswordManager();
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.print("Enter command (add, get, show, exit): ");
            command = scanner.nextLine();

            if (command.equals("add")) {
                System.out.print("Enter website: ");
                String website = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                manager.addPassword(website, password);
                System.out.println("Password added.");
            } else if (command.equals("get")) {
                System.out.print("Enter website: ");
                String website = scanner.nextLine();
                String password = manager.getPassword(website);
                if (password != null) {
                    System.out.println("Password for " + website + ": " + password);
                } else {
                    System.out.println("No password found for " + website);
                }
            } else if (command.equals("show")) {
                manager.showPasswords();
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Unknown command.");
            }
        }
        scanner.close();
    }
}