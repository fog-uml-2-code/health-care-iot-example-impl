package healthcare.treatment;

// Start of user code for imports
import java.util.*;
import pusztai.thomas.architecture.fog.validation.*;
import healthcare.treatment.constraints.*;

import healthcare.models.BasalRate;
import healthcare.models.Bolus;
import healthcare.models.InsulinPumpState;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import healthcare.treatment.constraints.*;
// End of user code

/**
 * This is the base REST interface for InsulinPump.
 * 
 * @generated
 */
public interface InsulinPump {

	/**
	 * Documentation of the method setCurrentTime.
	 * 
	 * @param timestamp
	 * 
	 * @generated
	 */
	@Post("/setcurrenttime")
	void setCurrentTime(int timestamp);
	
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
	 * Documentation of the method getCurrentState.
	 * 
	 * @return
	 * 
	 * @generated
	 */
	@Get("/getcurrentstate")
	InsulinPumpState getCurrentState();
	
	/**
	 * Documentation of the method adjustBasalRate.
	 * 
	 * @param rate
	 * 
	 * @generated
	 */
	@Post("/adjustbasalrate")
	@PreCondition(PreAdjustBasalRate.class)
	void adjustBasalRate(BasalRate rate);
	
	/**
	 * Documentation of the method startBolus.
	 * 
	 * @param bolus
	 * 
	 * @generated
	 */
	@Post("/startbolus")
	@PreCondition(PreStartBolus.class)
	void startBolus(Bolus bolus);
	
}
