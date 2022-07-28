package com.rfsystems.finance.web.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface DolarQuotationClient {

    @GET
    QuotationResponse getDolarQuote(@QueryParam("@dataCotacao") String dataCotacao);

}

