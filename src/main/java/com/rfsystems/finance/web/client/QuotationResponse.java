package com.rfsystems.finance.web.client;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.ArrayList;

@ApplicationScoped
public class QuotationResponse implements Serializable {
    @JsonProperty("@odata.context")
    public String odataContext;
    public ArrayList<Value> value;

    public QuotationResponse(){}

}

