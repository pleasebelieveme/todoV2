package org.example.todov2.domain.todo.service;

import org.example.todov2.domain.member.dto.request.SaveMemberRequestDto;
import org.example.todov2.domain.member.entity.Member;
import org.example.todov2.domain.member.repository.MemberRepository;
import org.example.todov2.domain.todo.dto.request.SaveTodoRequestDto;
import org.example.todov2.domain.todo.dto.response.TodoResponseDto;
import org.example.todov2.domain.todo.entity.Todo;
import org.example.todov2.domain.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

	private final TodoRepository todoRepository;
	private final MemberRepository memberRepository;

	@Override
	public TodoResponseDto save(SaveTodoRequestDto dto, Member member) {
		Member findMember = memberRepository.findMemberByIdOrElseThrow(member.getId());
		Todo todo = new Todo(dto.getTitle(), dto.getContents(), member);
		todo.setMember(findMember);
		Todo savedTodo = todoRepository.save(todo);
		return new TodoResponseDto(savedTodo.getId(), savedTodo.getTitle(), savedTodo.getContents(), savedTodo.getMember());
	}

	@Override
	@Transactional
	public void updateTodo(Long memberId, String title, String contents) {
		Todo findTodo = todoRepository.findTodoByIdOrElseThrow(memberId);
		findTodo.update(title, contents);
	}
}
