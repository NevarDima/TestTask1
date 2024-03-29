package by.innowiseGroup.dnevar;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class FileController {

    private static String usersTxt = getFilePath(FileController.class,"users.txt");

    static void writeUsers (HashSet<User> users) throws IOException {
        StringBuilder writeToFile = new StringBuilder();
        String delimiter = "";
        for (User user : users) {
            writeToFile.append(delimiter).append(convertToString(user));
            delimiter = "\n";
        }
        saveFile(writeToFile.toString());
    }

    private static String convertToString(User user) {
        return user.name
                +"\n" + user.surname
                +"\n" + user.email
                +"\n" + user.getRoles()
                +"\n" + user.getPhones();
    }

    private static void saveFile(String str) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(usersTxt))){
            out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void readFile(){
        try(BufferedReader br = new BufferedReader(new FileReader(usersTxt))){
            String line;
            int counter = 0;
            String[] strArr = new String[5];
            for(;br.ready();){
                line = br.readLine();
                if(line.equals("")) {
                    break;
                }
                strArr[counter] = line;


                counter++;
                if(counter == 5){
                    counter = 0;
                    ConsoleRunner.users.add(createUserFromLines(strArr));

                    strArr = new String[5];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static User createUserFromLines(String[] strArr) {
        User user = new User();
        user.name = strArr[0];
        user.surname = strArr[1];
        user.email =strArr[2];
        user.roles = new ArrayList<>(Arrays.asList(strArr[3].split("(\\p{Blank}+)?,(\\p{Blank}+)?")));
        user.phones = new ArrayList<>(Arrays.asList(strArr[4].split("(\\p{Blank}+)?,(\\p{Blank}+)?")));
        return user;
    }

    private static String getPath (Class<?> aClass){
        String root = System.getProperty("user.dir")
                + File.separator
                +"src"
                + File.separator;
        String name = aClass.getName()
                .replace(aClass.getSimpleName(),"")
                .replace(".", File.separator);
        return root+name;
    }

    private static String getFilePath(Class<?> aClass, String filename){
        return getPath(aClass)+filename;
    }
}
