package com.example.student.searchuser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataProvider {

    public static List<User> users = new ArrayList<>();

    public static void initUsersList() {
        List<String> VahanImages = new ArrayList<>();         
        users.add(new User("Vahan", "description", Arrays.asList(new String[]{"https://avatars0.githubusercontent.com/u/37872230?s=400&v=4"}), "tel:055751551","gmail",5f));
        users.add(new User("Anush", "description", Arrays.asList(new String[]{"https://avatars3.githubusercontent.com/u/37871971?s=400&v=4"}), "tel:055751551","gmail",5f));
        users.add(new User("Arman", "description", Arrays.asList(new String[]{"https://avatars1.githubusercontent.com/u/28303490?s=400&v=4"}), "tel:055751551","gmail",5f));
        users.add(new User("Anahit", "description", Arrays.asList(new String[]{"https://avatars3.githubusercontent.com/u/37872594?s=400&v=4"}), "tel:055751551","gmail",5f));
        users.add(new User("Samvel", "description", Arrays.asList(new String[]{"https://avatars1.githubusercontent.com/u/37870577?s=400&v=4"}), "tel:055751551","gmail",5f));
        users.add(new User("Astghik", "description", Arrays.asList(new String[]{"https://avatars1.githubusercontent.com/u/37845415?s=400&v=4"}), "tel:055751551","gmail",5f));
        users.add(new User("Stepan", "description", Arrays.asList(new String[]{"https://avatars0.githubusercontent.com/u/9980436?s=400&v=4"}), "tel:055751551","gmail",5f));
    }
}
