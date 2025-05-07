package org.example.todov2.domain.todo.controller;

import java.util.List;

import org.example.todov2.domain.member.entity.Member;
import org.example.todov2.domain.member.repository.MemberRepository;
import org.example.todov2.domain.todo.dto.request.SaveTodoRequestDto;
import org.example.todov2.domain.todo.dto.request.UpdateTodoRequestDto;
import org.example.todov2.domain.todo.dto.response.TodoListResponseDto;
import org.example.todov2.domain.todo.dto.response.TodoResponseDto;
import org.example.todov2.domain.todo.repository.TodoRepository;
import org.example.todov2.domain.todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {

	private final TodoService todoService;
	private final MemberRepository memberRepository;
	private final TodoRepository todoRepository;

	@PostMapping("/{memberId}")
	public ResponseEntity<TodoResponseDto> saveTodo(@PathVariable Long memberId, @RequestBody SaveTodoRequestDto dto) {
		Member member = memberRepository.findMemberByIdOrElseThrow(memberId);
		TodoResponseDto TodoResponseDto = todoService.save(dto, member);
		return new ResponseEntity<>(TodoResponseDto, HttpStatus.CREATED);
	}

	@GetMapping
	public TodoListResponseDto findAll() {
		List<TodoResponseDto> findAllTodo = todoService.findAllTodos();
		return new TodoListResponseDto(findAllTodo);
	}

	@GetMapping("/{todoId}")
	public ResponseEntity<TodoResponseDto> findTodoById(@PathVariable Long todoId) {
		return new ResponseEntity<>(todoService.findTodoById(todoId), HttpStatus.OK);
	}

	@PatchMapping("/{memberId}")
	public ResponseEntity<Void> updateTodo(@PathVariable Long memberId, @RequestBody UpdateTodoRequestDto dto) {
		todoService.updateTodo(memberId, dto.getTitle(), dto.getContents());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{todoId}")
	public ResponseEntity<Void> delete(@PathVariable Long todoId) {
		todoService.delete(todoId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
