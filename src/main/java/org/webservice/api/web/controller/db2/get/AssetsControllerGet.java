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
import org.springframework.web.bind.annotation.*;
import org.webservice.api.domain.coredb2.AssetsDto;
import org.webservice.api.domain.coredb2.AssetsViewDto;
import org.webservice.api.domain.services.servicesdb2.AssetsService;
import org.webservice.api.web.exceptions.MessageResponse;

@Tag(name = "13 - Controlador Assets")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class AssetsControllerGet {
    private final Log LOGGER = LogFactory.getLog(AssetsControllerGet.class);
    private final AssetsService service;

    @Operation(summary = "Obtiene todos los Activos", description = "Lista completa de elementos disponibles")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista obtenida correctamente",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AssetsDto.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "error interno del servidor",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MessageResponse.class)))
    })
    @GetMapping("/assets")
    public ResponseEntity<?> getAllAssets(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtiene una vista de los activos", description = "Lista completa de elementos disponibles")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista obtenida correctamente",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AssetsViewDto.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "error interno del servidor",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MessageResponse.class)))
    })
    @GetMapping("/assets-view")
    public ResponseEntity<?> getAllAssetsView(){
        return new ResponseEntity<>(service.findAllView(), HttpStatus.OK);
    }

    @Operation(summary = "Obtiene la busqueda de los activos", description = "Lista encontrada de elementos disponibles")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista obtenida correctamente",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AssetsViewDto.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "error interno del servidor",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MessageResponse.class)))
    })
    @GetMapping("/assets/search")
    public ResponseEntity<?> searchAssets(@RequestParam String value){
        return new ResponseEntity<>(service.searchAssets(value),HttpStatus.OK);
    }

    @Operation(summary = "Obtiene activo por id ", description = "Elemento por id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Elemento obtenido correctamente",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AssetsDto.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "error interno del servidor",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MessageResponse.class)))
    })
    @GetMapping("/asset/{id}")
    public ResponseEntity<?> getAssetById(@PathVariable("id")Long id){
        try {
            return service.findById(id)
                    .map(asset->{
                        LOGGER.info("data obtained success");
                        return new ResponseEntity<>(asset,HttpStatus.OK);
                    })
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception ex){
            LOGGER.error( new MessageResponse(ex.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse(ex.getMessage()));
        }
    }

    @Operation(summary = "Obtiene vista del activo por id ", description = "Elemento por id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Elemento obtenido correctamente",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AssetsDto.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "error interno del servidor",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MessageResponse.class)))
    })
    @GetMapping("/asset-view/{id}")
    public  ResponseEntity<?> getViewById(@PathVariable("id")Long id){
        try {
            return service.findViewById(id)
                    .map(asset->{
                        LOGGER.info("data obtained success");
                        return new ResponseEntity<>(asset,HttpStatus.OK);
                    })
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception ex){
            LOGGER.error( new MessageResponse(ex.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse(ex.getMessage()));
        }
    }
}
