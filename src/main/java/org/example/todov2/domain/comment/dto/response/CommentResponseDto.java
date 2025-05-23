package org.example.todov2.domain.comment.dto.response;

import org.example.todov2.domain.comment.entity.Comment;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentResponseDto {
	private final Long id;
	private final String contents;

	public CommentResponseDto(Long id, String contents) {
		this.id = id;
		this.contents = contents;
	}

	public static CommentResponseDto toDto(Comment comment) {

		return CommentResponseDto.builder()
			.id(comment.getId())
			.contents(comment.getContents())
			.build();
	}
}
