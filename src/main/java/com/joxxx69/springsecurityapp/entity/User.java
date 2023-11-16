package com.joxxx69.springsecurityapp.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_user")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User implements UserDetails{
    @Id
    //@SequenceGenerator(
    //    name = "user_sequence",
    //    sequenceName = "user_sequence",
    //    allocationSize = 1
    //)
    //@GeneratedValue(
    //    generator = "user_sequence",
    //    strategy = GenerationType.SEQUENCE
        
    //)
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Enumerated(EnumType.ORDINAL)
    private Role role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // devuelve los roles del usuario
        return List.of(new SimpleGrantedAuthority(role.name())); // SimpleGrantedAuthority --> clase de spring boot que representar una autoridad (o un rol)
    }
    @Override
    public String getUsername() {
        return email;
    }
    @Override
    public boolean isAccountNonExpired() { // indica si la cuenta del usuario no ha caducado.
        return true;  // la cuenta no ha caducado
    }
    @Override
    public boolean isAccountNonLocked() { //Determina si la cuenta del usuario no está bloqueada.
        return true; // la cuenta no esta bloqueada
    }
    @Override
    public boolean isCredentialsNonExpired() { //Indica si las credenciales del usuario no han caducado.
        return true; //las credenciales no caducan
    }
    @Override
    public boolean isEnabled() {  // Indica si la cuenta del usuario está habilitada.
        return true; //la cuenta está habilitada
    }



    
}
