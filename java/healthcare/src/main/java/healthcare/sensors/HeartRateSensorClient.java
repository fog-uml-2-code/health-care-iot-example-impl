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
@Client("heartratesensor")
public interface HeartRateSensorClient extends HeartRateSensor {

	@Override
	int getBatteryLevel();
	
	@Override
	int getHeartRate();
	
}
