package healthcare.sensors;

// Start of user code for imports
import java.util.*;
import pusztai.thomas.architecture.fog.validation.*;



import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

// End of user code

/**
 * This is the base REST interface for HeartRateSensor.
 * 
 * @generated
 */
public interface HeartRateSensor {

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
	 * Documentation of the method getHeartRate.
	 * 
	 * @return
	 * 
	 * @generated
	 */
	@Get("/getheartrate")
	int getHeartRate();
	
}
