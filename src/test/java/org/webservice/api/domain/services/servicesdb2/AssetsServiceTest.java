package org.webservice.api.domain.services.servicesdb2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.webservice.api.domain.coredb2.AssetsDto;
import org.webservice.api.persistencedb2.AssetsRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AssetsServiceTest {
    @Mock
    private AssetsRepository assetsRepository;

    @InjectMocks
    private AssetsService assetsService;

    @Test
    void findById() {
        // Arrange: preparar los datos
        AssetsDto asset = new AssetsDto();
        asset.setAssetId(1L);

        when(assetsRepository.findById(1L))
                .thenReturn(Optional.of(asset));

        // Act: ejecutar el metodo que queremos probar
        Optional<AssetsDto> result = assetsService.findById(1L);

        // Assert: comprobar el resultado
        assertNotNull(result);
        assertEquals(1L,result.get().getAssetId());

    }
}