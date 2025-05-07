package org.example.todov2.domain.comment.service;

import java.util.List;
import java.util.stream.Collectors;

import org.example.todov2.domain.comment.dto.request.UpdateCommentRequestDto;
import org.example.todov2.domain.comment.entity.Comment;
import org.example.todov2.domain.member.entity.Member;
import org.example.todov2.domain.member.repository.MemberRepository;
import org.example.todov2.domain.comment.dto.request.SaveCommentRequestDto;
import org.example.todov2.domain.comment.dto.response.CommentResponseDto;
import org.example.todov2.domain.comment.repository.CommentRepository;
import org.example.todov2.domain.todo.entity.Todo;
import org.example.todov2.domain.todo.repository.TodoRepository;
import org.springframework.data.convert.DtoInstantiatingConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

	private final MemberRepository memberRepository;
	private final TodoRepository todoRepository;
	private final CommentRepository commentRepository;

	@Override
	public CommentResponseDto saveComment(SaveCommentRequestDto dto, Long todosId) {
		Todo findTodo = todoRepository.findTodoByIdOrElseThrow(todosId);
		Member findMember = memberRepository.findMemberByIdOrElseThrow(findTodo.getMember().getId());

		Comment comment = new Comment(dto.getContents(), findMember, findTodo);
		Comment saved = commentRepository.save(comment);
		return CommentResponseDto.toDto(saved);
	}

	@Override
	public List<CommentResponseDto> findAllComment() {
		List<Comment> findCommentList = commentRepository.findAll();
		return findCommentList.stream().map(CommentResponseDto::toDto).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void updateComment(UpdateCommentRequestDto dto, Long commentId) {
		Comment findComment = commentRepository.findCommentByIdOrElseThrow(commentId);
		Todo findTodo = todoRepository.findTodoByIdOrElseThrow(findComment.getTodo().getId());
		Member findMember = memberRepository.findMemberByIdOrElseThrow(findComment.getMember().getId());

		findComment.updateComment(dto.getContents());
	}

	@Override
	public void deleteComment(Long commentId) {
		Comment findComment = commentRepository.findCommentByIdOrElseThrow(commentId);
		Todo findTodo = todoRepository.findTodoByIdOrElseThrow(findComment.getTodo().getId());
		Member findMember = memberRepository.findMemberByIdOrElseThrow(findComment.getMember().getId());

		commentRepository.delete(findComment);
	}
}
