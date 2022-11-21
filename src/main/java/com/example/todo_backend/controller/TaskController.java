package com.example.todo_backend.controller;

import com.example.todo_backend.entity.Task;
import com.example.todo_backend.repository.TaskRepository;
import com.example.todo_backend.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TaskController {

    private final TaskService taskService;
    private final TaskRepository taskRepository ;

    public TaskController(TaskService taskService, TaskRepository taskRepository) {
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }


    @PostMapping("/single_task")
    public Task getTask(@RequestBody Task task){
        return taskService.getTask(task);
    }

    @PostMapping("/all_task")
    public List<Task> getTasks(@RequestBody List<Task> tasks ){
        return taskService.getTaskList(tasks);
    }
    @GetMapping("/task_list")
    public List<Task> getTaskList(){
        return taskService.getAllTask();
    }
    @PostMapping("/save_single_task")
    public boolean saveTask(@RequestBody Task task){
        return taskRepository.addTask(task);
    }
    @PostMapping("/save_all_task")
    public int saveAllTask(@RequestBody List<Task> tasks){
        int count=0;
        boolean result;
        for(Task task: tasks){
            result=taskRepository.addTask(task);
            if(result)count++;

        }
        return count;
    }

    @DeleteMapping("/delete_single_task/{serialNo}")
    public boolean deleteTask(@PathVariable("serialNo") Long serialNo){
        return taskRepository.deleteSingleTask(serialNo);
    }

    @GetMapping("/get_single_task/{serialNo}")
    public Task getSingleTask(@PathVariable("serialNo") Long serialNo){
        return taskRepository.getSingleTask(serialNo);
    }
    @PutMapping("/update_single_task/{serialNo}")
    public boolean updateTask(@RequestBody Task task, @PathVariable("serialNo") Long serialNo){
        return taskRepository.updateSingleTask(task, serialNo);
    }


}
