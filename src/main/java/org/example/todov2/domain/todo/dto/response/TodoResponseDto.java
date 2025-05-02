package org.example.todov2.domain.todo.dto.response;


import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.example.todov2.domain.member.dto.response.MemberResponseDto;
import org.example.todov2.domain.member.entity.Member;
import org.example.todov2.domain.todo.entity.Todo;

import lombok.Getter;

@Getter
public class TodoResponseDto {
	private final Long id;
	private final String title;
	private final String contents;
	private MemberResponseDto member;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;

	public TodoResponseDto(Long id, String title, String contents, MemberResponseDto member) {
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.member = member;
	}

	public TodoResponseDto(Long id, String title, String contents, MemberResponseDto member, LocalDateTime createdAt, LocalDateTime modifiedAt) {
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.member = member;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}

	public static TodoResponseDto toDto(Todo todo) {
		return new TodoResponseDto(
			todo.getId(),
			todo.getTitle(),
			todo.getContents(),
			new MemberResponseDto(
				todo.getMember().getId(),
				todo.getMember().getName(),
				todo.getMember().getEmail()
			),
			todo.getCreatedAt(),
			todo.getModifiedAt()
		);
	}
}
