package com.group24.trelloclone.task.repository;

import com.group24.trelloclone.task.model.TaskModel;
import com.group24.trelloclone.task.model.TaskStatusEnum;
import com.group24.trelloclone.user.model.UserModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<TaskModel, String> {
    boolean existsByName(String name);

    @Modifying
    @Query("UPDATE tasks set assignee = :user where id = :taskId")
    int assignTask(String taskId, UserModel user);

    int updateTaskStatus(String taskId, TaskStatusEnum status);
}
