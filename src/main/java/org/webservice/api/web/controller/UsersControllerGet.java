package org.webservice.api.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webservice.api.domain.UsersDto;
import org.webservice.api.domain.services.UserDtoService;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class UsersControllerGet {
    private final Log LOGGER = LogFactory.getLog(UsersControllerGet.class);
    private final UserDtoService userDtoService;

    @Autowired
    public UsersControllerGet(UserDtoService userDtoService) {
        this.userDtoService = userDtoService;
    }

    @GetMapping("/users")
    public ResponseEntity<Optional<List<UsersDto>>> getUsers(){
        return new ResponseEntity<>(userDtoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") long id){
        if(!userDtoService.findByUserId(id).isEmpty()){
            LOGGER.info("results obtained");
            return new ResponseEntity<>(userDtoService.findByUserId(id).get(),HttpStatus.OK);
        }
        LOGGER.error("results not obtained");
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new HashMap<String,String>(){{
                    put("message","results not obtained");
                }});
    }
}