package com.matrix.knowpoolwebsite.mapper;

import com.matrix.knowpoolwebsite.dto.request.TransactionRequest;
import com.matrix.knowpoolwebsite.dto.response.TransactionResponseDto;
import com.matrix.knowpoolwebsite.entity.Transaction;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public interface TransactionMapper {
    Transaction fromDTO(TransactionRequest transactionRequest);

    TransactionResponseDto toDTO(Transaction transaction);

    List<TransactionResponseDto> toDTOs(List<Transaction> transactions);

    Transaction mapUpdateRequestToEntity(@MappingTarget Transaction transaction, TransactionRequest transactionRequest);

}
