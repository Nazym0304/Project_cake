package kz.kaznitu.nazym.cake_soj.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

public class SalesController {
    @RequestMapping(path = "/sales")
    public String sales(){
        return "sales" ;
    }
}
