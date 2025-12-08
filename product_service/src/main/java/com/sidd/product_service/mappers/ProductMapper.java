package com.sidd.product_service.mappers;

import com.sidd.product_service.dto.input.ProductInputDto;
import com.sidd.product_service.dto.output.ProductOutputDto;
import com.sidd.product_service.entities.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {
    //using manual mapping instead of mapstruct for learning

    public List<ProductEntity> dtoListToEntityList(List<ProductInputDto> dtoList) {
        return dtoList.stream()
                .map(ProductMapper::dtoToEntity)
                .toList();
    }

    public List<ProductOutputDto> entityToDtoList(List<ProductEntity> entityList) {
        return entityList.stream()
                .map(ProductMapper::entityToDto)
                .toList();
    }

    public static ProductOutputDto entityToDto(ProductEntity entity) {
        return ProductOutputDto.builder()
                .id(entity.getId())
                .prd_price(entity.getPrd_price())
                .prd_name(entity.getPrd_name())
                .prd_category(entity.getPrd_category())
                .prd_quantity(entity.getPrd_quantity())
                .build();
    }

    public static ProductEntity dtoToEntity(ProductInputDto dto) {
        return ProductEntity.builder()
                .prd_name(dto.getPrd_name())
                .prd_category(dto.getPrd_category())
                .prd_price(dto.getPrd_price())
                .prd_quantity(dto.getPrd_quantity())
                .build();
    }
}
