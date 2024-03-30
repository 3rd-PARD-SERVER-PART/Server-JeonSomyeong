package com.callein.hw1.hw3_callein.task.repository;

import com.callein.hw1.hw3_callein.task.Task;
import com.callein.hw1.hw3_callein.task.dto.TaskDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

@Repository
public class TaskRepository {
    private static final Map<Integer, Task> TASK_MAP = new HashMap<>();

//    CREATE
    public void save(TaskDto taskDto){
        Task t = Task.builder()
                .taskId(taskDto.getTaskId())
                .taskTitle(taskDto.getTaskTitle())
                .taskDetail(taskDto.getTaskDetail())
                .taskDue(taskDto.getTaskDue())
                .build();
        TASK_MAP.put(taskDto.getTaskId(), t);
    }

//    READ
    public TaskDto findById(Integer taskId){
        Task task = TASK_MAP.get(taskId);
        return TaskDto.builder()
                .taskId(task.getTaskId())
                .taskTitle(task.getTaskTitle())
                .taskDetail(task.getTaskDetail())
                .taskDue(task.getTaskDue())
                .build();
    }

//    UPDATE
    public void update(Integer taskId, TaskDto taskDto){
        Task task = TASK_MAP.get(taskId);
        task.setTaskId(taskDto.getTaskId());
        task.setTaskTitle(taskDto.getTaskTitle());
        task.setTaskDetail(taskDto.getTaskDetail());
        task.setTaskDue(taskDto.getTaskDue());
    }

//    DELETE
    public void delete(Integer taskId){TASK_MAP.remove(taskId);}
}
