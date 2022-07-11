package com.dimas4ek.YoMaYo.repos;

import com.dimas4ek.YoMaYo.domain.UserInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<UserInfo, Integer> {

    List<UserInfo> findByName(String name);
}
