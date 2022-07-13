package com.smartphoneshop.base;

import com.smartphoneshop.dto.ResponseDTO;
import com.smartphoneshop.dto.pagination.PaginateDTO;
import com.smartphoneshop.dto.pagination.PaginationDTO;
import com.smartphoneshop.dto.pagination.PaginationResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BaseController<T>{
    public ResponseEntity<?> resSuccess(T data) {
        Map<String, T> map = new HashMap<>();
        map.put("data", data);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO<>(HttpStatus.OK.value(), "Success", map));
    }

    public ResponseEntity<?> resListSuccess(List<?> data) {
        Map<String, List<?>> map = new HashMap<>();
        map.put("data", data);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO<>(HttpStatus.OK.value(), "Success", map));
    }

    public ResponseEntity<?> resPagination(PaginateDTO<?> paginateDTO) {
        PaginationDTO<List<?>> paginationDTO = new PaginationDTO<>(paginateDTO.getPageData().getContent(),
                paginateDTO.getPagination());
        return ResponseEntity.status(HttpStatus.OK)
                .body(new PaginationResponseDTO<>(HttpStatus.OK.value(), "Success", paginationDTO));
    }
}
