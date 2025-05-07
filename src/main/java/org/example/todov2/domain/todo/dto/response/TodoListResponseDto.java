package org.example.todov2.domain.todo.dto.response;

import java.util.List;

import lombok.Getter;

@Getter
public class TodoListResponseDto {
	private final int count;
	private final List<TodoResponseDto> todos;

	public TodoListResponseDto(List<TodoResponseDto> todos) {
		this.count = todos.size();
		this.todos = todos;
	}
}

