package es.cabsa.javadevelopers.dao;

import es.cabsa.javadevelopers.es.cabsa.javadevelopers.dto.AnimalDTO;

import java.util.ArrayList;
import java.util.List;

public class JungleDaoImplementation implements JungleDao {
    public List<AnimalDTO> findAnimalByTypeOfFood(String animalEatsName, List<AnimalDTO> animalList) {
        List<AnimalDTO> animalsByName = new ArrayList<>();
        for ( AnimalDTO animal : animalList){
            if(animal.getEats_name().toLowerCase().contains(animalEatsName.toLowerCase())) {
                animalsByName.add(animal);
            }
        }
        return animalsByName;
    }

    public List<AnimalDTO> findAnimalByName(String animalName, List<AnimalDTO> animalList) {
        List<AnimalDTO> animalsByName = new ArrayList<>();
        for ( AnimalDTO animal : animalList){
            if(animal.getName().toLowerCase().contains(animalName.toLowerCase()))
                animalsByName.add(animal);
        }
        return animalsByName;
    }
}
