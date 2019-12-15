package xyz.just.board.member.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import xyz.just.board.member.entity.JustMember;

import java.util.Optional;

public interface JustMemberRepository extends JpaRepository<JustMember, Long> {
    Optional<JustMember> findByEmail(String username);
}
