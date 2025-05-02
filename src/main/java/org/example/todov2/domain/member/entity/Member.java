package org.example.todov2.domain.member.entity;

import java.util.ArrayList;
import java.util.List;

import org.example.todov2.common.BaseEntity;
import org.example.todov2.domain.comment.entity.Comment;
import org.example.todov2.domain.todo.entity.Todo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member")
public class Member extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String name;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String email;

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Todo> todos = new ArrayList<>();

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Comment> comments = new ArrayList<>();

	public Member(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}

	// public MemberResponseDto toDto() {
	// 	return new MemberResponseDto(this.name, this.email);
	// }
	//
	// public void updatePassword(String password) {
	// 	this.password = password;
	// }
}
