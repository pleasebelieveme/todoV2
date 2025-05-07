package org.example.todov2.domain.reply.dto.request;

import org.example.todov2.domain.comment.entity.Comment;
import org.example.todov2.domain.member.entity.Member;
import org.example.todov2.domain.reply.entity.Reply;
import org.example.todov2.domain.todo.entity.Todo;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
public class SaveReplyRequestDto {

	private final String contents;
	private final Long memberId;
	private final Long todoId;
	private final Long commentId;

	public Reply toEntity(Member member, Todo todo, Comment comment) {
		return Reply.builder()
			.contents(contents)
			.member(member)
			.todo(todo)
			.comment(comment)
			.build();
	}
}
