package kz.kaznitu.nazym.cake_soj.controllers;

import kz.kaznitu.nazym.cake_soj.models.Cake;
import kz.kaznitu.nazym.cake_soj.repositories.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/cake")
public class CakeController {
    @Autowired
    private CakeRepository cakeRepository;
    private int a;

    @GetMapping("/all")
    public @ResponseBody
    Iterable<Cake> allCakes() {
        return cakeRepository.findAll();
    }

    @GetMapping("/all2")
    public String allBooks2(Model model) {
        List<Cake> cake = (List<Cake>) cakeRepository.findAll();
        model.addAttribute("cake", cake);
        return "cake";
    }

    @RequestMapping("/add")
    public String cakeForm(Model model) {
        model.addAttribute("cake", new Cake());
        return "cake_add_form";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Cake cake) {
        cakeRepository.save(cake);
        return "redirect:/cake/all2";
    }

    @RequestMapping(value = "/deleteCake",method = RequestMethod.GET)
    public ModelAndView deleteCake(@RequestParam("id") int idd){
        cakeRepository.deleteById(idd);
        return new ModelAndView("redirect:/book/all2");
    }

}