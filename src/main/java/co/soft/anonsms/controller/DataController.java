package co.soft.anonsms.controller;

import co.soft.anonsms.service.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DataController {

    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/all_data")
    public String allData(Model model) {

        model.addAttribute("allData", dataService.allData());

        return "allData";
    }

    @GetMapping("/delete/{id}")
    public String deleteData(@PathVariable Long id) {

        dataService.deleteData(id);

        return "redirect:/all_data";
    }
}
