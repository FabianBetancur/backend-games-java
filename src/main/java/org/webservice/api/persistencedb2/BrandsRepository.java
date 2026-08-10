package org.webservice.api.persistencedb2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.coredb2.BrandsDto;
import org.webservice.api.domain.repositorydb2.BrandsRepositoryDto;
import org.webservice.api.persistencedb2.crud.BrandsCrudRepository;
import org.webservice.api.persistencedb2.entity.Brands;
import org.webservice.api.persistencedb2.mapper.BrandsMapper;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BrandsRepository implements BrandsRepositoryDto {
    private final BrandsCrudRepository repository;
    private final BrandsMapper mapper;

    @Override
    public Optional<List<BrandsDto>> findAll() {
        return Optional.of((List<Brands>) repository.findAll())
                .map(mapper::toBrandsDto);
    }

    @Override
    public Optional<BrandsDto> save(BrandsDto dto) {
        return Optional.of(repository.save(mapper.toBrands(dto)))
                .map(mapper::toBrandsDto);
    }
}
