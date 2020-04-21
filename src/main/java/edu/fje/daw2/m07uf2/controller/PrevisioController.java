package edu.fje.daw2.m07uf2.controller;

import edu.fje.daw2.m07uf2.PrevisioRepositori;
import edu.fje.daw2.m07uf2.model.Previsio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador de Previsios
 * Verifica el funcionament de curl
 * @author sergi.grau@fje.edu
 * @version 1.0 02.4.20
 */
@Controller
@SessionAttributes("Previsios")
public class PrevisioController {

    @Autowired
    private PrevisioRepositori repositori;

    @ModelAttribute("Previsios")
    public List<Previsio> inicialitzar() {

        List<Previsio> Previsios = new ArrayList<>();
        for (Previsio c : repositori.findAll()) {
            Previsios.add(c);
        }
        return Previsios;
    }



    @RequestMapping(value={"/Previsio", "/usuari"})
    String mostrarFormulari() {
        return("formulari");
    }

    @RequestMapping(value="/desarPrevisio", method = RequestMethod.POST)
    String desarPrevisio(@SessionAttribute("Previsios") List<Previsio> Previsios,
                         @RequestParam (defaultValue = "") String nom,
                         @RequestParam (defaultValue = "") String cognom,
                         @RequestParam (defaultValue = "") int volumCompres,
                         ModelMap model){
        Previsio c = new Previsio(nom, cognom, volumCompres);
        repositori.save(c);

        if(!model.containsAttribute("Previsios")) {
            model.addAttribute("Previsios", Previsios);
        }
        Previsios.add(c);


        return("llistaPrevisios");
    }

    @RequestMapping(value="/esborrarPrevisio", method = RequestMethod.GET)
    String esborrarPrevisio(@SessionAttribute("Previsios") List<Previsio> Previsios,
                            @RequestParam (defaultValue = "") String id){

        System.out.println(id);

        repositori.deleteById(id);
        Previsio t = new Previsio();
        t.setId(id);
        Previsios.remove(0);

        return("llistaPrevisios");
    }

}
