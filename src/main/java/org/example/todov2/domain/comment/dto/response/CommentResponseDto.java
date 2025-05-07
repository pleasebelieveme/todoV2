package org.example.todov2.domain.comment.dto.response;

import java.time.LocalDateTime;

import org.example.todov2.domain.comment.entity.Comment;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentResponseDto {
	private final Long id;
	private final String contents;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;

	public CommentResponseDto(Long id, String contents, Object o) {
		this.id = id;
		this.contents = contents;
	}

	public CommentResponseDto(Long id, String contents, LocalDateTime createdAt, LocalDateTime modifiedAt) {
		this.id = id;
		this.contents = contents;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}

	public static CommentResponseDto toDto(Comment comment) {

		return CommentResponseDto.builder()
			.id(comment.getId())
			.contents(comment.getContents())
			.build();
	}
}
