package es.cabsa.javadevelopers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import es.cabsa.javadevelopers.controller.Constants;
import es.cabsa.javadevelopers.controller.JungleController;
import es.cabsa.javadevelopers.es.cabsa.javadevelopers.dto.AnimalDTO;
import es.cabsa.javadevelopers.es.cabsa.javadevelopers.dto.FoodDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@SpringBootApplication
public class Application {

  public static void main(String[] args) throws IOException {
    ApplicationContext ctx = SpringApplication.run(Application.class, args);

    System.out.println("Animals in the jungle:");

    String[] beanNames = ctx.getBeanDefinitionNames();
    Arrays.sort(beanNames);
    for (String beanName : beanNames) {
      System.out.println(beanName);
    }

    JungleController.importJsonData();


  }


}
