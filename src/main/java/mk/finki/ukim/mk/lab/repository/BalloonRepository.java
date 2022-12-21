package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BalloonRepository {
    List<Balloon> balloonList = new ArrayList<>();

    @PostConstruct
    public void init() {
        this.balloonList.add(new Balloon("Balloon 1", "Balloon 1",
                new Manufacturer("Manufacturer 1", "Germany", "st 1, 1")));
        this.balloonList.add(new Balloon("Balloon 2", "Balloon 2",
                new Manufacturer("Manufacturer 2", "Spain", "st 1, 1")));
        this.balloonList.add(new Balloon("Balloon 3", "Balloon 3",
                new Manufacturer("Manufacturer 3", "Poland", "st 2, 2")));
        this.balloonList.add(new Balloon("Balloon 4", "Balloon 4",
                new Manufacturer("Manufacturer 4", "USA", "st 2, 2")));
        this.balloonList.add(new Balloon("Balloon 5", "Balloon 5",
                new Manufacturer("Manufacturer 5", "China", "st 3, 3")));

    }

    public List<Balloon> findAllBalloons(){

        return this.balloonList;
    }
    public List<Balloon> searchByNameOrDescription(String text){
        return this.balloonList.stream().filter(r->r.getName().contains(text) || r.getDescription().contains(text)).collect(Collectors.toList());
    }
    public void deleteById(Long Id)
    {
        this.balloonList.removeIf(r -> r.getId().equals(Id));
    }

    public void save(Balloon balloon) {

        this.balloonList.add(balloon);
    }

    public Balloon findById(Long id) {
        return this.balloonList.stream().filter(r->r.getId().equals(id)).findFirst().orElse(null);
    }
}
