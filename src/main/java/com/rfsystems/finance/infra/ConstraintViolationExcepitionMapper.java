package com.rfsystems.finance.infra;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


//criando um provider para alterar o status code para determinada exceção, ak ConstraintViolationException
@Provider
public class ConstraintViolationExcepitionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        return Response.status(Response.Status.BAD_REQUEST).entity(ConstraintViolationResponse.of(exception)).build();
    }
}
