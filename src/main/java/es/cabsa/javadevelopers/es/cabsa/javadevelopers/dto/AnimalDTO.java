package es.cabsa.javadevelopers.es.cabsa.javadevelopers.dto;

public class AnimalDTO {
    private final int id;

    private String name;

    private int legs;

    private int eats;

    private String eats_name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public int getEats() {
        return eats;
    }

    public void setEats(int eats) {
        this.eats = eats;
    }

    public AnimalDTO(int id, String name, int legs, int eats, String eats_name){
        this.id = id;
        this.name = name;
        this.legs = legs;
        this.eats = eats;
        this.eats_name = eats_name;
    }

    @Override
    public String toString() {
        return "AnimalDTO [id=" + id
                + ", name=" + name
                + ", legs=" + legs
                + ", eats=" + eats
                + ", eats_name=" + eats_name
                + "]";
    }

    public String getEats_name() {
        return eats_name;
    }

    public void setEats_name(String eats_name) {
        this.eats_name = eats_name;
    }
}
