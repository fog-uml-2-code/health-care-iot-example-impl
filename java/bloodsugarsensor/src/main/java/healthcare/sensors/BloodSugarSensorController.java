package healthcare.sensors;

// Start of user code for imports
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pusztai.thomas.architecture.fog.validation.*;


import healthcare.models.BloodSugarLevel;

import healthcare.sensors.BloodSugarSensor;
import io.micronaut.http.annotation.Controller;
// End of user code

/**
 * This is the REST controller for BloodSugarSensor.
 * 
 * @generated
 */
@Controller("/bloodsugarsensor")
public class BloodSugarSensorController implements BloodSugarSensor {

	private static final Logger LOG = LoggerFactory.getLogger(BloodSugarSensorController.class);
	private static final double MIN_BLOOD_SUGAR = 2.5;
	private static final double MAX_BLOOD_SUGAR = 10.5;

	private final Random random = new Random();

	@Override
	public BloodSugarLevel measureBloodSugar() {
		BloodSugarLevel bloodSugar = new BloodSugarLevel();
		double r = random.nextDouble();
		double mmolPerLiter = r * (MAX_BLOOD_SUGAR - MIN_BLOOD_SUGAR) + MIN_BLOOD_SUGAR;
		bloodSugar.setMmolPerLiter(mmolPerLiter);
		LOG.info("measureBloodSugar() = {}", mmolPerLiter);
		return bloodSugar;
	}
	
	@Override
	public Integer getBatteryLevel() {
		LOG.info("getBatteryLevel() = 80");
		return 80;
	}
	

}
