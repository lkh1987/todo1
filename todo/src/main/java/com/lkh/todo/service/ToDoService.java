package  com.lkh.todo.service;


import com.lkh.todo.entity.ToDo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ToDoService {

    //데이터 삽입
    //ToDo 대신에 DTO로 설정해도됨. 주의할 점은 ToDo를 받을거라면, 수정할 수 없도록 final로 설정해야함
    public List<ToDo> create(final ToDo toDo);

    //UserId를 이용한 조회
    public List<ToDo> retrieve(final String userId);

    //데이터 수정
    public  List<ToDo> update(final ToDo toDo);

    //데이터 삭제
    public  List<ToDo> delete(final ToDo toDo);

}
