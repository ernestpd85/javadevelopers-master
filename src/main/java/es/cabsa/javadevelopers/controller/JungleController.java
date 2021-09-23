package es.cabsa.javadevelopers.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import es.cabsa.javadevelopers.dao.JungleDao;
import es.cabsa.javadevelopers.dao.JungleDaoImplementation;
import es.cabsa.javadevelopers.es.cabsa.javadevelopers.dto.AnimalDTO;
import es.cabsa.javadevelopers.es.cabsa.javadevelopers.dto.FoodDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

@RestController
public class JungleController {

  public static void importJsonData() throws IOException {
    GsonBuilder builder = new GsonBuilder();
    builder.serializeNulls();
    Gson gson = builder.create();

    JungleDao jungleDao = new JungleDaoImplementation();
    JungleDaoImplementation jungleDaoImplementation = new JungleDaoImplementation();

    //we are about to parse and import the animals from JSON to an Array
    JsonObject jsonObject = gson.fromJson(Constants.jsonString, JsonObject.class);
    List<AnimalDTO> animalList = importJsonDataAnimal(gson, jsonObject);

    //we are about to parse and import the food from JSON to an Array
    List<FoodDTO> foodList = importJsonDataFood(gson, jsonObject);

    // we are processing manually the attribute eats_name - this should be made at DB layer (or Hibernate)
    animalList = processAnimalsTypeFood(animalList, foodList);
    System.out.println("Animal List: "+animalList+"\n");

    //Find animals by name ( we will use contais so "S" fill return Snake and Spider)
    //Enter data using Console
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Please introduce the name of the animal to find: ");
    System.out.println("**You could also type characters or part that contain the name to find");
    String inputAnimalName = reader.readLine();

    List<AnimalDTO> animalsByName = jungleDao.findAnimalByName ( inputAnimalName, animalList);
    System.out.println("Animals By Name:" + animalsByName);

    // we ask again the user to introduce the food type
    System.out.println("Please introduce the type of food that an animal eats to find  - or some part that contains the name: ");
    System.out.println("**You could also type characters or part that contain the name to find");
    String inputAnimalTypeOfFood = reader.readLine();
    animalsByName = jungleDao.findAnimalByTypeOfFood ( inputAnimalTypeOfFood, animalList);
    System.out.println("Animals By Type Of Food:" + animalsByName);
  }

  private static List<FoodDTO> importJsonDataFood(Gson gson, JsonObject jsonObject) {
    JsonArray foodJsonArray = jsonObject.get("food").getAsJsonArray();
    System.out.println("Food List: \n"+foodJsonArray.toString()+"\n");

    Type listType = new TypeToken<List<FoodDTO>>() {}.getType();
    return gson.fromJson(foodJsonArray , listType);
  }

  private static List<AnimalDTO> importJsonDataAnimal(Gson gson, JsonObject jsonObject) {

    JsonArray animalJsonArray = jsonObject.get("animal").getAsJsonArray();
    Type listType = new TypeToken<List<AnimalDTO>>() {}.getType();
    return gson.fromJson(animalJsonArray , listType);
  }

  private static List<AnimalDTO> processAnimalsTypeFood(List<AnimalDTO> animalList, List<FoodDTO> foodList) {
    List<AnimalDTO> animalsByName;
    for ( AnimalDTO animal : animalList){
      if(animal.getEats_name() == null || !animal.getEats_name().isEmpty()){
        animal.setEats_name(foodList.get(animal.getEats()).getName());
      }
    }
    return animalList;
  }



  @RequestMapping("/")
  public String index() {
    return "Wellcome to the Jungle!";
  }

}
