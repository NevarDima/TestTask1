package by.innowiseGroup.dnevar;

import java.util.ArrayList;
import java.util.List;

public class User {

    String name;
    String surname;
    String email;
    List<String> roles = new ArrayList<>();
    List<String> phones = new ArrayList<>();

    public String getRoles(){
        String res = "";
        String delimiter = "";
        for (int i = 0; i<roles.size(); i++) {
            res += delimiter + roles.get(i);
            delimiter = ",";
        }
        return res;
    }


    public String getPhones() {
        String res = "";
        String delimiter = "";
        for (int i = 0; i<phones.size(); i++) {
            res += delimiter + phones.get(i);
            delimiter = ",";
        }
        return res;
    }
}
