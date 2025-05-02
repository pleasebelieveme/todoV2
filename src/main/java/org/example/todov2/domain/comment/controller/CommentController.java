package org.example.todov2.domain.comment.controller;

import org.example.todov2.domain.comment.dto.request.SaveCommentRequestDto;
import org.example.todov2.domain.comment.dto.response.CommentResponseDto;
import org.example.todov2.domain.comment.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;

	@PostMapping("/todos/{todosId}/{memberId}/comments")
	public ResponseEntity<CommentResponseDto> saveComment(@RequestBody SaveCommentRequestDto dto, @PathVariable Long todosId, @PathVariable Long memberId) {
		CommentResponseDto responseDto = commentService.saveComment(dto, memberId, todosId);
		return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
	}
}
