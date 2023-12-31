package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


public class PrincipalUser implements UserDetails {
    private String name;
    private String numberDocument;
    private String email;
    private String password;
    private  long id;
    private long idMultiplex;

    private Collection<? extends GrantedAuthority> authorities;

    public PrincipalUser(String name, String numberDocument, String email, String password, long id, long idMultiplex,
                         Collection<? extends GrantedAuthority> authorities) {
        this.name = name;
        this.numberDocument = numberDocument;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.id = id;
        this.idMultiplex = idMultiplex;
    }

    public static PrincipalUser build(UserEntity usuario, MemberEntity member, List<RoleEntity> roles) {
            List<SimpleGrantedAuthority> authorities = roles.stream()
                    .map(rol -> new SimpleGrantedAuthority(rol.getName())).toList();
        return new PrincipalUser(usuario.getName(), usuario.getNumberDocument(), usuario.getEmail(),
                member.getPassword(), member.getId(), member.getIdMultiplex(),authorities);
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
        return numberDocument;
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

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public long getId() {
        return id;
    }
    public long getIdMultiplex() {
        return idMultiplex;
    }
}
