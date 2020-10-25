package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private List<ForumUser> userList = new ArrayList<>();

    public Forum() {
        userList.add(new ForumUser(1, "user1", 'F', LocalDate.parse("2000-9-11")));
        userList.add(new ForumUser(2, "user2", 'M', LocalDate.parse("1999-7-14")));
        userList.add(new ForumUser(3, "user3", 'F', LocalDate.parse("2015-3-1")));
        userList.add(new ForumUser(4, "user4", 'M', LocalDate.parse("2001-12-2")));
        userList.add(new ForumUser(5, "user5", 'F', LocalDate.parse("2012-10-17")));
        userList.add(new ForumUser(6, "user6", 'M', LocalDate.parse("2005-8-12")));
        userList.add(new ForumUser(7, "user7", 'F', LocalDate.parse("1990-6-6")));
        userList.add(new ForumUser(8, "user8", 'M', LocalDate.parse("1984-4-9")));
        userList.add(new ForumUser(9, "user9", 'F', LocalDate.parse("1991-2-25")));
    }

    public List<ForumUser> getUserList() {
        return userList;
    }
}
