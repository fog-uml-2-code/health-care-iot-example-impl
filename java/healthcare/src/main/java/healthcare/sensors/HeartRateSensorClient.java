package healthcare.sensors;

// Start of user code for imports
import java.util.*;
import pusztai.thomas.architecture.fog.validation.*;



import io.micronaut.http.client.annotation.Client;
// End of user code

/**
 * This is the client REST interface for HeartRateSensor.
 * 
 * @generated
 */
@Client("${micronaut.http.services.heartratesensor.urls}")
public interface HeartRateSensorClient extends HeartRateSensor {

	@Override
	Integer getHeartRate();
	
	@Override
	Integer getBatteryLevel();
	
}
