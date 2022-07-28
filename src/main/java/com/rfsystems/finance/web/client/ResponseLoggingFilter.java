package com.rfsystems.finance.web.client;

import com.rfsystems.finance.dto.Logged;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Logged
@Provider
public class ResponseLoggingFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext,
                       ContainerResponseContext responseContext) throws IOException {
        System.out.printf("teste");
        // Use the ContainerRequestContext to extract information from the HTTP request
        // Use the ContainerResponseContext to extract information from the HTTP response
    }

}
