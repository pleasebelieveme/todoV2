package org.example.todov2.domain.todo.dto.request;

import lombok.Getter;

@Getter
public class UpdateTodoRequestDto {

	private String title;
	private String contents;

	public UpdateTodoRequestDto(String title, String contents) {
		this.title = title;
		this.contents = contents;
	}
}
