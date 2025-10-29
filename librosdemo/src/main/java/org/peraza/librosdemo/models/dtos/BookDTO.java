package org.peraza.librosdemo.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDTO {
    private String title;
    private String summary;
    private Float price;
    private String state;
    private String image;
}
