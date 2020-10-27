package com.kodilla.stream.sand;

import java.math.BigDecimal;

public class Europe implements SandStorage {

    //BigDecimal stones = new BigDecimal(9999);

    @Override
    public BigDecimal getSandBeansQuantity() {
        BigDecimal sandQuantity = new BigDecimal("12345678901234567890");
        //return sandQuantity.add(stones);
        return sandQuantity;
    }
}

