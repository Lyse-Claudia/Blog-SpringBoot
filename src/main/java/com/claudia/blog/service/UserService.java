package com.claudia.blog.service;

import com.claudia.blog.domain.entity.Role;
import com.claudia.blog.domain.entity.UserAccount;
import com.claudia.blog.repository.RoleRepository;
import com.claudia.blog.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserAccount> getAllUsers() {
        return userRepository.findAll();
    }

    public UserAccount createUser(String username, String rawPassword, List<Role> roles) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(passwordEncoder.encode(rawPassword));
        userAccount.setRoles(resolveRoles(roles));
        return userRepository.save(userAccount);
    }

    public UserAccount insertUsers(UserAccount userAccount) {
        userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
        userAccount.setRoles(resolveRoles(userAccount.getRoles()));
        return userRepository.save(userAccount);
    }

    public void deleteUserById(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }

    public Optional<UserAccount> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    private List<Role> resolveRoles(List<Role> roles) {
        if (roles != null && !roles.isEmpty()) {
            return roles;
        }

        Role defaultRole = roleRepository.findByName("USER")
                .orElseGet(() -> {
                    Role role = new Role();
                    role.setName("USER");
                    return roleRepository.save(role);
                });

        return Collections.singletonList(defaultRole);
    }
}
