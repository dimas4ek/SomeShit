package com.dimas4ek.SomeShit.repos;

import com.dimas4ek.SomeShit.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    public User findByUsername(String username);

    User findByActivationCode(String code);
}
