package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class UserOrdersController {

    private List<String> client_names;
    private List<String> delivery_addresses;
    private List<String> balloon_colors;
    private List<String> balloon_sizes;
    private final ManufacturerService manufacturerService;

    public UserOrdersController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
        client_names = new ArrayList<>();
        delivery_addresses = new ArrayList<>();
        balloon_colors = new ArrayList<>();
        balloon_sizes = new ArrayList<>();
    }

    @PostMapping
    public String getUserOrder(@RequestParam(required = false) String error, HttpServletRequest req, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        String client_name = req.getParameter("client_name");
        String delivery_address = req.getParameter("delivery_address");
        String balloon_color = req.getParameter("balloon_color");
        String balloon_size = req.getParameter("balloon_size");

        client_names.add(client_name);
        delivery_addresses.add(delivery_address);
        balloon_colors.add(balloon_color);
        balloon_sizes.add(balloon_size);

        //model.addAttribute("balloon", balloon);
        model.addAttribute("client_names", client_names);
        model.addAttribute("delivery_addresses", delivery_addresses);
        model.addAttribute("balloon_colors", balloon_colors);
        model.addAttribute("balloon_sizes", balloon_sizes);
        return "userOrders";
    }
}