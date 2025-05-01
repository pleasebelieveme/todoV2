package org.example.todov2.domain.todo.entity;

import org.example.todov2.common.BaseEntity;
import org.example.todov2.domain.member.entity.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "todo")
public class Todo extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(columnDefinition = "longtext")
	private String contents;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;

	public Todo () {}

	public Todo(String title, String contents, Member member) {
		this.title = title;
		this.contents = contents;
		this.member = member;
	}

	// public TodoResponseDto toDto() {
	// 	return new TodoResponseDto(this.id, this.title, this.contents, this.member);
	// }
	//
	// public void update(String title, String contents) {
	// 	this.title = title;
	// 	this.contents = contents;
	// }
	//
	public void setMember(Member member) {
		this.member = member;
	}

	public void update(String title, String contents) {
		this.title = title;
		this.contents = contents;
	}
}