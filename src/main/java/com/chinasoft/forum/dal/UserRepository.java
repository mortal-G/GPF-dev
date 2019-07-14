package com.chinasoft.forum.dal;

import com.chinasoft.forum.dal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

    User findByUserEmailAndUserPassword(String email,String password);

}
