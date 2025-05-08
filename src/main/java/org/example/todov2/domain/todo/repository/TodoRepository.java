package org.example.todov2.domain.todo.repository;

import java.util.List;

import org.example.todov2.domain.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

	default Todo findTodoByIdOrElseThrow(Long todoId) {
		return findById(todoId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + todoId));
	}

	@Query("SELECT DISTINCT t FROM Todo t LEFT JOIN FETCH t.comments c ORDER BY t.id, c.createdAt ASC")
	List<Todo> findAllWithCommentsOrderByCommentCreatedAt();
}
