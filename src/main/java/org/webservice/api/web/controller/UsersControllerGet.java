package org.webservice.api.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
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

@Tag(name = "02 - Controlador usuarios")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UsersControllerGet {
    private final Log LOGGER = LogFactory.getLog(UsersControllerGet.class);
    private final UserDtoService userDtoService;

    @Operation(summary = "obtiene todos los registro de usuarios del sistema", description = "Lista completa de usuarios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Lista obtenida correctamente"),
            @ApiResponse(responseCode = "500",description = "error interno del servidor")
    })
    @GetMapping("/users")
    public ResponseEntity<Optional<List<UsersDto>>> getUsers(){
        return new ResponseEntity<>(userDtoService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtiene un registro por medio de un id", description = "obtiene un elemento de la base de datos ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "objeto obtenido correctamente"),
            @ApiResponse(responseCode = "500",description = "error interno del servidor")
    })
    @GetMapping("/users/{id}")
    public ResponseEntity<UsersDto> getUserById(@PathVariable("id") long id){
       return userDtoService.findByUserId(id)
               .map( user ->{
                   LOGGER.info("results obtained");
                   return new ResponseEntity<>(user,HttpStatus.OK);
                       })
               .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}