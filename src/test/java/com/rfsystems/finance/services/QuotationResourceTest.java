package com.rfsystems.finance.services;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.core.api.dataset.DataSet;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.approvaltests.Approvals;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;
@DBRider
//ignorando uppercase de nome de tabela
@DBUnit(caseInsensitiveStrategy = Orthography.LOWERCASE)
@QuarkusTest
//@QuarkusTestResource(QuotationTestLifecycleManager.class)
public class QuotationResourceTest {

    @Test
//     no data set podemos definir varias propriedades, como limpar o banco antes do teste, depois, desabilitar as constraits
//    aqui ele vai buscar o arquivo definido para popular o cenario que vc escolher
    @DataSet("restaurantes-cenario-1.yml")
    public void testBuscarRestaurantes() {
        String resultado = given()
                .when().get("")
                .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .extract().asString();
        Approvals.verifyJson(resultado);
    }

//    private RequestSpecification given() {
//        return RestAssured.given()
//                .contentType(ContentType.JSON).header(new Header("Authorization", "Bearer " + token));
//    }

}

//subindo um banco como container
