package ee.decathloncalculator.decathloncalculator.service;

import ee.decathloncalculator.decathloncalculator.calculator.PointScoreCalculator;
import ee.decathloncalculator.decathloncalculator.model.PointScore;
import ee.decathloncalculator.decathloncalculator.model.Sport;
import ee.decathloncalculator.decathloncalculator.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PointScoreService {

    private final SportRepository sportRepository;

    @Autowired
    public PointScoreService(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    public PointScore getPointScore(PointScore pointScore) {
        Optional<Sport> sport = sportRepository.findById(pointScore.getSport().getId());

        if (sport.isPresent()) {
            PointScoreCalculator pointScoreCalculator = new PointScoreCalculator();
            Long points = pointScoreCalculator.getPoints(sport.get(), pointScore.getResult());

            pointScore.setSport(sport.get());
            pointScore.setPoints(points);

            return pointScore;
        } else {
            return null;
        }
    }
}
