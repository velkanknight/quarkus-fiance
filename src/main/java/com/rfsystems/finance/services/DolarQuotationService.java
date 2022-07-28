package com.rfsystems.finance.services;

import com.rfsystems.finance.models.Quotation;
import com.rfsystems.finance.validators.DateValidatorUsingDateFormat;
import com.rfsystems.finance.web.client.DolarQuotationClient;
import com.rfsystems.finance.web.client.QuotationResponse;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.UUID;

@ApplicationScoped
public class DolarQuotationService implements QuotationService{

    @Inject
    @RestClient
    DolarQuotationClient dolarQuotationClient;

    @Override
    public QuotationResponse getQuote(String dataCotacao) {

        if(isValidDate(dataCotacao)) {
            LocalDateTime instantRequest = LocalDateTime.now();
            QuotationResponse dolarQuote = dolarQuotationClient.getDolarQuote("'" + dataCotacao + "'");
            Quotation quote = new Quotation(dolarQuote);
            quote.dataHoraRequest = instantRequest;
            quote.requestId = UUID.randomUUID();
            quote.persist();
            return dolarQuote;
        } else {
            throw new RuntimeException("Invalide date");
        }
    }

    private boolean isValidDate(String data){
        return new DateValidatorUsingDateFormat("MM-dd-YYYY").isValid(data);
    }

}
