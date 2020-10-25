package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {

        Forum forum = new Forum();

        Map<Integer, ForumUser> usersMap = forum.getUserList().stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> user.getBirthDate().isBefore(LocalDate.now().minusYears(20)))
                .filter(user -> user.getPostCount()>=1)
                .collect(Collectors.toMap(ForumUser::getId, user -> user));

        System.out.println("\n# elements: " + usersMap.size());
        usersMap.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}