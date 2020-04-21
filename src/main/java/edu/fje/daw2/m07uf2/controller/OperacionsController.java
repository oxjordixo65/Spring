package edu.fje.daw2.m07uf2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Classe Controladora principal
 * Verifica el funcionament de curl
 * @author sergi.grau@fje.edu
 * @version 1.0 02.4.20
 */
@Controller
@SessionAttributes("total")
public class OperacionsController {

    @ModelAttribute("total")
    public int inicialitzar() {
        return 0;
    }


    @RequestMapping("/sumaForm")
    String mostrarFormulari() {
        return("formulari");
    }

    @RequestMapping(value="/sumaRes", method = RequestMethod.GET)

    String mostrarResultats(@SessionAttribute("total") int total,
                            @RequestParam (defaultValue = "0") String n1,
                            @RequestParam (defaultValue = "0") String n2,
                            ModelMap model) {
        System.out.println(n1);
        int suma = Integer.parseInt(n1)+Integer.parseInt(n2);
        total+=suma;

        //podem afegir JSON, String, Array, Map, List, etc...
        model.addAttribute("suma", suma);
        model.addAttribute("total", total);


        return("resultats");
    }

    //curl -X POST -F 'nom=abc' -F 'id=123' http://localhost:8080/api/foos
    @PostMapping("/api/foos")
    @ResponseBody
    public String mapejarParams(@RequestParam Map<String,String> allParams) {
        return "Els paràmetres són" + allParams.entrySet();
    }

    //http://localhost:8080/api/foos?id=1,2,3
    @GetMapping("/api/foos")
    @ResponseBody
    public String getFoos(@RequestParam List<String> id) {
        return "IDs són " + id;
    }
}
