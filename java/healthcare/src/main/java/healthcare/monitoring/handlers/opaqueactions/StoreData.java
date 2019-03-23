package healthcare.monitoring.handlers.opaqueactions;

import io.micronaut.context.annotation.Prototype;
import javax.inject.Inject;
import pusztai.thomas.architecture.fog.activity.realization.OpaqueActionHandler;

import healthcare.monitoring.state.ActivityState;

/**
 * This is the OpaqueAction handler for Store Data.
 * 
 * @generated
 */
@Prototype
public class StoreData implements OpaqueActionHandler {

	@Inject
	private ActivityState activityState;

	/**
	 * Executes the OpaqueAction.
	 * @generated
	 * @return The parameter(s) that should be passed to the upcoming call of the operation.
	 */
	@Override
	public void executeAction() {
		// ToDo: Implement this method.
		throw new UnsupportedOperationException("This method is not yet implemented");
	}

}

