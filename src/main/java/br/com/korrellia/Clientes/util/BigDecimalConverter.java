package br.com.korrellia.Clientes.util;


import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BigDecimalConverter {

    public BigDecimal converter(String value){
        return new BigDecimal(value.replace(",", "").replace(",", "."));
    }
}
