package com.group24.trelloclone.task.repository;

import com.group24.trelloclone.task.model.TaskModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<TaskModel, String> {
    boolean existsByName(String name);
}
