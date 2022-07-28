package com.rfsystems.finance.resource;

import com.rfsystems.finance.services.DolarQuotationService;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.SimplyTimed;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/quotation")
public class QuotationResource {

    @Inject
    DolarQuotationService service;

    @GET
    @Counted(name="Quantidade de chamadas Cotacoes")
    @SimplyTimed(name = "tempo simples de busca cotacoes")
    @Timed(name = "Tempo completo de busca cotacoes")
    @Tag(name = "quotation")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("{dataCotacao}")
    public Response getQuote(@PathParam("dataCotacao") String dataCotacao) {

        try {
            return Response.ok(service.getQuote(dataCotacao)).build();
        } catch (Exception e){
            LoggerFactory.getLogger(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }

}