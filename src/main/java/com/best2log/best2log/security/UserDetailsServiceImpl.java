package com.best2log.best2log.security;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.best2log.best2log.model.Funcionario;
import com.best2log.best2log.service.FuncionarioService;



@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    FuncionarioService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<Funcionario> usuario=service.findByCpf(username);
       if(usuario.isEmpty()) {
           throw new UsernameNotFoundException("O usuário não foi encontrado");
       }
       return new DetalheUser(String.format("%s-%s",usuario.get().getCpf(),usuario.get().getCargo()),usuario.get().getSenha());
   

      

    }
}
