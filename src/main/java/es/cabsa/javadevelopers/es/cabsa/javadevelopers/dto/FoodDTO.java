package es.cabsa.javadevelopers.es.cabsa.javadevelopers.dto;

public class FoodDTO {

    private final int id;

    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FoodDTO(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "FoodDTO [id=" + id + ", name=" + name + "]";
    }

}
