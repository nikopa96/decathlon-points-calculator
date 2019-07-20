package ee.decathloncalculator.decathloncalculator.controller;

import ee.decathloncalculator.decathloncalculator.model.PointScore;
import ee.decathloncalculator.decathloncalculator.service.PointScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "pointScore")
public class PointScoreController {

    private final PointScoreService pointScoreService;

    @Autowired
    public PointScoreController(PointScoreService pointScoreService) {
        this.pointScoreService = pointScoreService;
    }

    @PostMapping(path = "getPoints")
    @CrossOrigin
    public PointScore getPointScore(@RequestBody @Valid PointScore pointScore) {
        return pointScoreService.getPointScore(pointScore);
    }
}
