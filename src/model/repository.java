package model;

import com.example.todoapp.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    // 追加のクエリメソッドなどがあればここに追加
}