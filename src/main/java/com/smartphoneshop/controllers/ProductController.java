package com.smartphoneshop.controllers;

import com.smartphoneshop.base.BaseController;
import com.smartphoneshop.base.BaseControllerDTO;
import com.smartphoneshop.dto.ProductDTO;
import com.smartphoneshop.dto.pagination.PaginateDTO;
import com.smartphoneshop.entity.Product;
import com.smartphoneshop.entity.ProductRate;
import com.smartphoneshop.services.IProductRateService;
import com.smartphoneshop.services.IProductService;
import com.smartphoneshop.specifications.GenericSpecification;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/v1/products")
@RestController
@CrossOrigin("*")
public class ProductController extends BaseController<Product> {
    @Autowired
    private IProductService productService;

    @Autowired
    private IProductRateService productRateService;

    @Autowired
    private ModelMapper modelMapper;

//    @GetMapping
//    public ResponseEntity<?> getListProducts(){
//        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<?> getList(@RequestParam(name="page", required = false) Integer page,
                                     @RequestParam(name="perPage", required = false) Integer perPage,
                                     HttpServletRequest request){
        GenericSpecification<Product> specification = new GenericSpecification<Product>().getBasicQuery(request);
        PaginateDTO<Product> paginateTours = productService.getList(page,
                perPage, specification);


        for (Product product : paginateTours.getPageData().getContent()){
            //1
            List<ProductRate> list = productRateService.findListProductRatesByProductId(product.getId());
            product.setProductRate(list);
        }
        return this.resPagination(paginateTours);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Integer id) throws Exception {
        Product product = productService.getProductById(id);
        if(product == null)
            throw new Exception("Can not find this product!");
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
