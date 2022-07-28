package com.rfsystems.finance.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

@ValidDTO
public class QuotationDTO implements  DTO{

    public String requestId;

    public String timeStampRequest;

    public BigDecimal buyQuotation;

    public BigDecimal sellQuotation;

    public LocalDate dateQuotation;


}
