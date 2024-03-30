package com.callein.hw2_callein.task.service;

import com.callein.hw2_callein.task.dto.TaskDto;
import com.callein.hw2_callein.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public void saveTask(TaskDto taskDto){taskRepository.save(taskDto);}

    public TaskDto findById(Integer taskId){return taskRepository.findById(taskId);}

    public List<TaskDto> findAll(){return taskRepository.findAll();}

    public void update(Integer taskId, TaskDto taskDto){taskRepository.update(taskId,taskDto);}

    public void delete(Integer taskId){taskRepository.delete(taskId);}
}
