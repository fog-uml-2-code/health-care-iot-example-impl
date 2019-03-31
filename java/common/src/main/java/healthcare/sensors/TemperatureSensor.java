package healthcare.sensors;

// Start of user code for imports
import java.util.*;
import pusztai.thomas.architecture.fog.validation.*;


import healthcare.models.BodyTemperature;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

// End of user code

/**
 * This is the base REST interface for TemperatureSensor.
 * 
 * @generated
 */
public interface TemperatureSensor {

	/**
	 * Documentation of the method measureTemperature.
	 * 
	 * @return
	 * 
	 * @generated
	 */
	@Get("/measuretemperature")
	BodyTemperature measureTemperature();
	
	/**
	 * Documentation of the method getBatteryLevel.
	 * 
	 * @return
	 * 
	 * @generated
	 */
	@Get("/getbatterylevel")
	Integer getBatteryLevel();
	
}
