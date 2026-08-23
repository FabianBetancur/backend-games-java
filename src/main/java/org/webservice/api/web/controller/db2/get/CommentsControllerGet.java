package org.webservice.api.web.controller.db2.get;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webservice.api.domain.coredb2.AssetsDto;
import org.webservice.api.domain.coredb2.CommentsDto;
import org.webservice.api.domain.services.servicesdb2.CommentsService;
import org.webservice.api.web.exceptions.MessageResponse;

@Tag(name = "13 - Controlador Assets")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class CommentsControllerGet {
    private final CommentsService service;
    private final Log LOGGER = LogFactory.getLog(CommentsControllerGet.class);

    @Operation(summary = "Obtiene comentarios por id de asset ", description = "Elementos por id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Elementos obtenidos correctamente",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = CommentsDto.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "error interno del servidor",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MessageResponse.class)))
    })
    @GetMapping("/comment-asset/{id}")
    public ResponseEntity<?> getByAssetId(@PathVariable("id")long id){
        try {
            return service.findByAssetId(id)
                    .map(ResponseEntity::ok)
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception ex){
            LOGGER.error(new MessageResponse(ex.getMessage()));
            return ResponseEntity.badRequest()
                    .body(new MessageResponse(ex.getMessage()));
        }
    }
}
