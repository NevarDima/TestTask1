package by.innowiseGroup.dnevar;

import java.io.IOException;
import java.util.*;

public class ConsoleRunner {

    private static HashSet<User> users = new HashSet<>();

    private static int id = 0;

    public static void main(String[] args) throws IOException {
//        User user1 = new User();
//        user1.name = "Dima";
//        user1.surname = "jdsfbjhg";
//        user1.email = "jlsbfhs@lksh.sdf";
//        user1.roles = new ArrayList<>(Arrays.asList("role1","role2","role3"));
//        user1.phones = new ArrayList<>(Arrays.asList("18364523671","23852736","3274576"));
//
//        User user2 = new User();
//        user2.name = "sfhsh";
//        user2.surname = "dshdhsd";
//        user2.email = "dshsdh@hds.ahs";
//        user2.roles = new ArrayList<>(Arrays.asList("dshh","shjsjnf","shsthsfh"));
//        user2.phones = new ArrayList<>(Arrays.asList("3462563","346565","56256524"));
//
//        users.add(user1);
//        users.add(user2);
//        FileController.writeUsers(users);

        FileController.readFile();










//	    Scanner sc=new Scanner(System.in);
//	    String line;

//        System.out.println("Для создания пользователя введите: имя, фамилия, email, роли, мобильные телефоны(Количество ролей и телефонов от 1 до 3-х.)");
//        System.out.println("Для поиска пользователя введите \"find\" и затем");
//        System.out.println("Для печати всех пользоватедлей введите \"printall\"");
//        System.out.println("Для завершения программы введите \"end\"");
//
//        while(!(line = sc.nextLine()).equals("end")){
//            if(line.equals("printall")) {
//                printUsers();
//            }else{
//                Var result = parser.calc(line);
//                printer.print(result);
//            }
//        }
//    }
//
//    public static void printUsers() {
//        for(Map.Entry<Integer, String> entry: users.entrySet()){
//            System.out.println(entry.getKey()+": "+entry.getValue());
//        }
    }
}
