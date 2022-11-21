package com.example.todo_backend.repository;


import com.example.todo_backend.entity.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
//    private TaskMapper taskMapper;
//    public TaskRepository(TaskMapper taskMapper) {
//        this.taskMapper = taskMapper;
//    }



    public boolean addTask(Task task){
     int i= jdbcTemplate.update(
             "INSERT INTO taskTable(serialNo, taskName, taskDate, taskShift, neededTime, taskProgress) values(?,?,?,?,?,?)",
             task.getSerialNo(), task.getTaskName(), task.getDate(), task.getShift(), task.getTime(), task.getProgress()
     );
     boolean success;
     success= i == 1;
     return success;
    };

    public boolean deleteSingleTask(Long serialNo){
        int i= jdbcTemplate.update("DELETE FROM taskTable WHERE serialNo=? ", serialNo);
        boolean success;
        success=i==1;
        return success;
    }


//    public Task getSingleTask(Long serialNo) {
//
//        String SQL = "select * from Student where serialNo = ?";
//        Task task = jdbcTemplateObject.queryForObject(
//                SQL, new Object[]{id}, new StudentMapper()
//        );
//        return student;
//    }
//    public boolean updateTask(Task task){
//        int i= jdbcTemplate.update(
//                "INSERT INTO taskTable(serialNo, taskName, taskDate, taskShift, neededTime, taskProgress) values(?,?,?,?,?,?)",
//                task.getSerialNo(), task.getTaskName(), task.getDate(), task.getShift(), task.getTime(), task.getProgress()
//        );
//        boolean success;
//        success= i == 1;
//        return success;
//    };

    public Task getSingleTask(Long serialNo){

        Task task = new Task();
        String sql = "select * from taskTable where serialNo = ?";
        task =jdbcTemplate.queryForObject(sql, new TaskMapper(),serialNo);
        return task;
    }


    public boolean updateSingleTask(Task update_task,Long serialNo){
        Task task = new Task();
        boolean find_success, success;
        String find_query = "select * from taskTable where serialNo = ?";

        try{
            task = jdbcTemplate.queryForObject(find_query, new TaskMapper(), serialNo);
            find_success=true;
        }
        catch (Exception e) {

            find_success=false;
        }
        if(find_success){
            jdbcTemplate.update("update taskTable set taskName=? where serialNo=?", update_task.getTaskName(),serialNo);
            return success=true;
        }else{
            return success=false;
        }
    }

}
