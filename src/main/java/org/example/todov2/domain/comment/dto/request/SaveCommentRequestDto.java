package org.example.todov2.domain.comment.dto.request;

import org.example.todov2.domain.comment.entity.Comment;
import org.example.todov2.domain.member.entity.Member;
import org.example.todov2.domain.todo.entity.Todo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class SaveCommentRequestDto {

	private final String contents;
	private final Long memberId;
	private final Long todoId;

	public Comment toEntity(Member member, Todo todo) {
		return Comment.builder()
			.contents(contents)
			.member(member)
			.todo(todo)
			.build();
	}
}
