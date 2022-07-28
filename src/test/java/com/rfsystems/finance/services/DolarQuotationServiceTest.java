package com.rfsystems.finance.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rfsystems.finance.web.client.DolarQuotationClient;
import com.rfsystems.finance.web.client.QuotationResponse;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyString;

@QuarkusTest
class DolarQuotationServiceTest {

    @InjectMock
    DolarQuotationClient mockClient;

    private DolarQuotationService dolarQuotationServiceUnderTest;
    private QuotationResponse quotationResponse;
    private String quote = "{\"@odata.context\":\"https://was-p.bcnet.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata$metadata#_CotacaoDolarDia\",\"value\":[{\"cotacaoCompra\": 5.41380,\"cotacaoVenda\": 5.41440,\"dataHoraCotacao\": \"2022-07-25 13:10:35.499\"}]}";

    @BeforeEach
    void setUp() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        quotationResponse = mapper.readValue(quote, QuotationResponse.class);
        Mockito.when(mockClient.getDolarQuote(anyString())).thenReturn(quotationResponse);
    }

    @Test
    void testGetQuote() {

        // Run the test
        final QuotationResponse result = dolarQuotationServiceUnderTest.getQuote("07-26-2022");
        Assertions.assertEquals("07-26-2022", result.value.get(0).dataHoraCotacao);

        // Verify the results
    }
}
