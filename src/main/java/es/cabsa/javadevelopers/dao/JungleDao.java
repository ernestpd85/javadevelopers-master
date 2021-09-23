package es.cabsa.javadevelopers.dao;

import es.cabsa.javadevelopers.es.cabsa.javadevelopers.dto.AnimalDTO;

import java.util.List;

public interface JungleDao {
    public List<AnimalDTO> findAnimalByTypeOfFood(String animalEatsName, List<AnimalDTO> animalList);

    public List<AnimalDTO> findAnimalByName(String animalName, List<AnimalDTO> animalList);
}


