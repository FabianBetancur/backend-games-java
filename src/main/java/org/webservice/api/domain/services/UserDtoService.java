package org.webservice.api.domain.services;

import jakarta.transaction.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.UsersDto;
import org.webservice.api.persistence.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserDtoService {
    private final Log LOGGER = LogFactory.getLog(UserDtoService.class);
    private final UsersRepository userRepository;

    @Autowired
    public UserDtoService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<List<UsersDto>> findAll(){
        return userRepository.findAll();
    }

    public Optional<UsersDto> getByEmail(String email){
        return userRepository.findByUserEmail(email);
    }

    public Optional<UsersDto> findByUserId(long userId){
        return userRepository.findByUserId(userId);
    }

    public UsersDto save(UsersDto userDto){
        LOGGER.info("saving user information...");
        return userRepository.save(userDto);
    }
}
