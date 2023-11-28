package com.s3valkov.unilib.service;

import com.s3valkov.unilib.database.entity.Role;
import com.s3valkov.unilib.exception.RoleNotFoundException;
import com.s3valkov.unilib.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findRoleByName(String name){
        return this.roleRepository.findByName(name)
                .orElseThrow(() -> new RoleNotFoundException("Role with given name was not found!"));
    }
}