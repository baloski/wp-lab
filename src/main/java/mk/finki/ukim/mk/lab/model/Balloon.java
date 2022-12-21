package mk.finki.ukim.mk.lab.model;


import lombok.Data;

@Data
public class Balloon {
    String name;
    String description;

    private Long id;

    Manufacturer manufacturer;


    public Balloon(String name, String description, Manufacturer manufacturer){
        this.name = name;
        this.description = description;
        this.id=(long)(Math.random()*1000);
        this.manufacturer=manufacturer;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
