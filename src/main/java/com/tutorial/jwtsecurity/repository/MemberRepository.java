package com.tutorial.jwtsecurity.repository;

import com.tutorial.jwtsecurity.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByNickname(String nickname);  // nickname이 로그인에 쓰이는 ID라서
    boolean existsByNickname(String nickname);  // 증복 가입 방지
}
