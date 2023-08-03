package com.example.knowpoolwebsite.mapper;

import com.example.knowpoolwebsite.dto.Request.CourseRequest;
import com.example.knowpoolwebsite.dto.Request.TransactionRequest;
import com.example.knowpoolwebsite.dto.Response.TransactionResponse;
import com.example.knowpoolwebsite.entity.Course;
import com.example.knowpoolwebsite.entity.Transaction;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public interface TransactionMapper {
    Transaction fromDTO(TransactionRequest transactionRequest);

    TransactionResponse toDTO(Transaction transaction);

    List<TransactionResponse> toDTOs(List<Transaction> transactions);
    Transaction mapUpdateRequestToEntity(@MappingTarget Transaction transaction, TransactionRequest transactionRequest);

}
