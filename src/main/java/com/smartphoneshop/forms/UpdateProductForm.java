package com.smartphoneshop.forms;

import com.smartphoneshop.entity.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UpdateProductForm {

    private String title;
    private String descriptions;
    private int originalPrice;
    private int promotionPrice;
    private short amount;
    private Integer cateId;
    private List<CreateProductImageForm> productImages;

    public Product toEntity(){
        Product p = new Product(
                title,
                descriptions,
                originalPrice,
                promotionPrice,
                amount);
        return p;
    }


}
