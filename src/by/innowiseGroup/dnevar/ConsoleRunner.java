package by.innowiseGroup.dnevar;

import java.io.IOException;
import java.util.*;

public class ConsoleRunner {

    static HashSet<User> users = new HashSet<>();
    static HashSet<User> findUsers = new HashSet<>();

    public static void main(String[] args) throws IOException {

        FileController.readFile();
        menu();
        FileController.writeUsers(users);

    }

    private static void printUsers() {
        for (User user : users) {
            System.out.printf("%-10s %-10s %-20s\nRoles: %s\nPhones: %10s\n",user.name,user.surname,user.email,user.roles,user.phones);
            System.out.println();
        }
    }

    private static void printUsers(HashSet<User> users) {
        for (User user : users) {
            System.out.printf("%-10s %-10s %-20s\nRoles: %s\nPhones: %10s\n",user.name,user.surname,user.email,user.roles,user.phones);
            System.out.println();
        }
    }

    private static void createUser(){
        User user = new User();
        Scanner sc=new Scanner(System.in);

        System.out.println("name: ");
        user.name  = sc.nextLine();

        System.out.println("surname: ");
        user.surname = sc.nextLine();

        System.out.println("email: ");
        String email = sc.nextLine();
        user.email = validEmail(email);

        System.out.println("roles (from 1 to 3 comma separated): ");
        String[] rolesArr = sc.nextLine().split("(\\p{Blank}+)?,(\\p{Blank}+)?");
        user.roles = new ArrayList<>(Arrays.asList(validRoles(rolesArr)));

        System.out.println("phones as 375** ******* (from 1 to 3 comma separated): ");
        String[] phonesArr = sc.nextLine().split("(\\p{Blank}+)?,(\\p{Blank}+)?");
        user.phones = new ArrayList<>(Arrays.asList(validPhones(phonesArr)));
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
        System.out.println("|        3. Search         |");
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
                System.out.println("Search selected");
                searchUsers();
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

    public static void searchUsers(){

        Scanner sc=new Scanner(System.in);

        System.out.println("type one of user items for searching: ");
        String searchWord = sc.next();
        Iterator<User> userIterator = users.iterator();
        while (!(findUsers.size()>0)) {
            while (userIterator.hasNext()) {
                User iterableUser = userIterator.next();
                if (iterableUser.name.equals(searchWord)
                        || iterableUser.surname.equals(searchWord)
                        || iterableUser.email.equals(searchWord)
                        || iterableUser.roles.contains(searchWord)
                        || iterableUser.phones.contains(searchWord)) {
                    findUsers.add(iterableUser);
                }
            }
        }
        printUsers(findUsers);
        editMenu();
    }

    private static void editMenu() {
        Scanner sc=new Scanner(System.in);

        System.out.println("============================");
        System.out.println("| Options:                 |");
        System.out.println("|        1. Edit           |");
        System.out.println("|        2. Delete         |");
        System.out.println("|        3. Exit           |");
        System.out.println("============================");
        int item = sc.nextInt();

        switch (item) {
            case 1:
                System.out.println("Edit selected");
                editUser();
                editMenu();
                break;
            case 2:
                System.out.println("Delete selected");
                users.removeAll(findUsers);
                System.out.println("Deleted");
                break;
            case 3:
                System.out.println("Exit selected");
                break;
            default:
                System.out.println("Invalid selection");
                editMenu();
                break;
        }
        findUsers.clear();
    }

    private static void editUser() {
        Scanner sc=new Scanner(System.in);
        users.removeAll(findUsers);
        Iterator<User> findUserIterator = findUsers.iterator();
        while (findUserIterator.hasNext()){
            User editingUser = findUserIterator.next();
            System.out.printf("For edit name %s type new name else press enter: ",editingUser.name);
            String name = sc.nextLine();
            if(name != null) {
                editingUser.name = name;
            }
            System.out.printf("For edit surname %s type new surname else press enter: ",editingUser.surname);
            String surname = sc.nextLine();
            if(surname != null) {
                editingUser.surname = surname;
            }
            System.out.printf("For edit email %s type new email else press enter: ",editingUser.email);
            String email = sc.nextLine();
            if(!email.isEmpty()) {
                editingUser.email = validEmail(email);
            }
            for (int i = 0; i < editingUser.roles.size(); i++) {
                System.out.printf("For edit role %s type new role else press enter: ",editingUser.roles.get(i));
                String role = sc.nextLine();
                if(!role.isEmpty()){
                    editingUser.roles.set(i,role);
                }
            }
            if(editingUser.roles.size()<3){
                for (int i = editingUser.roles.size(); i <=3 ; i++) {
                    System.out.println("Type new role for add: ");
                    editingUser.roles.set(i,sc.nextLine());
                }
            }
            for (int i = 0; i < editingUser.phones.size(); i++) {
                System.out.printf("For edit phone %s type new role else press enter: ",editingUser.phones.get(i));
                String phone = sc.nextLine();
                while (!validPhone(phone)) {
                    System.out.printf("invalid phone number - %s\nfor example 375** *******\nphone: ", phone);
                    phone = sc.nextLine();
                }
                editingUser.phones.set(i,phone);
            }
            if(editingUser.phones.size()<3){
                for (int i = editingUser.phones.size(); i <=3 ; i++) {
                    System.out.println("Type new phone for add: ");
                    String phone = sc.nextLine();
                    while (!validPhone(phone)) {
                        System.out.printf("invalid phone number - %s\nfor example 375** *******\nphone: ", phone);
                        phone = sc.nextLine();
                    }
                    editingUser.phones.set(i,phone);
                }
            }
            users.add(editingUser);
        }

    }

    private static String validEmail(String str){
        Scanner sc=new Scanner(System.in);
        while(!str.matches("(\\w{3,})@(\\w+\\.)([a-z]{2,4})")){
            System.out.println("invalid email");
            System.out.println("email: ");
            str = sc.nextLine();
        }
        return str;
    }

    private static String[] validRoles(String[] rolesArr){
        Scanner sc=new Scanner(System.in);
        while(rolesArr.length < 1 || rolesArr.length > 3){
            System.out.println("invalid roles");
            System.out.println("roles (from 1 to 3 comma separated): ");
            rolesArr = sc.nextLine().split("(\\p{Blank}+)?,(\\p{Blank}+)?");
        }
        return rolesArr;
    }

    private static String[] validPhones(String[] phonesArr){
        Scanner sc=new Scanner(System.in);
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
        return phonesArr;
    }

    private static boolean validPhone(String phone){
        return phone.matches("375[0-9]{2}(\\p{Blank}+)[0-9]{7}");
    }
}
