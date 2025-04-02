package org.webservice.api.domain.repository;

import org.webservice.api.domain.UsersDto;

import java.util.List;
import java.util.Optional;

public interface UsersRepositoryDto {
    Optional<List<UsersDto>> findAll();
    Optional<UsersDto> findByUserEmail(String email);
    Optional<UsersDto> findByUserId(Long id);
    UsersDto save(UsersDto user);
}
