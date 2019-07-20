package ee.decathloncalculator.decathloncalculator.repository;

import ee.decathloncalculator.decathloncalculator.model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepository extends JpaRepository<Sport, Integer> {
}
