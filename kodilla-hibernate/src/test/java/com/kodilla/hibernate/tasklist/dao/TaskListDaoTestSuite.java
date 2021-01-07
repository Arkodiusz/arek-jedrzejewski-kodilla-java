package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;
    private static final String NAME1 = "Task List 1";
    private static final String NAME2 = "Task List 2";

    @Test
    void testFindByListName() {
        //Given
        TaskList taskList1 = new TaskList(NAME1, "abcde");
        TaskList taskList2 = new TaskList(NAME2);
        taskListDao.save(taskList1);
        taskListDao.save(taskList2);

        //When
        List<TaskList> readTasks = new ArrayList<>();
        readTasks.addAll(taskListDao.findByListName(NAME1));
        readTasks.addAll(taskListDao.findByListName(NAME2));

        //Then
        assertEquals(2, readTasks.size());

        //CleanUp
        int id = readTasks.get(0).getId();
        taskListDao.deleteById(id);
    }
}
