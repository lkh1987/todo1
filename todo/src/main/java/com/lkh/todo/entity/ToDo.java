package com.lkh.todo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="todo")
public class ToDo extends BaseEntity {
    //랜덤한 UUID를 가지고 ID값을 생성
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;          //기본키로 사용할 ID

    @Column(length = 100, nullable = false)
    private String userId;      //사용자 식별 ID

    @Column(length = 500, nullable = false)
    private String title;       //제목

    @Column(nullable = false)
    private boolean done;       //수행여부


}
