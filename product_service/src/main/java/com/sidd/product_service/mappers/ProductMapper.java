package com.sidd.product_service.mappers;

import com.sidd.product_service.dto.input.ProductInputDto;
import com.sidd.product_service.dto.output.ProductOutputDto;
import com.sidd.product_service.entities.CategoryEntity;
import com.sidd.product_service.entities.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {
    //using manual mapping instead of mapstruct for learning

    public static ProductOutputDto entityToDto(ProductEntity entity) {
        return ProductOutputDto.builder()
                .id(entity.getId())
                .prd_price(entity.getPrdPrice())
                .prd_name(entity.getPrdName())
                .prd_category(entity.getPrdCategory().getId())
                //.prd_quantity(entity.getPrd_quantity())
                .build();
    }

    public static ProductEntity dtoToEntity(ProductInputDto dto) {
        return ProductEntity.builder()
                .prdName(dto.getPrdName())
                .prdCategory(CategoryEntity.builder()
                        .id(dto.getPrdCategory().getId())
                        .build())
                .prdPrice(dto.getPrdPrice())
                //.prd_quantity(dto.getPrd_quantity())
                .build();
    }

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
}
