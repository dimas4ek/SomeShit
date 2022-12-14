package com.dimas4ek.SomeShit.repos;

import com.dimas4ek.SomeShit.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {
    List<Message> findByAuthorName(String username);

}
