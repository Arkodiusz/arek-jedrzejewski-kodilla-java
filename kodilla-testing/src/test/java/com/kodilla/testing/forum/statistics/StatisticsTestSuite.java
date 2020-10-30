package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatisticsTestSuite {

    @InjectMocks
    private ForumStatistics forumMock;

    @Mock
    private Statistics statisticsMock;

    private List<String> generateListOfNUsers(int usersQuantity) {
        List<String> resultList = new ArrayList<>();
        for (int n = 1; n <= usersQuantity; n++){
            String userName = "user" + n;
            resultList.add(userName);
        }
        return resultList;
    }

    @BeforeEach
    public void before() {
        System.out.println("------");
    }

    @AfterEach
    public void after() { System.out.println("------"); }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("StatisticsTestSuite Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("StatisticsTestSuite Test Suite: end");
    }

    @Test
    @DisplayName("Posts = 0")
    void testCalculateAdvStatisticsPosts0() {
        //Given
        int usersQuantity = 13;
        int postsQuantity = 0;
        int commentsQuantity = 70;

        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsers(usersQuantity));
        when(statisticsMock.postsCount()).thenReturn(postsQuantity);
        when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);

        //When
        forumMock.calculateAdvStatistics(statisticsMock);
        forumMock.showStatistics();

        //Then
        Assertions.assertEquals((double)postsQuantity/(double)usersQuantity, forumMock.getAvgPostPerUser());
        Assertions.assertEquals((double)commentsQuantity/(double)usersQuantity, forumMock.getAvgCommentPerUser());
        Assertions.assertEquals((double)commentsQuantity/(double)postsQuantity, forumMock.getAvgCommentPerPost());
    }

    @Test
    @DisplayName("Posts = 100")
    void testCalculateAdvStatisticsPosts1000() {
        //Given
        int usersQuantity = 13;
        int postsQuantity = 100;
        int commentsQuantity = 70;

        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsers(usersQuantity));
        when(statisticsMock.postsCount()).thenReturn(postsQuantity);
        when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);

        //When
        forumMock.calculateAdvStatistics(statisticsMock);
        forumMock.showStatistics();

        //Then
        Assertions.assertEquals((double)postsQuantity/(double)usersQuantity, forumMock.getAvgPostPerUser());
        Assertions.assertEquals((double)commentsQuantity/(double)usersQuantity, forumMock.getAvgCommentPerUser());
        Assertions.assertEquals((double)commentsQuantity/(double)postsQuantity, forumMock.getAvgCommentPerPost());
    }

    @Test
    @DisplayName("Comments = 0")
    void testCalculateAdvStatisticsComments0() {
        //Given
        int usersQuantity = 13;
        int postsQuantity = 30;
        int commentsQuantity = 0;

        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsers(usersQuantity));
        when(statisticsMock.postsCount()).thenReturn(postsQuantity);
        when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);

        //When
        forumMock.calculateAdvStatistics(statisticsMock);
        forumMock.showStatistics();

        //Then
        Assertions.assertEquals((double)postsQuantity/(double)usersQuantity, forumMock.getAvgPostPerUser());
        Assertions.assertEquals((double)commentsQuantity/(double)usersQuantity, forumMock.getAvgCommentPerUser());
        Assertions.assertEquals((double)commentsQuantity/(double)postsQuantity, forumMock.getAvgCommentPerPost());
    }

    @Test
    @DisplayName("Posts < Comments>")
    void testCalculateAdvStatisticsCommentsLtPosts() {
        //Given
        int usersQuantity = 46;
        int postsQuantity = 665;
        int commentsQuantity = 1300;

        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsers(usersQuantity));
        when(statisticsMock.postsCount()).thenReturn(postsQuantity);
        when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);

        //When
        forumMock.calculateAdvStatistics(statisticsMock);
        forumMock.showStatistics();

        //Then
        Assertions.assertEquals((double)postsQuantity/(double)usersQuantity, forumMock.getAvgPostPerUser());
        Assertions.assertEquals((double)commentsQuantity/(double)usersQuantity, forumMock.getAvgCommentPerUser());
        Assertions.assertEquals((double)commentsQuantity/(double)postsQuantity, forumMock.getAvgCommentPerPost());

    }

    @Test
    @DisplayName("Posts > Comments")
    void testCalculateAdvStatisticsCommentsGtPosts() {
        //Given
        int usersQuantity = 13;
        int postsQuantity = 875;
        int commentsQuantity = 332;

        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsers(usersQuantity));
        when(statisticsMock.postsCount()).thenReturn(postsQuantity);
        when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);

        //When
        forumMock.calculateAdvStatistics(statisticsMock);
        forumMock.showStatistics();

        //Then
        Assertions.assertEquals((double)postsQuantity/(double)usersQuantity, forumMock.getAvgPostPerUser());
        Assertions.assertEquals((double)commentsQuantity/(double)usersQuantity, forumMock.getAvgCommentPerUser());
        Assertions.assertEquals((double)commentsQuantity/(double)postsQuantity, forumMock.getAvgCommentPerPost());
    }

    @Test
    @DisplayName("Users = 0")
    void testCalculateAdvStatisticsUsers0() {
        //Given
        int usersQuantity = 0;
        int postsQuantity = 70;
        int commentsQuantity = 70;

        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsers(usersQuantity));
        when(statisticsMock.postsCount()).thenReturn(postsQuantity);
        when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);

        //When
        forumMock.calculateAdvStatistics(statisticsMock);
        forumMock.showStatistics();

        //Then
        Assertions.assertEquals((double)postsQuantity/(double)usersQuantity, forumMock.getAvgPostPerUser());
        Assertions.assertEquals((double)commentsQuantity/(double)usersQuantity, forumMock.getAvgCommentPerUser());
        Assertions.assertEquals((double)commentsQuantity/(double)postsQuantity, forumMock.getAvgCommentPerPost());
    }

    @Test
    @DisplayName("Users = 100")
    void testCalculateAdvStatisticsUsers100() {
        //Given
        int usersQuantity = 100;
        int postsQuantity = 70;
        int commentsQuantity = 70;

        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsers(usersQuantity));
        when(statisticsMock.postsCount()).thenReturn(postsQuantity);
        when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);

        //When
        forumMock.calculateAdvStatistics(statisticsMock);
        forumMock.showStatistics();

        //Then
        Assertions.assertEquals((double)postsQuantity/(double)usersQuantity, forumMock.getAvgPostPerUser());
        Assertions.assertEquals((double)commentsQuantity/(double)usersQuantity, forumMock.getAvgCommentPerUser());
        Assertions.assertEquals((double)commentsQuantity/(double)postsQuantity, forumMock.getAvgCommentPerPost());
    }

}
