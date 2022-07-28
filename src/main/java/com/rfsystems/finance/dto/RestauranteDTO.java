//package com.rfsystems.finance.dto;
//
//import javax.validation.ConstraintValidatorContext;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;
//
//@ValidDTO
//public class RestauranteDTO implements DTO{
//
//    public String proprietario;
//
//    @Pattern(regexp = "[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}\\/[0-9]{4}\\-[0-9]{2}")
//    @NotNull
//    public String cnpj;
//
//    @Size(max = 30, min = 3)
//    public String nome;
//
//    public LocalizacaoDTO localizacao;
//
//    public String dataCriacao;
//
//    @Override
//    public boolean isValid(ConstraintValidatorContext constraintValidatorContext) {
//        constraintValidatorContext.disableDefaultConstraintViolation();
//        if (Restaurante.find("cnpj", cnpj).count()>0){
//            constraintValidatorContext.buildConstraintViolationWithTemplate("CNPJ já cadastrado")
//                    .addPropertyNode("cnpj")
//                    .addConstraintViolation();
//            return false;
//        } return true;
//    }
//
//}
