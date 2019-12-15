package xyz.just.board.member.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import xyz.just.board.member.entity.repository.JustMemberRepository;

public class JustMemberDetailsService implements UserDetailsService {

    @Autowired
    JustMemberRepository memberRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JustMember justMember = memberRepository.findByEmail(username)
                .orElseThrow(()->{
                    return new UsernameNotFoundException("invalid username");
                });
        return new JustMemberDetails(justMember);
    }

    public UserDetails join(JustMember member){
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        JustMember savedMember = memberRepository.save(member);
        return new JustMemberDetails(savedMember);
    }
}
