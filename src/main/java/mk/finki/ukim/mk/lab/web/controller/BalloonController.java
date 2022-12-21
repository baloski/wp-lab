package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.service.BalloonService;
import mk.finki.ukim.mk.lab.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = {"/balloons"})
public class BalloonController {

    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }


    @GetMapping
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model) {
        List<Balloon> balloons = this.balloonService.listAll();
        model.addAttribute("balloons", balloons);
        model.addAttribute("bodyContent", "balloons");

        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
            return "listBalloons";
        }
        return "listBalloons";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditBalloonPage(@PathVariable Long id, Model model)
    {
        if (this.balloonService.findById(id)!=null)
        {
            Balloon balloon = this.balloonService.findById(id);
            List<Manufacturer> manufacturers = this.manufacturerService.findAll();

            model.addAttribute("balloon", balloon);
            model.addAttribute("manufacturers", manufacturers);
            model.addAttribute("bodyContent", "add-balloon");
            return "add-balloon";
        }
        return "redirect:/balloons?error=THE BALLOON YOU ARE TRYING TO ACCESS IS NOT AVAILABLE";
    }

    @GetMapping("/add-form")
    public String getAddBalloonPage(Model model)
    {
        List<Manufacturer> manufacturers = this.manufacturerService.findAll();
        model.addAttribute("manufacturers", manufacturers);
        model.addAttribute("bodyContent", "add-balloon");

        return "add-balloon";
    }

    @PostMapping("/add")
    public String saveBalloon(@RequestParam(required = false) Long idBalloon,
                              @RequestParam String name,
                              @RequestParam String description,
                              @RequestParam Long idManufacturer)
    {
        if(idBalloon!=null)
        {
            Manufacturer manufacturer = manufacturerService.findAll().stream().filter(r->r.getId().equals(idManufacturer)).findFirst().orElse(null);
            this.balloonService.edit(idBalloon, name, description, manufacturer);
        }
        else
        {
            Manufacturer manufacturer = manufacturerService.findAll().stream().filter(r->r.getId().equals(idManufacturer)).findFirst().orElse(null);
            this.balloonService.save(name, description, manufacturer);
        }
        return "redirect:/balloons";
    }

    @PostMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id) {
        this.balloonService.deleteById(id);
        return "redirect:/balloons";
    }
}