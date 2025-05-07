package org.example.todov2.domain.reply.dto.response;

import org.example.todov2.domain.comment.dto.response.CommentResponseDto;
import org.example.todov2.domain.comment.entity.Comment;
import org.example.todov2.domain.member.dto.response.MemberResponseDto;
import org.example.todov2.domain.reply.entity.Reply;
import org.example.todov2.domain.todo.dto.response.TodoResponseDto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReplyResponseDto {

	private final Long id;
	private final String contents;
	private final MemberResponseDto member;
	private final TodoResponseDto todo;
	private final CommentResponseDto comment;

	public static ReplyResponseDto toDto(Reply reply) {

		return ReplyResponseDto.builder()
			.id(reply.getId())
			.contents(reply.getContents())
			.member(MemberResponseDto.toDto(reply.getMember()))
			.todo(TodoResponseDto.toDto(reply.getTodo()))
			.comment(CommentResponseDto.toDto(reply.getComment()))
			.build();
	}
}
