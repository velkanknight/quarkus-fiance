package com.rfsystems.finance.models;

import com.rfsystems.finance.web.client.QuotationResponse;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;
import java.util.UUID;

@Entity
@Table(name = "quotation")
public class Quotation extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull
    public UUID requestId;

    @NotNull
    public LocalDateTime dataHoraRequest;

    @NotNull
    public Double cotacaoCompra;

    @NotNull
    public Double cotacaoVenda;

    @NotNull
    public LocalDateTime dataHoraCotacao;

    public Quotation(QuotationResponse dolarQuote) {
        cotacaoCompra = dolarQuote.value.get(0).cotacaoCompra;
        cotacaoVenda = dolarQuote.value.get(0).cotacaoVenda;
        String dataHoraCotacao = dolarQuote.value.get(0).dataHoraCotacao;
        this.dataHoraCotacao = LocalDateTime.parse(dataHoraCotacao, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        cotacaoCompra = dolarQuote.value.get(0).cotacaoCompra;
    }

    public Quotation() {}
}
