package com.lkh.todo.persistence;

import com.lkh.todo.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ToDoRepository extends JpaRepository<ToDo, String> {

    //userID를 가지고 조회하는 메소드
    public List<ToDo> findByUserId(String userId);
}
