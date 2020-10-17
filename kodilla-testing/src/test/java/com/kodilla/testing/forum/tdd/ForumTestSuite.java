package com.kodilla.testing.forum.tdd;

//import com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumUser;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumComment;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

@DisplayName("TDD: Forum Test Suite")
class ForumTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    //@Nested
    //@DisplayName("POST TESTS")
    //class TestsPosts {
        @DisplayName("1-testAddPost")
        @Test
        void testAddPost() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");

            //When
            forumUser.addPost("mrsmith",
                    "Hello everyone, this is my first contribution here!");

            //Then
            Assertions.assertEquals(1, forumUser.getPostsQuantity());
        }

        @DisplayName("3-testGetPost")
        @Test
        void testGetPost() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

            //When
            ForumPost retrievedPost;
            retrievedPost = forumUser.getPost(0);

            //Then
            Assertions.assertEquals(thePost, retrievedPost);
        }

        @DisplayName("7-testRemovePost")
        @Test
        void testRemovePost() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

            //When
            boolean result = forumUser.removePost(thePost);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getPostsQuantity());
        }

        @DisplayName("8-testRemovePostNotExisting")
        @Test
        void testRemoveComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            ForumComment theComment = new ForumComment(thePost, "mrsmith",
                    "Thank you for all good words!");
            forumUser.addComment(thePost, theComment.getAuthor(),
                    theComment.getCommentBody());

            //When
            boolean result = forumUser.removeComment(theComment);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getCommentsQuantity());
        }

    //}

    //@Nested
    //@DisplayName("COMMENT TESTS")
    //class TestsComment {
        @DisplayName("4-testGetComment")
        @Test
        void testGetComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            ForumComment theComment = new ForumComment(thePost, "mrsmith",
                    "Thank you for all good words!");
            forumUser.addComment(thePost, theComment.getAuthor(),
                    theComment.getCommentBody());

            //When
            ForumComment retrievedComment = forumUser.getComment(0);

            //Then
            Assertions.assertEquals(theComment, retrievedComment);
        }


        @DisplayName("2-testAddComment")
        @Test
        void testAddComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");

            //When
            forumUser.addComment(thePost, "mrsmith", "Thank you for all good words!");

            //Then
            Assertions.assertEquals(1, forumUser.getCommentsQuantity());
        }


        @DisplayName("6-testRemoveCommentNotExisting")
        @Test
        void testRemoveCommentNotExisting() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            ForumComment theComment = new ForumComment(thePost, "mrsmith",
                    "Thank you for all good words!");

            //When
            boolean result = forumUser.removeComment(theComment);

            //Then
            Assertions.assertFalse(result);
        }

    //}


}