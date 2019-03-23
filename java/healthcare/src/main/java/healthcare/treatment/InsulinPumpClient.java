package healthcare.treatment;

// Start of user code for imports
import java.util.*;
import pusztai.thomas.architecture.fog.validation.*;
import healthcare.treatment.constraints.*;

import healthcare.models.BasalRate;
import healthcare.models.Bolus;
import healthcare.models.InsulinPumpState;

import io.micronaut.http.client.annotation.Client;
// End of user code

/**
 * This is the client REST interface for InsulinPump.
 * 
 * @generated
 */
@Client("insulinpump")
public interface InsulinPumpClient extends InsulinPump {

	@Override
	void setCurrentTime(int timestamp);
	
	@Override
	int getBatteryLevel();
	
	@Override
	InsulinPumpState getCurrentState();
	
	@Override
	@PreCondition(PreAdjustBasalRate.class)
	void adjustBasalRate(BasalRate rate);
	
	@Override
	@PreCondition(PreStartBolus.class)
	void startBolus(Bolus bolus);
	
}