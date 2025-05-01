package org.example.todov2.domain.member.repository;

import org.example.todov2.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

	default Member findMemberByIdOrElseThrow(Long memberId) {
		return findById(memberId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + memberId));
	}
}
