package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;

import java.util.List;

public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);

    void deleteById(Long id);

    void save(String name, String description, Manufacturer manufacturer);

    void edit(Long id, String name, String description, Manufacturer manufacturer);

    Balloon findById(Long id);
}
