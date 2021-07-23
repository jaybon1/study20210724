package com.example.demo20210724.mybatis;

import com.example.demo20210724.entity.TodoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MyBatisTodoRepository {

    List<TodoEntity> findAll();

    List<TodoEntity> findAllByDoneYn(String doneYn);

    TodoEntity findByIdx(Integer idx);

    Integer insert(TodoEntity todoEntity);

    Integer update(TodoEntity todoEntity);

}
