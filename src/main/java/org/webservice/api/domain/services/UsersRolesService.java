package org.webservice.api.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.UsersRolesDto;
import org.webservice.api.persistence.UsersRolesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsersRolesService {
    private final UsersRolesRepository repository;

    @Autowired
    public UsersRolesService(UsersRolesRepository repository) {
        this.repository = repository;
    }

    public Optional<List<UsersRolesDto>> findByUserId(long id){
        return repository.findByUserId(id);
    }

    public UsersRolesDto save(UsersRolesDto usersRoles){
        return repository.save(usersRoles);
    }
}
