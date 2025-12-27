package org.webservice.api.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.UsersDto;
import org.webservice.api.domain.repository.UsersRepositoryDto;
import org.webservice.api.persistence.crud.UsersCrudRepository;
import org.webservice.api.persistence.entity.Users;
import org.webservice.api.persistence.mapper.UsersMapper;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UsersRepository implements UsersRepositoryDto {
    private final UsersCrudRepository usersCrudRepository;
    private final UsersMapper mapper ;

    @Override
    public Optional<List<UsersDto>> findAll() {
        List<Users> userList = (List<Users>) usersCrudRepository.findAll();
        return Optional.of(mapper.toUsersDto(userList));
    }

    @Override
    public Optional<UsersDto> findByUserEmail(String email) {
        return usersCrudRepository.findByUserEmail(email)
                .map(mapper::toUsersDto);
    }

    @Override
    public Optional<UsersDto> findByUserId(Long id) {
        return usersCrudRepository.findByUserId(id)
                .map(mapper::toUsersDto);
    }

    @Override
    public UsersDto save(UsersDto user) {
        return mapper.toUsersDto(usersCrudRepository.save(mapper.toUsers(user)));
    }
}
