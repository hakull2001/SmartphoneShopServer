package com.smartphoneshop.forms;

import com.smartphoneshop.entity.Product;
import com.smartphoneshop.entity.ProductImage;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateProductImageForm {

    private String imageUrl;

    public ProductImage toEntity(){
        return new ProductImage(imageUrl);
    }

}
