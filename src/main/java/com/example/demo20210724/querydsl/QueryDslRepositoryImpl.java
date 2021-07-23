package com.example.demo20210724.querydsl;

import com.example.demo20210724.entity.TodoEntity;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.demo20210724.entity.QTodoEntity.todoEntity;

@Repository
@RequiredArgsConstructor
public class QueryDslRepositoryImpl implements QueryDslTodoCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<TodoEntity> findAllByDeleteYn(String doneYn) {
        JPAQuery<TodoEntity> query = jpaQueryFactory
                .select(todoEntity)
                .from(todoEntity)
                .where(todoEntity.deleteYn.eq(doneYn));
        return query.fetch();

    }

    @Override
    public TodoEntity findByIdxAndDeleteYn(Integer idx, String deleteYn) {
        JPAQuery<TodoEntity> query = jpaQueryFactory
                .select(todoEntity)
                .from(todoEntity)
                .where(todoEntity.idx.eq(idx).and(todoEntity.deleteYn.eq(deleteYn)));
        return query.fetchOne();
    }
}
