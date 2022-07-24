package com.smartphoneshop.forms;

import com.smartphoneshop.entity.Product;
import com.smartphoneshop.validations.ProductTitleNotExists;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
public class UpdateProductForm {

    @NotBlank
    @Length(min = 3 , message = "Tên sản phảm phải dài hơn 3 kí tự")
    @ProductTitleNotExists(message = "Tên sản phẩm không được trùng")
    private String title;

    @NotBlank
    private String descriptions;

    @Min(value = 0 , message = "Giá gốc phải hơn  0")
    private int originalPrice;

    @Min(value = 0 , message = "Giá gốc phải hơn  0")
    private int promotionPrice;

    @Min(value = 0 , message = "Giá gốc phải hơn  0")
    private Integer amount;

    @NotNull
    private Integer categoryId;

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
