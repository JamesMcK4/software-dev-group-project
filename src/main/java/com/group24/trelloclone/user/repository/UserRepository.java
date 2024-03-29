package com.group24.trelloclone.user.repository;

import com.group24.trelloclone.user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserModel, Long>
{
    public Optional<UserModel> findByEmailId(String email);
}
