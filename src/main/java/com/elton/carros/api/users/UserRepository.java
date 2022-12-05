package com.elton.carros.api.users;

import com.elton.carros.api.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


    User findUserByLogin(String login);

}
