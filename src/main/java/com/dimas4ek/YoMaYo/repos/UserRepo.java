package com.dimas4ek.YoMaYo.repos;

import com.dimas4ek.YoMaYo.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Integer> {

    List<User> findByName(String name);
}
