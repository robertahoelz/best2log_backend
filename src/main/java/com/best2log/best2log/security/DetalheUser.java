package com.best2log.best2log.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DetalheUser implements UserDetails {


    String cpf;

    String senha;
    Boolean status;






    public DetalheUser(String cpf, String senha) {
        this.cpf = cpf;
        this.senha= senha;

    }







    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.cpf;
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


}
