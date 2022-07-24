package com.smartphoneshop.filters;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductFilter {
    private Integer startId;

    private Integer endId;

    private String search;

    private Integer page;

    private Integer perPage;
}
