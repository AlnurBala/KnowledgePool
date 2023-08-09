package com.matrix.knowpoolwebsite.mapper;

import com.matrix.knowpoolwebsite.dto.request.DiscountRequest;
import com.matrix.knowpoolwebsite.dto.response.DiscountResponseDto;
import com.matrix.knowpoolwebsite.entity.Discount;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public interface DiscountMapper {
    Discount fromDTO(DiscountRequest discountRequest);

    DiscountResponseDto toDTO(Discount discount);

    List<DiscountResponseDto> toDTOs(List<Discount> discounts);

    Discount mapUpdateRequestToEntity(@MappingTarget Discount discount, DiscountRequest discountRequest);
}
