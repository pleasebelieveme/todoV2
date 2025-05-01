package org.example.todov2.domain.todo.repository;

import org.example.todov2.domain.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

	default Todo findTodoByIdOrElseThrow(Long todoId) {
		return findById(todoId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + todoId));
	}
}
