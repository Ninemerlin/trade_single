package com.dlut.tradesys.common.dto;

import com.dlut.tradesys.common.enums.ItemStatus;
import com.dlut.tradesys.common.pojo.Spec;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

public class ItemFormDTO {
    private String name;
    private Integer price;
    private Integer stock;
    private MultipartFile image;
    private String category;
    private String brand;
    private Long shopId;
    private List<Spec> specList;
}
