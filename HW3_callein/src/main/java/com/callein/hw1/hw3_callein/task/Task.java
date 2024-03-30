package com.callein.hw1.hw3_callein.task;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    private Integer taskId;
    private String taskTitle;
    private String taskDetail;
    private Date taskDue;
}
