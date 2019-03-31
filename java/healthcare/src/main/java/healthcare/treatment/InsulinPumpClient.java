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
@Client("${micronaut.http.services.insulinpump.urls}")
public interface InsulinPumpClient extends InsulinPump {

	@Override
	void setCurrentTime(Integer timestamp);
	
	@Override
	@PreCondition(PreStartBolus.class)
	void startBolus(Bolus bolus);
	
	@Override
	InsulinPumpState getCurrentState();
	
	@Override
	@PreCondition(PreAdjustBasalRate.class)
	void adjustBasalRate(BasalRate rate);
	
	@Override
	Integer getBatteryLevel();
	
}
