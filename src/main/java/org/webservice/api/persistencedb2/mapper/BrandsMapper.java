package org.webservice.api.persistencedb2.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.webservice.api.domain.coredb2.BrandsDto;
import org.webservice.api.persistencedb2.entity.Brands;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandsMapper {
    BrandsDto toBrandsDto(Brands brand);
    List<BrandsDto> toBrandsDto(List<Brands> brands);

    @InheritInverseConfiguration
    Brands toBrands(BrandsDto brandsDto);
}
