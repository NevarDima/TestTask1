package by.innowiseGroup.dnevar;

import java.io.IOException;
import java.util.*;

public class ConsoleRunner {

    static HashSet<User> users = new HashSet<>();

    public static void main(String[] args) throws IOException {

        FileController.readFile();
        menu();
        FileController.writeUsers(users);

    }

    public static void printUsers() {
        for (User user : users) {
            System.out.printf("%-10s %-10s %-20s\nRoles: %s\nPhones: %10s\n",user.name,user.surname,user.email,user.roles,user.phones);
            System.out.println();
        }
    }

    public static void createUser(){
        User user = new User();
        Scanner sc=new Scanner(System.in);

        System.out.println("name: ");
        user.name  = sc.nextLine();

        System.out.println("surname: ");
        user.surname = sc.nextLine();

        System.out.println("email: ");
        String email = sc.nextLine();
        while(!email.matches("(\\w{3,})@(\\w+\\.)([a-z]{2,4})")){
            System.out.println("invalid email");
            System.out.println("email: ");
            email = sc.nextLine();
        }
        user.email = email;

        System.out.println("roles (from 1 to 3 comma separated): ");
        String[] rolesArr = sc.nextLine().split("(\\p{Blank}+)?,(\\p{Blank}+)?");
        while(rolesArr.length < 1 || rolesArr.length > 3){
            System.out.println("invalid roles");
            System.out.println("roles (from 1 to 3 comma separated): ");
            rolesArr = sc.nextLine().split("(\\p{Blank}+)?,(\\p{Blank}+)?");
        }
        user.roles = new ArrayList<>(Arrays.asList(rolesArr));

        System.out.println("phones as 375** ******* (from 1 to 3 comma separated): ");
        String[] phonesArr = sc.nextLine().split("(\\p{Blank}+)?,(\\p{Blank}+)?");
        while(phonesArr.length < 1 || phonesArr.length > 3){
            System.out.println("invalid number of phones");
            System.out.println("phones as 375** ******* (from 1 to 3 comma separated): ");
            phonesArr = sc.nextLine().split("(\\p{Blank}+)?,(\\p{Blank}+)?");
        }
        for (int i = 0; i < phonesArr.length; i++) {
            while (!phonesArr[i].matches("375[0-9]{2}(\\p{Blank}+)[0-9]{7}")) {
                System.out.printf("invalid phone number - %s\nfor example 375** *******\nphone: ", phonesArr[i]);
                phonesArr[i] = sc.nextLine();
            }
        }
        user.phones = new ArrayList<>(Arrays.asList(phonesArr));
        users.add(user);
    }

    public static void menu(){
        Scanner sc=new Scanner(System.in);

        System.out.println("============================");
        System.out.println("|      MENU SELECTION      |");
        System.out.println("============================");
        System.out.println("| Options:                 |");
        System.out.println("|        1. Create         |");
        System.out.println("|        2. View           |");
        System.out.println("|        3. Edit           |");
        System.out.println("|        4. Exit           |");
        System.out.println("============================");
        int item = sc.nextInt();

        switch (item) {
            case 1:
                System.out.println("Create selected");
                createUser();
                menu();
                break;
            case 2:
                System.out.println("View selected");
                printUsers();
                menu();
                break;
            case 3:
                System.out.println("Edit selected");
                menu();
                break;
            case 4:
                System.out.println("Exit selected");
                break;
            default:
                System.out.println("Invalid selection");
                menu();
                break;
        }
    }
}
