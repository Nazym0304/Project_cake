package kz.kaznitu.nazym.cake_soj.controllers;




import kz.kaznitu.nazym.cake_soj.models.Client;
import kz.kaznitu.nazym.cake_soj.repositories.CakeRepository;
import kz.kaznitu.nazym.cake_soj.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

import java.util.List;

@Controller
@RequestMapping(path = "/demo")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    private int a;

    @RequestMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("client", new Client());
        return "client_add_form";
    }

    @PostMapping("/add")
    public String addClient(@ModelAttribute Client client) {
        clientRepository.save(client);
        return "redirect:/demo/all2";
    }

    @GetMapping("/all")
    public @ResponseBody
    Iterable<Client> allClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/all2")
    public String allClients2(Model model) {
        List<Client> clients = (List<Client>) clientRepository.findAll();
        model.addAttribute("clients", clients);
        return "clients";
    }

    @RequestMapping(value = "/deleteClient", method = RequestMethod.GET)
    public ModelAndView deleteClient(@RequestParam("id") int idd) {
        clientRepository.deleteById(idd);
        return new ModelAndView("redirect:/demo/all2");
    }

}