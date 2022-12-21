package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ManufacturerRepository {

    List<Manufacturer> manufacturers = new ArrayList<>();

    @PostConstruct
    public void init()
    {
        manufacturers.add(new Manufacturer("Manufacturer 1", "Germany", "st 1, 1"));
        manufacturers.add(new Manufacturer("Manufacturer 2", "Poland", "st 2, 2"));
        manufacturers.add(new Manufacturer("Manufacturer 3", "China", "st 3, 3"));
        manufacturers.add(new Manufacturer("Manufacturer 4", "USA", "st 4, 4"));
        manufacturers.add(new Manufacturer("Manufacturer 5", "Spain", "st 4, 4"));
    }

    public List<Manufacturer> findAll()
    {
        return manufacturers;
    }
}
