package com.smartphoneshop.specifications;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@NoArgsConstructor
public class FilterSearch {


    private Integer page;

    private Integer size;

    private Integer mnId;

    private Integer mxId;


}
