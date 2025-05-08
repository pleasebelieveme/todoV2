package org.example.todov2.domain.comment.entity;

import java.util.ArrayList;
import java.util.List;

import org.example.todov2.common.BaseEntity;
import org.example.todov2.domain.comment.dto.response.CommentResponseDto;
import org.example.todov2.domain.reply.entity.Reply;
import org.example.todov2.domain.member.entity.Member;
import org.example.todov2.domain.todo.entity.Todo;

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
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "comment")
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA는 사용가능하지만, 외부에서 개발자가 직접 new로 못씀.
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Comment extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String contents;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "todo_id")
	private Todo todo;

	@OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
	private List<Reply> replies = new ArrayList<>();

	public Comment(String contents, Member member, Todo todo) {
		this.contents = contents;
		this.member = member;
		this.todo = todo;
	}

	public CommentResponseDto toDto() {
		return new CommentResponseDto(
			this.id,
			this.contents
			);
	}

	public void updateReview(String contents) {
		this.contents = contents;
	}

	public void updateComment(String contents) {
		this.contents = contents;
	}
}
