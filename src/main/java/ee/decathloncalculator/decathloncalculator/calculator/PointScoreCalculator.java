package ee.decathloncalculator.decathloncalculator.calculator;

import ee.decathloncalculator.decathloncalculator.model.Sport;

public class PointScoreCalculator {

    public Long getPoints(Sport sport, Float result) {
        double calculatedPoints = 0;

        switch (sport.getCategory()) {
            case "running":
            case "throwing":
                calculatedPoints = sport.getCoefficientA()
                        * Math.pow(Math.abs(result - sport.getCoefficientB()), sport.getCoefficientC());
                break;
            case "jumping":
                float resultInCM = 100 * result;
                calculatedPoints = sport.getCoefficientA()
                        * Math.pow(Math.abs(resultInCM - sport.getCoefficientB()), sport.getCoefficientC());
                break;
            default:
                break;
        }

        return Math.round(calculatedPoints);
    }
}
