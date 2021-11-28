package com.example.forecast.services.impl;

import com.example.forecast.models.entityModels.User;
import com.example.forecast.repositories.UserRepository;
import com.example.forecast.services.ForecastUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForecastUserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public ForecastUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User with name " + username + " not found!"));

        return mapToUserDetails(user);
    }

    private UserDetails mapToUserDetails(User user) {

        List<GrantedAuthority> authorities = user
                .getRoles()
                .stream()
                .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getRole().name()))
                .collect(Collectors.toList());

        return new ForecastUser(
                user.getUsername(),
                user.getPassword(),
                authorities);
    }
}
