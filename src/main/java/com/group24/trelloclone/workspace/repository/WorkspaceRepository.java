package com.group24.trelloclone.workspace.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group24.trelloclone.workspace.model.WorkspaceModel;

@Repository
@Transactional
public interface WorkspaceRepository extends JpaRepository<WorkspaceModel, Long>
{   
}
