package org.example.todov2.domain.todo.entity;

import java.util.ArrayList;
import java.util.List;

import org.example.todov2.common.BaseEntity;
import org.example.todov2.domain.comment.entity.Comment;
import org.example.todov2.domain.member.dto.response.MemberResponseDto;
import org.example.todov2.domain.member.entity.Member;
import org.example.todov2.domain.todo.dto.response.TodoResponseDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "todo")
public class Todo extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(columnDefinition = "longtext")
	private String contents;

	private int count;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	// 한개의 일정은 여러 리뷰 작성
	@OneToMany(mappedBy = "todo", cascade = CascadeType.ALL)
	private List<Comment> comments = new ArrayList<>();

	public Todo(String title, String contents, Member member) {
		this.title = title;
		this.contents = contents;
		this.member = member;
	}

	public TodoResponseDto toDto() {
		return new TodoResponseDto(
			this.id,
			this.title,
			this.contents,
			new MemberResponseDto(
				this.member.getId(),
				this.member.getName(),
				this.member.getEmail()
		));
	}

	public void update(String title, String contents) {
		this.title = title;
		this.contents = contents;
	}
}