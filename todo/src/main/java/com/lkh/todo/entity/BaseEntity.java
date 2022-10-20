package com.lkh.todo.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass   //Entity를 별도로 생성하지 않는 클래스
@EntityListeners(value = {AuditingEntityListener.class})    //JPA를 감시하고 있다가 동작하도록 설정
@Getter
public abstract class BaseEntity {
    @CreatedDate
    @Column(name="regdate", updatable = false)
    private LocalDateTime regDate;


    @LastModifiedDate
    @Column(name="moddate", updatable = false)
    private LocalDateTime modDate;
}
