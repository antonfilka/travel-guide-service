package com.example.travelguideservice.controller.pet;

import java.util.HashMap;
import java.util.Map;

import com.example.travelguideservice.dto.pet.PetDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestController
@RequestMapping("/v2/pet")

public class PetController {

    private Map<Long, PetDto> pets = new HashMap<>();

    @PostMapping (consumes = "application/json", produces = "application/json")
    public ResponseEntity addPet (@RequestBody PetDto pet){

        long latestId = pets.size();
        pet.setId(latestId);
        pets.put(latestId, pet);

        return ResponseEntity.ok(pet);
    }

    @PutMapping (consumes = "application/json")
    public ResponseEntity updatePet(@RequestBody PetDto pet){
        pets.put(pet.getId(), pet);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{petId}", produces = "application/json")
    public ResponseEntity deletePet(@PathVariable Long petId){
        PetDto pet = pets.remove(petId);
        return ResponseEntity.ok(pet);
    }

    @GetMapping (value = "{petId}", produces = "application/json")
    public ResponseEntity getPetById(@PathVariable Long petID){
        PetDto pet = pets.get(petID);
        return ResponseEntity.ok(pet);
    }


}
