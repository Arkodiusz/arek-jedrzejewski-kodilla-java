package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.weather.mock.Temperatures;

public class ForumStatistics {

    private Statistics statistics;

    private int userCount;
    private int postCount;
    private int commentCount;
    private double avgPostPerUser;
    private double avgCommentPerUser;
    private double avgCommentPerPost;

    public ForumStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public void calculateAdvStatistics(Statistics statistics) {

        userCount=statistics.usersNames().size();
        postCount=statistics.postsCount();
        commentCount=statistics.commentsCount();

        avgPostPerUser=divide(postCount, userCount);
        avgCommentPerUser=divide(commentCount, userCount);
        avgCommentPerPost=divide(commentCount, postCount);
    }

    private double divide (int a, int b) {
        if (b == 0) return 0;
        return (double) a / (double)b;
    }

    public void showStatistics() {
        System.out.println(
                "  FORUM STATISTICS:" +
                "\n         userCount=" + userCount +
                "\n         postCount=" + postCount +
                "\n      commentCount=" + commentCount +
                "\n    avgPostPerUser=" + avgPostPerUser +
                "\n avgCommentPerUser=" + avgCommentPerUser +
                "\n avgCommentPerPost=" + avgCommentPerPost);
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public int getUserCount() {
        return userCount;
    }

    public int getPostCount() {
        return postCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public double getAvgPostPerUser() {
        return avgPostPerUser;
    }

    public double getAvgCommentPerUser() {
        return avgCommentPerUser;
    }

    public double getAvgCommentPerPost() {
        return avgCommentPerPost;
    }
}
