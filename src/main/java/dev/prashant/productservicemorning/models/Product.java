package dev.prashant.productservicemorning.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Product {

    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private Category category;

}
