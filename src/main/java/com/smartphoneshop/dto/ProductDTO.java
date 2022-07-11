package com.smartphoneshop.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.smartphoneshop.entity.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class ProductDTO {
    private String title;

    private String descriptions;

    private int originalPrice;

    private int promotionPrice;

    private Date createdDate;

    private short amount;

    private short status;

    private List<ProductImage> productImages;

    private List<ProductRateDTO> productRate;
    @Data
    @NoArgsConstructor
    static class ProductRateDTO{
        @JsonProperty("productRateId")
        private Integer id;

        private User user;

        private Integer value;

        private String comment;

        private Date createdAt;
    }

}
