package com.binar.challenge4.security.impl;

import com.binar.challenge4.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.Objects;


public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long userid;
    private String username;
    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(long userid, String username, String email, String password, List<SimpleGrantedAuthority> authorities) {
        this.userid=userid;
        this.username=username;
        this.email=email;
        this.password=password;
        this.authorities=authorities;
    }

    public static UserDetailsImpl build(UserEntity user) {
        List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .toList();

        return new UserDetailsImpl(
                user.getUserid(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                authorities);

    }


    public Long getUserid() {
        return userid;
    }

    public String getEmail() {
        return email;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(userid, user.userid);
    }
    @Override
    public int hashCode() {
        return 0;
    }
}
