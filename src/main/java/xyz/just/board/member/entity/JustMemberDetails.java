package xyz.just.board.member.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class JustMemberDetails implements UserDetails {

    private JustMember justMember;

    public JustMemberDetails(JustMember justMember){
        this.justMember = justMember;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();

        for (String authority : justMember.getAuthrities()) {
            authorities.add(new SimpleGrantedAuthority(authority));
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return justMember.getPassword();
    }

    @Override
    public String getUsername() {
        return justMember.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
