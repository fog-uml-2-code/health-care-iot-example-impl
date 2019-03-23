package healthcare.sensors;

// Start of user code for imports
import java.util.*;
import pusztai.thomas.architecture.fog.validation.*;


import healthcare.models.BodyTemperature;

import io.micronaut.http.client.annotation.Client;
// End of user code

/**
 * This is the client REST interface for TemperatureSensor.
 * 
 * @generated
 */
@Client("temperaturesensor")
public interface TemperatureSensorClient extends TemperatureSensor {

	@Override
	int getBatteryLevel();
	
	@Override
	BodyTemperature measureTemperature();
	
}
