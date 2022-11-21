package com.example.todo_backend.repository;

import com.example.todo_backend.entity.Task;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskMapper implements RowMapper<Task> {
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException{
        Task task = new Task();
        task.setSerialNo(rs.getLong("serialNo"));
        task.setTaskName(rs.getString("taskName"));
        task.setDate(rs.getString("taskDate"));
        task.setShift(rs.getString("taskShift"));
        task.setTime(rs.getInt("neededTime"));
        task.setProgress(rs.getString("taskProgress"));

        return task;
    }


}
