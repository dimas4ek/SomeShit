package com.dimas4ek.YoMaYo.repos;

import com.dimas4ek.YoMaYo.domain.Message;
import com.dimas4ek.YoMaYo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {

    Message findById(String username);

}
