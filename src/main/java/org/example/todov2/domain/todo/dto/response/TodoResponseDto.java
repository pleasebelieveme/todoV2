package org.example.todov2.domain.todo.dto.response;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.example.todov2.domain.comment.dto.response.CommentResponseDto;
import org.example.todov2.domain.member.dto.response.MemberResponseDto;
import org.example.todov2.domain.todo.entity.Todo;

import lombok.Getter;

@Getter
public class TodoResponseDto {
	private final Long id;
	private final String title;
	private final String contents;
	private MemberResponseDto member;
	private List<CommentResponseDto> comments;

	public TodoResponseDto(Long id, String title, String contents, MemberResponseDto member, List<CommentResponseDto> comments) {
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.member = member;
		this.comments = comments;
	}


	public static TodoResponseDto toDto(Todo todo) {
		return new TodoResponseDto(
			todo.getId(),
			todo.getTitle(),
			todo.getContents(),
			MemberResponseDto.toDto(todo.getMember()),
			todo.getComments().stream()
				.map(CommentResponseDto::toDto)
				.collect(Collectors.toList())
		);
	}
}
