package mk.finki.ukim.mk.lab.service.ServiceImpl;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.repository.BalloonRepository;
import mk.finki.ukim.mk.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalloonServiceImpl implements BalloonService {
    private final BalloonRepository balloonrepository;

    public BalloonServiceImpl(BalloonRepository balloonRepository) {

        this.balloonrepository = balloonRepository;
    }

    @Override
    public List<Balloon> listAll() {

        return this.balloonrepository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return this.balloonrepository.searchByNameOrDescription(text);
    }
    @Override
    public void deleteById(Long id) {
        this.balloonrepository.deleteById(id);
    }

    @Override
    public void save(String name, String description, Manufacturer manufacturer)
    {
        Balloon balloon = new Balloon(name, description, manufacturer);
        this.balloonrepository.save(balloon);
    }

    @Override
    public void edit(Long id, String name, String description, Manufacturer manufacturer) {
        Balloon balloon = this.balloonrepository.findById(id);
        balloon.setName(name);
        balloon.setDescription(description);
        balloon.setManufacturer(manufacturer);
        this.balloonrepository.save(balloon);
    }

    @Override
    public Balloon findById(Long id) {
        return this.balloonrepository.findById(id);
    }
}

