package org.example.todov2.domain.comment.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.example.todov2.domain.comment.entity.Comment;
import org.example.todov2.domain.member.dto.response.MemberResponseDto;
import org.example.todov2.domain.member.entity.Member;
import org.example.todov2.domain.todo.dto.response.TodoResponseDto;
import org.example.todov2.domain.todo.entity.Todo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentResponseDto {
	private final Long id;
	private final String contents;
	private final MemberResponseDto member;
	private final TodoResponseDto todo;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;

	public CommentResponseDto(Long id, String contents, MemberResponseDto member, TodoResponseDto todo) {
		this.id = id;
		this.contents = contents;
		this.member = member;
		this.todo = todo;
	}

	public CommentResponseDto(Long id, String contents, MemberResponseDto member, TodoResponseDto todo, LocalDateTime createdAt, LocalDateTime modifiedAt) {
		this.id = id;
		this.contents = contents;
		this.member = member;
		this.todo = todo;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}

	public static CommentResponseDto toDto(Comment comment) {

		return CommentResponseDto.builder()
			.id(comment.getId())
			.contents(comment.getContents())
			.member(MemberResponseDto.toDto(comment.getMember()))
			.todo(TodoResponseDto.toDto(comment.getTodo()))
			.build();
	}
}
