package org.webservice.api.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.webservice.api.domain.core.GamesDto;
import org.webservice.api.domain.services.CsvService;
import org.webservice.api.web.exceptions.MessageResponse;

import java.util.List;
import java.util.Objects;

@Tag(name = "12 - Csv Controller")
@RestController
@RequestMapping("/csv")
@RequiredArgsConstructor
public class CsvControllerPost {
    private final Log LOGGER = LogFactory.getLog(CsvControllerPost.class);
    private final CsvService csvService;

    @Operation(summary = "Process csv file", description = "csv file")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "process ok",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = GamesDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "bad request",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MessageResponse.class)
                    )
            )
    })
    @PostMapping(
            value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<List<GamesDto>> processCsv(@RequestPart("file") MultipartFile file) {
        List<GamesDto> result = csvService.processCsv(file);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Process and save csv file", description = "save csv file")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "process ok",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MessageResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "bad request",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MessageResponse.class)
                    )
            )
    })
    @PostMapping(
            value = "/save",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<?> saveCsv(@RequestPart("file") MultipartFile file){
        if (file.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(new MessageResponse("file is empty"));
        }

        if (!Objects.requireNonNull(file.getOriginalFilename()).endsWith(".csv")) {
            return ResponseEntity.badRequest()
                    .body(new MessageResponse("file must be csv"));
        }

        csvService.saveList(csvService.processCsv(file));
        return ResponseEntity.ok(new MessageResponse("data saved successfully"));
    }
}