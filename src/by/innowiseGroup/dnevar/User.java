package by.innowiseGroup.dnevar;

import java.util.ArrayList;
import java.util.List;

class User {

    String name;
    String surname;
    String email;
    List<String> roles = new ArrayList<>();
    List<String> phones = new ArrayList<>();

    String getRoles(){
        StringBuilder res = new StringBuilder();
        String delimiter = "";
        for (int i = 0; i<roles.size(); i++) {
            res.append(delimiter).append(roles.get(i));
            delimiter = ",";
        }
        return res.toString();
    }


    String getPhones() {
        StringBuilder res = new StringBuilder();
        String delimiter = "";
        for (int i = 0; i<phones.size(); i++) {
            res.append(delimiter).append(phones.get(i));
            delimiter = ",";
        }
        return res.toString();
    }
}
