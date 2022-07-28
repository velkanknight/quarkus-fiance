package com.rfsystems.finance.services;

import com.rfsystems.finance.web.client.QuotationResponse;

public interface QuotationService {

    public QuotationResponse getQuote(String dataQuote);

}
