package com.ETW.DAO;

import com.ETW.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findByUsername(String username);

    UserEntity findByUsernameAndPassword(String username, String password);
}
