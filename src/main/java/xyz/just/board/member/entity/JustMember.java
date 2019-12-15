package xyz.just.board.member.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class JustMember {

    @Id
    @GeneratedValue
    private Long id;

    private String email;

    private String nickName;

    private String password;

    @ElementCollection
    private Set<String> authrities = new HashSet<>();
}
