package com.callein.hw2_callein.task.controller;

import com.callein.hw2_callein.task.dto.TaskDto;
import com.callein.hw2_callein.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @PostMapping("")
    public void saveTask(@RequestBody TaskDto taskDto){
        taskService.saveTask(taskDto);
    }

    @GetMapping("/{taskId}")
    public TaskDto findById(@PathVariable Integer taskId){
        return taskService.findById(taskId);
    }

    @GetMapping("")
    public List<TaskDto> findAll(){
        return taskService.findAll();
    }

    @PatchMapping("/{taskId}")
    public void update(@PathVariable Integer taskId, @RequestBody TaskDto taskDto){
        taskService.update(taskId, taskDto);
    }

    @DeleteMapping("/{taskId}")
    public void delete(@PathVariable Integer taskId){
        taskService.delete(taskId);
    }
}
