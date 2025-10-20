package org.webservice.api.domain.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.RolesDto;
import org.webservice.api.domain.UsersDto;
import org.webservice.api.persistence.UsersRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final Log LOGGER = LogFactory.getLog(UserDetailsService.class);
    private final UsersRepository usersRepository;

    @Autowired
    public UserDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        UsersDto user = usersRepository.findByUserEmail(userEmail)
                .orElseThrow(()-> new UsernameNotFoundException("email:" + userEmail + "not found!"));

        String[] roles = user.getRoles().stream().map(RolesDto::getRoleDesc).toArray(String[]::new);

        return User.builder()
                .username(user.getUserEmail())
                .password(user.getUserPassword())
                .authorities(this.grantedAuthorities(roles))
                .accountLocked(user.isUserLocked())
                .disabled(user.isUserDisabled())
                .build();
    }

    private String[] getAuthorities (String role){
        if("ADMIN".equals(role) || "DEFAULT".equals(role)){
            return new String[]{"update_content"};
        }
        return new String[]{};
    }

    public List<GrantedAuthority> grantedAuthorities(String[] roles){
        List<GrantedAuthority> authorities = new ArrayList<>(roles.length);
        for(String role:roles){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
            for (String authority: this.getAuthorities(role)){
                authorities.add(new SimpleGrantedAuthority(authority));
            }
        }
        return authorities;
    }
}
