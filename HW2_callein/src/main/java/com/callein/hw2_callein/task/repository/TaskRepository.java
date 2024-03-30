package com.callein.hw2_callein.task.repository;

import com.callein.hw2_callein.task.Task;
import com.callein.hw2_callein.task.dto.TaskDto;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TaskRepository {
    private static final Map<Integer, Task> TASK_MAP = new HashMap<>();

//    CREATE
    public void save(TaskDto taskDto){
        if(taskDto.getTaskId()==null){
            if(TASK_MAP.isEmpty()) taskDto.setTaskId(1);
            else {
                taskDto.setTaskId(Collections.max(TASK_MAP.keySet()) + 1);
            }
        }
        // id 존재하면 리턴. response 는 넣지않음.
        if(TASK_MAP.containsKey(taskDto.getTaskId())){
            System.out.println("Save rejected. Id exists.");
            return;
        }
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

    public List<TaskDto> findAll(){
        return TASK_MAP.values().stream()
                .map(task -> TaskDto.builder()
                        .taskId(task.getTaskId())
                        .taskTitle(task.getTaskTitle())
                        .taskDetail(task.getTaskDetail())
                        .taskDue(task.getTaskDue())
                        .build())
                .toList();
    }

//    UPDATE
    public void update(Integer taskId, TaskDto taskDto){
        Task task = TASK_MAP.get(taskId);
        if(taskDto.getTaskId()!=null) task.setTaskId(taskDto.getTaskId());
        task.setTaskTitle(taskDto.getTaskTitle());
        task.setTaskDetail(taskDto.getTaskDetail());
        task.setTaskDue(taskDto.getTaskDue());
    }

//    DELETE
    public void delete(Integer taskId){TASK_MAP.remove(taskId);}
}
