package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, User> mapPrev = new HashMap<>();
        for (User user : previous) {
            mapPrev.put(user.getId(), user);
        }
        int added = 0;
        int changed = 0;
        for (User user : current) {
            User userMap = mapPrev.get(user.getId());
            if (userMap == null) {
                added++;
                continue;
            }
            if (!userMap.equals(user)) {
                changed++;
            }
        }
        int deleted = previous.size() - current.size() + added;
        return new Info(added, changed, deleted);
    }

}
