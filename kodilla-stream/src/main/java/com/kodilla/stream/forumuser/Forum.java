package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private List<ForumUser> userList = new ArrayList<>();

    public Forum() {
        userList.add(new ForumUser(1, "user1", 'F', LocalDate.parse("2002-09-13"), 0));
        userList.add(new ForumUser(2, "user2", 'M', LocalDate.parse("1999-07-14"), 7));
        userList.add(new ForumUser(3, "user3", 'F', LocalDate.parse("1995-03-01"), 0));
        userList.add(new ForumUser(4, "user4", 'M', LocalDate.parse("2001-12-02"), 0));
        userList.add(new ForumUser(5, "user5", 'F', LocalDate.parse("2012-10-17"), 0));
        userList.add(new ForumUser(6, "user6", 'M', LocalDate.parse("2003-08-12"), 1));
        userList.add(new ForumUser(7, "user7", 'F', LocalDate.parse("1990-06-06"), 2));
        userList.add(new ForumUser(8, "user8", 'M', LocalDate.parse("1984-04-09"), 3));
        userList.add(new ForumUser(9, "user9", 'F', LocalDate.parse("1991-02-25"), 4));
    }

    public List<ForumUser> getUserList() {
        return userList;
    }
}
