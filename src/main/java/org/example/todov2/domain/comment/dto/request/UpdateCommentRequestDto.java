package org.example.todov2.domain.comment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateCommentRequestDto {

	private final String contents;

}
