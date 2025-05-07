package org.example.todov2.domain.reply.service;

import java.util.List;
import java.util.stream.Collectors;

import org.example.todov2.domain.comment.dto.response.CommentResponseDto;
import org.example.todov2.domain.comment.entity.Comment;
import org.example.todov2.domain.comment.repository.CommentRepository;
import org.example.todov2.domain.member.entity.Member;
import org.example.todov2.domain.member.repository.MemberRepository;
import org.example.todov2.domain.reply.dto.request.SaveReplyRequestDto;
import org.example.todov2.domain.reply.dto.request.UpdateReplyRequestDto;
import org.example.todov2.domain.reply.dto.response.ReplyResponseDto;
import org.example.todov2.domain.reply.entity.Reply;
import org.example.todov2.domain.reply.repository.ReplyRepository;
import org.example.todov2.domain.todo.entity.Todo;
import org.example.todov2.domain.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

	private final CommentRepository commentRepository;
	private final TodoRepository todoRepository;
	private final MemberRepository memberRepository;
	private final ReplyRepository replyRepository;

	@Override
	public ReplyResponseDto saveReply(SaveReplyRequestDto dto, Long commentId) {
		Comment findComment = commentRepository.findCommentByIdOrElseThrow(commentId);
		Todo findTodo = todoRepository.findTodoByIdOrElseThrow(findComment.getTodo().getId());
		Member findMember = memberRepository.findMemberByIdOrElseThrow(findComment.getMember().getId());

		Reply reply = new Reply(dto.getContents(), findMember, findTodo, findComment);
		Reply saved = replyRepository.save(reply);
		return ReplyResponseDto.toDto(saved);
	}

	@Override
	public List<ReplyResponseDto> findAllReply() {
		List<Reply> findReplyList = replyRepository.findAll();
		return findReplyList.stream().map(ReplyResponseDto::toDto).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void updateReply(UpdateReplyRequestDto dto, Long replyId) {
		Reply findReply = replyRepository.findReplyByIdOrElseThrow(replyId);
		Comment findComment = commentRepository.findCommentByIdOrElseThrow(findReply.getComment().getId());
		Todo findTodo = todoRepository.findTodoByIdOrElseThrow(findReply.getTodo().getId());
		Member findMember = memberRepository.findMemberByIdOrElseThrow(findReply.getMember().getId());

		findReply.updateReply(dto.getContents());
	}

	@Override
	public void deleteReply(Long replyId) {
		Reply findReply = replyRepository.findReplyByIdOrElseThrow(replyId);

		replyRepository.delete(findReply);
	}
}
