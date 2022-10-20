package com.lkh.todo;

import com.lkh.todo.entity.ToDo;
import com.lkh.todo.persistence.ToDoRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import service.ToDoService;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ToDoTest {

    @Autowired
    private ToDoRepository toDoRepository;

    //@Test
    public void insertTest(){
        ToDo toDo = ToDo.builder()
                .userId("jeeyu")
                .title("서점 가기")
                .build();
        toDoRepository.save(toDo);

        ToDo toDo2 = ToDo.builder()
                .userId("jeeyu")
                .title("삼척 여행")
                .build();

        toDoRepository.save(toDo2);
    }

    //@Test
    public void testSelect(){
        List<ToDo> list = toDoRepository.findByUserId("jeeyu");
        for(ToDo toDo : list) {
            System.out.println(toDo);
        }
    }

    // @Test
    //@Disabled
    public void testFindUserId(){
        List<ToDo> list = toDoRepository.findByUserId("jeeyu");

        list.stream().forEach(toDo -> {
            System.out.println(toDo);
        });
    }

    //id에 해당하는 하나의 데이터 조회
    //@Test
    public void testDetail(){
        Optional<ToDo> result = toDoRepository.findById("4028e45683f3886f0183f38878ae0000");

        if(result.isPresent()){
            System.out.println(result.get());
        }else{
            System.out.println("데이터가 존재하지 않아요.");
        }
    }

    //데이터 수정
    //@Test
    //@Disabled
    public void testUpdate(){
        ToDo toDo = ToDo.builder()
                .id("4028e45683f3886f0183f38878ae0000")
                .userId("jeeyulee")
                .title("오목교 교보문고 가기")
                .done(true)
                .build();

        toDoRepository.save(toDo);
    }

    //@Test
    public void testDelete(){
        toDoRepository.deleteById("4028e45683f3886f0183f38878ae0000");
    }

    @Autowired
    private ToDoService toDoService;

    //@Test
    //@Disabled
    public void testServiceInsert(){
        ToDo toDo = ToDo.builder()
                .userId("adam")
                .title("service test")
                .done(false)
                .build();

        List<ToDo> list = toDoService.create(toDo);
        System.out.println(list);
    }

    //@Test
    public void testServiceRetrieve(){
        ToDo toDo = ToDo.builder()
                .userId("adam")
                .title("service test")
                .done(false)
                .build();

        List<ToDo> list = toDoService.retrieve(toDo.getUserId());
        System.out.println(list);
    }

    //@Test
    public void testServiceUpdate(){
        ToDo toDo = ToDo.builder()
                .id("4028e45683f3886f0183f38878fe0001")
                .userId("adams")
                .title("수정")
                .done(true)
                .build();

        List<ToDo> list = toDoService.update(toDo);
        System.out.println(list);
    }


    @Test
    public void testServiceDelete(){
        ToDo toDo = ToDo.builder()
                .id("4028e45683f3886f0183f38878fe0001")
                .userId("adams")
                .build();

        List<ToDo> list = toDoService.delete(toDo);
    }

}