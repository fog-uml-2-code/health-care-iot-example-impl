package healthcare.treatment;

// Start of user code for imports
import java.time.Duration;
import java.time.Instant;
import java.util.*;

import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.TaskScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pusztai.thomas.architecture.fog.validation.*;
import healthcare.treatment.constraints.*;

import healthcare.models.BasalRate;
import healthcare.models.Bolus;
import healthcare.models.InsulinPumpState;

import healthcare.treatment.InsulinPump;
import io.micronaut.http.annotation.Controller;

import javax.inject.Named;
// End of user code

/**
 * This is the REST controller for InsulinPump.
 * 
 * @generated
 */
@Controller("/insulinpump")
public class InsulinPumpController implements InsulinPump {

	private static final Logger LOG = LoggerFactory.getLogger(InsulinPumpController.class);

	private InsulinPumpState currState;
	private final TaskScheduler taskScheduler;

	public InsulinPumpController(@Named(TaskExecutors.SCHEDULED) TaskScheduler taskScheduler) {
		this.taskScheduler = taskScheduler;
		currState = new InsulinPumpState();
		currState.setCurrentTime((int) Instant.now().getEpochSecond());
		currState.setTimeLastBolusEnded(0);
		currState.setInsulinUnitsAdministeredLast24Hours(0);
		currState.setInsulinUnitsAdministeredLastHour(0);
		TreatmentPlan plan = new TreatmentPlan();
		BasalRate defaultRate = new BasalRate();
		defaultRate.setInsulinUnitsPerHour(2);
		plan.setBasalRate(defaultRate);
		plan.setMaxHourlyBasalRate(7);
		plan.setMaxInsulinUnitsPerDay(100);
		plan.setMaxInsulinUnitsPerHour(20);
		plan.setMaxUnitsPerBolus(15);
		plan.setMinHourlyBasalRate(1);
		currState.setTreatmentPlan(plan);
	}

	@Override
	public void setCurrentTime(Integer timestamp) {
		LOG.info("setCurrentTime({})", timestamp);
		if (currState != null) {
			currState.setCurrentTime(timestamp);
		}
	}
	
	@Override
	@PreCondition(PreStartBolus.class)
	public void startBolus(Bolus bolus) {
		LOG.info("startBolus({} units, {} minutes)", bolus.getInsulinUnits(), bolus.getDurationMinutes());
		currState.setBolus(bolus);
		currState.setInsulinUnitsAdministeredLast24Hours(currState.getInsulinUnitsAdministeredLast24Hours() + bolus.getInsulinUnits());
		currState.setInsulinUnitsAdministeredLastHour(currState.getInsulinUnitsAdministeredLastHour() + bolus.getInsulinUnits());
		taskScheduler.schedule(Duration.ofMinutes(bolus.getDurationMinutes()), () -> currState.setBolus(null));
	}
	
	@Override
	public InsulinPumpState getCurrentState() {
		LOG.info("getCurrentState()");
		return this.currState;
	}
	
	@Override
	@PreCondition(PreAdjustBasalRate.class)
	public void adjustBasalRate(BasalRate rate) {
		LOG.info("adjustBasalRate({} units per hour)", rate.getInsulinUnitsPerHour());
		currState.getTreatmentPlan().setBasalRate(rate);
	}
	
	@Override
	public Integer getBatteryLevel() {
		LOG.info("getBatteryLevel() = 80");
		return 80;
	}
	

}
