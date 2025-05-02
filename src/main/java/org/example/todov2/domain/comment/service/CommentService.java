package org.example.todov2.domain.comment.service;

import org.example.todov2.domain.comment.dto.request.SaveCommentRequestDto;
import org.example.todov2.domain.comment.dto.request.UpdateCommentRequestDto;
import org.example.todov2.domain.comment.dto.response.CommentResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
	CommentResponseDto saveComment(SaveCommentRequestDto dto, Long todosId);
	void updateComment(UpdateCommentRequestDto dto, Long commentId);
}
