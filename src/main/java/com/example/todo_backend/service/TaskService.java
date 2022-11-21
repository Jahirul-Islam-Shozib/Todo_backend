package com.example.todo_backend.service;


import com.example.todo_backend.entity.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    public Task getTask(Task task){
        Task returnTask= new Task();
        returnTask.setSerialNo(task.getSerialNo());
        returnTask.setTaskName(task.getTaskName());
        returnTask.setDate(task.getDate());
        returnTask.setShift(task.getShift());
        returnTask.setTime(task.getTime());
        returnTask.setProgress(task.getProgress());

        return returnTask;
    }


    public List<Task> getAllTask(){
        List<Task> taskList=new ArrayList<>();
        Task task1=new Task();
        task1.setSerialNo(1);
        task1.setTaskName("watch a movie");
        task1.setDate("2022-11-11");
        task1.setShift("morning");
        task1.setTime(3);
        task1.setProgress("pending");
        taskList.add(task1);

        Task task2=new Task();
        task2.setSerialNo(1);
        task2.setTaskName("watch a series");
        task2.setDate("2022-11-11");
        task2.setShift("morning");
        task2.setTime(3);
        task2.setProgress("pending");
        taskList.add(task2);

        return taskList;

    }



    public List<Task> getTaskList(List<Task> tasks){

        List<Task> returnAllTask= new ArrayList<>();

        returnAllTask=tasks;
        return returnAllTask;
    }

}
