package com.s3valkov.unilib.service;

import com.s3valkov.unilib.database.entity.Role;
import com.s3valkov.unilib.database.entity.User;
import com.s3valkov.unilib.dto.binding.auth.UserRegisterBindingModel;
import com.s3valkov.unilib.exception.UserNotFoundException;
import com.s3valkov.unilib.repository.UserRepository;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

import java.util.Set;

@Service
public class UserServiceImpl implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void createAndLoginUser(UserRegisterBindingModel userModel) {
        User newUser = createUser(userModel);
        User user = loadUserByUsername(newUser.getUsername());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user,
                userModel.getPassword(),
                user.getAuthorities()
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Transactional
    public User createUser(UserRegisterBindingModel userModel) {
        LOGGER.info("Creating a new user with username {}.", userModel.getUsername());
        User user = this.modelMapper.map(userModel, User.class);

        if (userModel.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        }

//        Role customerRole = this.roleService.findRoleByName("ROLE_CUSTOMER");
//        user.setRoles(Set.of(customerRole));
        return userRepository.save(user);
    }

    @Transactional
    public void confirmUserEmail(User user){
        this.userRepository.save(user);
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public User findUserById(Long userId){
        return this.userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with given id was not found!"));
    }

    public boolean isUsernameAvailable(String username){
        return userRepository.findByUsername(username).isPresent();
    }
}
