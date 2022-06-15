package com.group24.trelloclone.user.repository;

import com.group24.trelloclone.user.model.UserModel;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserModel, Long>
{   
}
