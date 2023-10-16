package com.for_comprehension.function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class User {

    public static void main(String[] args) {
        List.of("a", "b").subList(0, 1).stream().sorted().map(i -> i + "a")

        User user = new User(new ArrayList<>(List.of("box")));
        List<String> items1 = user.getItems();
        transform(items1);

        System.out.println(user);
    }

    User(List<String> items) {
        items.addAll(items);
    }

    private final List<String> items = new ArrayList<>();

    List<String> getItems() {
        return new ArrayList<>(items);
    }

    public static List<String> transform(List<String> strings) {
        strings.clear();
        return List.of("");
    }

    @Override
    public String toString() {
        return "User{" +
          "items=" + items +
          '}';
    }
}


