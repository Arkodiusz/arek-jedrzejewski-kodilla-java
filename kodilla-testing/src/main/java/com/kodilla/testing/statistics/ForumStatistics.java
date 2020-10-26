package com.kodilla.testing.statistics;

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

        avgPostPerUser=(double)postCount/(double)userCount;
        avgCommentPerUser=(double)commentCount/(double)userCount;
        avgCommentPerPost=(double)commentCount/(double)postCount;

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
