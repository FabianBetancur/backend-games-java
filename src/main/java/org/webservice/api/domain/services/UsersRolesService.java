package org.webservice.api.domain.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.UsersRolesDto;
import org.webservice.api.persistence.UsersRolesRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersRolesService {
    private final UsersRolesRepository repository;

    public Optional<List<UsersRolesDto>> findByUserId(long id){
        return repository.findByUserId(id);
    }

    public UsersRolesDto save(UsersRolesDto usersRoles){
        return repository.save(usersRoles);
    }
}
