package org.example.todov2.domain.todo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.example.todov2.domain.member.dto.request.SaveMemberRequestDto;
import org.example.todov2.domain.member.dto.response.MemberResponseDto;
import org.example.todov2.domain.member.entity.Member;
import org.example.todov2.domain.member.repository.MemberRepository;
import org.example.todov2.domain.todo.dto.request.SaveTodoRequestDto;
import org.example.todov2.domain.todo.dto.response.TodoResponseDto;
import org.example.todov2.domain.todo.entity.Todo;
import org.example.todov2.domain.todo.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

	private final TodoRepository todoRepository;
	private final MemberRepository memberRepository;

	@Override
	public TodoResponseDto save(SaveTodoRequestDto dto, Member member) {
		Member findMember = memberRepository.findMemberByIdOrElseThrow(member.getId());
		Todo todo = new Todo(dto.getTitle(), dto.getContents(), findMember);
		Todo savedTodo = todoRepository.save(todo);
		return new TodoResponseDto(savedTodo.getId(),
			savedTodo.getTitle(),
			savedTodo.getContents(),
			new MemberResponseDto(
				savedTodo.getMember().getId(),
				savedTodo.getMember().getName(),
				savedTodo.getMember().getEmail()
			));
	}

	@Override
	public List<TodoResponseDto> findAllTodos() {
		List<Todo> todoList = todoRepository.findAll();
		return todoList.stream().map(Todo::toDto).collect(Collectors.toList());
	}

	@Override
	public TodoResponseDto findTodoById(Long todoId) {
		Todo findTodo = todoRepository.findTodoByIdOrElseThrow(todoId);
		return new TodoResponseDto(findTodo.getId(), findTodo.getTitle(), findTodo.getContents(), findTodo.toDto().getMember(), findTodo.getCreatedAt(), findTodo.getModifiedAt());
	}

	@Override
	@Transactional
	public void updateTodo(Long memberId, String title, String contents) {
		Todo findTodo = todoRepository.findTodoByIdOrElseThrow(memberId);
		findTodo.update(title, contents);
	}

	@Override
	public void delete(Long todoId) {
		Todo findTodo = todoRepository.findTodoByIdOrElseThrow(todoId);
		todoRepository.delete(findTodo);
	}
}
