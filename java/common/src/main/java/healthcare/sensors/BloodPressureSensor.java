package healthcare.sensors;

// Start of user code for imports
import java.util.*;
import pusztai.thomas.architecture.fog.validation.*;


import healthcare.models.BloodPressure;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

// End of user code

/**
 * This is the base REST interface for BloodPressureSensor.
 * 
 * @generated
 */
public interface BloodPressureSensor {

	/**
	 * Documentation of the method getBatteryLevel.
	 * 
	 * @return
	 * 
	 * @generated
	 */
	@Get("/getbatterylevel")
	int getBatteryLevel();
	
	/**
	 * Documentation of the method measureBloodPressure.
	 * 
	 * @return
	 * 
	 * @generated
	 */
	@Get("/measurebloodpressure")
	BloodPressure measureBloodPressure();
	
}
