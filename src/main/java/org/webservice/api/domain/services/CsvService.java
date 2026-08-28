package org.webservice.api.domain.services;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.webservice.api.domain.core.GamesDto;
import org.webservice.api.domain.dto.db2.AssetsRequest;
import org.webservice.api.domain.services.core.GameService;
import org.webservice.api.web.exceptions.CsvProcessingException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CsvService {
    private final Log LOGGER = LogFactory.getLog(CsvService.class);
    private final GameService gameService;

    public MultipartFile validateCsv(MultipartFile file){
        LOGGER.info("file name: {"+ file.getOriginalFilename() +"}");
        LOGGER.info("file size (bytes): {"+ file.getSize() +"}");
        if (file.isEmpty()) {
            throw new IllegalArgumentException("file is empty");
        }
        if (!file.getOriginalFilename().toLowerCase().endsWith(".csv") || file.getOriginalFilename() == null) {
            throw new IllegalArgumentException("file must be csv");
        }
        return file;
    }

    public List<AssetsRequest> processCsvAsset(MultipartFile file){
        try(Reader reader = new InputStreamReader(validateCsv(file).getInputStream(),StandardCharsets.UTF_8)) {
            LOGGER.info("processing file...");
            CsvToBean<AssetsRequest> csvToBean = new CsvToBeanBuilder<AssetsRequest>(reader)
                    .withType(AssetsRequest.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withThrowExceptions(true)
                    .build();
            return csvToBean.parse();
        } catch (IOException ex) {
            LOGGER.error("io error while reading file", ex);
            throw new CsvProcessingException("error reading the file", ex);
        } catch (RuntimeException ex) {
            LOGGER.error("csv parsing error", ex);
            throw new CsvProcessingException("invalid csv structure or data", ex);
        }
    }

    public List<GamesDto> processCsv(MultipartFile file){
        try(Reader reader = new InputStreamReader(validateCsv(file).getInputStream(),StandardCharsets.UTF_8)) {
            LOGGER.info("processing file...");
            CsvToBean<GamesDto> csvToBean = new CsvToBeanBuilder<GamesDto>(reader)
                    .withType(GamesDto.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withThrowExceptions(true)
                    .build();
            return csvToBean.parse();
        }catch (Exception ex){
            LOGGER.error("runtime error: " + ex.getMessage());
            throw new RuntimeException("runtime error: " + ex.getMessage(), ex);
        }
    }

    public void saveList(List<GamesDto> listGames){
        listGames.forEach(gameService::save);
        LOGGER.info("saved data from csv");
    }
}

/*
        try(BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))){
            String line;
            boolean isHeader = true;
            List<GamesDto> list = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                if(isHeader){
                    isHeader = false;
                    LOGGER.info("header CSV: " + line);
                    continue;
                }
                String[] columns = line.split(",");
                GamesDto game = new GamesDto();
                game.setGameTitle(columns[0]);
                game.setGameDescription(columns[1]);
                game.setGameGenre(Long.parseLong(columns[2]));
                game.setGamePlatform(Long.parseLong(columns[3]));
                game.setGameDeveloper(columns[4]);
                game.setGameClassification(columns[5]);
                game.setReleaseDate(Date.valueOf(columns[6]));
                game.setPrice(Integer.parseInt(columns[7]));
                list.add(game);
            }
            list.forEach(e->{
                LOGGER.info("data: " + e.getGameTitle() + "," + e.getGameDescription() + "," + e.getReleaseDate());
            });
        }catch(Exception ex){
            throw new RuntimeException("error",ex);
        }

         */