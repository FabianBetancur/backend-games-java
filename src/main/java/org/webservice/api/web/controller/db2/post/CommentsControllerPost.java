package org.webservice.api.web.controller.db2.post;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webservice.api.domain.dto.db2.AssetsRequest;
import org.webservice.api.domain.dto.db2.CommentRequest;
import org.webservice.api.domain.services.servicesdb2.CommentsService;
import org.webservice.api.web.exceptions.MessageResponse;

@Tag(name = "13 - Controlador Assets")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class CommentsControllerPost {
    private final Log LOGGER = LogFactory.getLog(CommentsControllerPost.class);
    private final CommentsService service;

    @Operation(summary = "Guarda un comentario en la base de datos", description = "guarda un elemento en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Elemento guardado correctamente",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = CommentRequest.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "error interno del servidor",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MessageResponse.class)))
    })
    @PostMapping("/comment")
    public ResponseEntity<?> saveComment(@Valid @RequestBody CommentRequest request){
        service.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(request);
    }

}
