package com.example.travelguideservice.dto.pet;

import com.example.travelguideservice.model.pet.PetStatus;
import lombok.Data;

import java.util.List;

@Data
public class PetDto {

    private Long id;
    private CategoryDto category;
    private String name;
    private List<String> photoUrl;
    private List<TagDto> tags;
    private PetStatus status;

}
