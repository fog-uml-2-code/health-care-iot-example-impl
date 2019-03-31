package healthcare.sensors;

// Start of user code for imports
import java.util.*;
import pusztai.thomas.architecture.fog.validation.*;


import healthcare.models.BloodPressure;

import io.micronaut.http.client.annotation.Client;
// End of user code

/**
 * This is the client REST interface for BloodPressureSensor.
 * 
 * @generated
 */
@Client("bloodpressuresensor")
public interface BloodPressureSensorClient extends BloodPressureSensor {

	@Override
	BloodPressure measureBloodPressure();
	
	@Override
	Integer getBatteryLevel();
	
}
