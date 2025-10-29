package org.peraza.librosdemo.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BooknGenreDTO {
    private String title;
    private String summary;
    private Float price;
    private String state;
    private String image;
    private String genre;
}
