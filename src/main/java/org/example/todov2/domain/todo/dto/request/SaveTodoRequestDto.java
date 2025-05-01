package org.example.todov2.domain.todo.dto.request;

import org.example.todov2.domain.todo.entity.Todo;

import lombok.Getter;

@Getter
public class SaveTodoRequestDto {
	private String title;
	private String contents;
	private String name;

	public SaveTodoRequestDto(String title, String contents, String name) {
		this.title = title;
		this.contents = contents;
		this.name = name;
	}
	// public static TodoResponseDto toDto(Todo todo) {
	// 	return new TodoResponseDto(todo.getId(), todo.getTitle(), todo.getContents(), todo.getMember());
	// }
}
