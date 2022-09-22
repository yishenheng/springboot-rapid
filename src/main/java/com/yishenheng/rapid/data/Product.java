package com.yishenheng.rapid.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author yishenheng
 * @date 2022/9/21 11:12
 */
@Data
@AllArgsConstructor
public class Product {

    private String name;

    private String skuId;

    private BigDecimal price;

    private String des;

    public Product() {
    }
}
