package kz.kassen.MIDTERM1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private UserDTO userDTO;
    private List<ProductDTO> productsDTO;
}
