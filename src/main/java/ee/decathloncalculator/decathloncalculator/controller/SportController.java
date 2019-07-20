package ee.decathloncalculator.decathloncalculator.controller;

import ee.decathloncalculator.decathloncalculator.model.Sport;
import ee.decathloncalculator.decathloncalculator.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "sport")
public class SportController {

    private final SportService sportService;

    @Autowired
    public SportController(SportService sportService) {
        this.sportService = sportService;
    }

    @GetMapping(path = "/getAll")
    @CrossOrigin
    public Iterable<Sport> getAllSports() {
        return sportService.getAllSports();
    }
}
