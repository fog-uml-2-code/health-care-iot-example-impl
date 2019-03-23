package healthcare.sensors;

// Start of user code for imports
import java.util.*;
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


	@Override
	public int getBatteryLevel() {
		// ToDo: Implement this method.
		throw new UnsupportedOperationException("This method is not yet implemented");
	}
	
	@Override
	public BloodSugarLevel measureBloodSugar() {
		// ToDo: Implement this method.
		throw new UnsupportedOperationException("This method is not yet implemented");
	}
	

}
