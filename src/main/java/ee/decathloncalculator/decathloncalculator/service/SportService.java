package ee.decathloncalculator.decathloncalculator.service;

import ee.decathloncalculator.decathloncalculator.model.Sport;
import ee.decathloncalculator.decathloncalculator.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportService {

    private final SportRepository sportRepository;

    @Autowired
    public SportService(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    public Iterable<Sport> getAllSports() {
        return sportRepository.findAll();
    }
}
