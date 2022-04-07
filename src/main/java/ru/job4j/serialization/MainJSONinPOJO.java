package ru.job4j.serialization;

import org.json.JSONArray;
import org.json.JSONObject;
import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

public class MainJSONinPOJO {
    public static void main(String[] args) throws JAXBException {
        JSONObject jsonContact = new JSONObject("{\"phone\":\"+7 (111) 111-11-11\",\"zipCode\":\"123456\"}");
        List<String> list = new ArrayList<>();
        list.add("Student");
        list.add("Free");
        JSONArray jsonStatuses = new JSONArray(list);

        final Human human = new Human(false, 30, "Ivan",
                new Contact(11111, "32-345"), new int[] {1, 2, 3});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", human.isFlag());
        jsonObject.put("age", human.getAge());
        jsonObject.put("name", human.getName());
        jsonObject.put("contact", jsonContact);
        jsonObject.put("statuses", jsonStatuses);

        System.out.println(jsonObject);

        System.out.println(new JSONObject(human));
    }
}

