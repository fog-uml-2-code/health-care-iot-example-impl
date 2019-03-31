package healthcare.sensors;

// Start of user code for imports
import java.util.*;
import pusztai.thomas.architecture.fog.validation.*;


import healthcare.models.BloodSugarLevel;

import io.micronaut.http.client.annotation.Client;
// End of user code

/**
 * This is the client REST interface for BloodSugarSensor.
 * 
 * @generated
 */
@Client("bloodsugarsensor")
public interface BloodSugarSensorClient extends BloodSugarSensor {

	@Override
	BloodSugarLevel measureBloodSugar();
	
	@Override
	Integer getBatteryLevel();
	
}
