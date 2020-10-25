package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int id;
    private final String nickname;
    private final char sex;
    private final LocalDate birthDate;
    private int postCount;

    public ForumUser(final int id, final String nickname, final char sex, final LocalDate birthDate) {
        this.id = id;
        this.nickname = nickname;
        this.sex = sex;
        this.birthDate = birthDate;
        this.postCount = 0;
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostCount() {
        return postCount;
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }


}
