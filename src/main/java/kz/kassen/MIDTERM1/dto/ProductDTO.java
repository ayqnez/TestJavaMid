package kz.kassen.MIDTERM1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String nameDTO;
    private String descriptionDTO;
    private Integer priceDTO;
    private Boolean inStockDTO;
}
