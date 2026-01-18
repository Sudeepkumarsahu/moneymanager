package com.sudeep.moneymanager.dto;

import lombok.Data;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;

@Data

public class FilterDTO {
    private String type;
    private LocalDate startDate;
    private LocalDate endDate;
    private String keyword;
    private String sortField;
    private String sortOrder;
}
