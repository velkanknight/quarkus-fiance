//package com.rfsystems.finance.services;
//
//import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
//import org.testcontainers.containers.PostgreSQLContainer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//
//public class QuotationTestLifecycleManager implements QuarkusTestResourceLifecycleManager {
//
//    //Aqui vamos subir uma imagem docker para realizar os testes, entao dizemos qual a imagem q usaremos, nesse caso uma com o postgres 12.2
//    public static final PostgreSQLContainer<?> POSTGRES = new PostgreSQLContainer<>("postgres:12.2");
//
//    @Override
//    public Map<String, String> start() {
//        POSTGRES.start();
//        Map<String, String> propriedades = new HashMap<String, String>();
//
//        //Banco de dados, aqui sobreescrevemos as informações do datasource que forem diferentes do properties
//        //como estamos subindo um container, pegamos as credenciais dessa imagem
//        propriedades.put("quarkus.datasource.jdbc.url", POSTGRES.getJdbcUrl());
//        propriedades.put("quarkus.datasource.username", POSTGRES.getUsername());
//        propriedades.put("quarkus.datasource.password", POSTGRES.getPassword());
//
//        return propriedades;
//    }
//
//
//    //aqui paramos o docker container
//    @Override
//    public void stop() {
//        if (POSTGRES != null && POSTGRES.isRunning()) {
//            POSTGRES.stop();
//        }
//    }
//}
