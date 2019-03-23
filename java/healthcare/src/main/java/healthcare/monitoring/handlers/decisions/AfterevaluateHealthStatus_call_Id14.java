package healthcare.monitoring.handlers.decisions;

import io.micronaut.context.annotation.Prototype;
import javax.inject.Inject;

import healthcare.monitoring.state.ActivityState;

/**
 * This is the DecisionNode handler for .
 * 
 * @generated
 */
@Prototype
public class AfterevaluateHealthStatus_call_Id14 {

	@Inject
	private ActivityState activityState;

	/**
	 * @generated
	 * @return true if the ActivityEdge guarded by this condition should be taken, otherwise false.
	 */
	public boolean BloodPressureCritical() {
		// ToDo: Implement this method.
		throw new UnsupportedOperationException("This method is not yet implemented");
	}

}

