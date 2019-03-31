package healthcare.treatment;

// Start of user code for imports
import java.util.*;
import pusztai.thomas.architecture.fog.validation.*;
import healthcare.treatment.constraints.*;

import healthcare.models.BasalRate;
import healthcare.models.Bolus;
import healthcare.models.InsulinPumpState;

import healthcare.treatment.InsulinPump;
import io.micronaut.http.annotation.Controller;
// End of user code

/**
 * This is the REST controller for InsulinPump.
 * 
 * @generated
 */
@Controller("/insulinpump")
public class InsulinPumpController implements InsulinPump {


	@Override
	public void setCurrentTime(Integer timestamp) {
		// ToDo: Implement this method.
		throw new UnsupportedOperationException("This method is not yet implemented");
	}
	
	@Override
	@PreCondition(PreStartBolus.class)
	public void startBolus(Bolus bolus) {
		// ToDo: Implement this method.
		throw new UnsupportedOperationException("This method is not yet implemented");
	}
	
	@Override
	public InsulinPumpState getCurrentState() {
		// ToDo: Implement this method.
		throw new UnsupportedOperationException("This method is not yet implemented");
	}
	
	@Override
	@PreCondition(PreAdjustBasalRate.class)
	public void adjustBasalRate(BasalRate rate) {
		// ToDo: Implement this method.
		throw new UnsupportedOperationException("This method is not yet implemented");
	}
	
	@Override
	public Integer getBatteryLevel() {
		// ToDo: Implement this method.
		throw new UnsupportedOperationException("This method is not yet implemented");
	}
	

}
