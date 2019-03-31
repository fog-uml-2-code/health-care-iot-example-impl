package healthcare.treatment.constraints;

import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import javax.inject.Singleton;

import healthcare.treatment.InsulinPump;
import healthcare.models.BasalRate;

/**
 * This class implements the constraint preAdjustBasalRate.
 * 
 * @generated
 */
@Singleton
public class PreAdjustBasalRate implements MethodInterceptor<InsulinPump, Object> {

	@Override
	public Object intercept(MethodInvocationContext<InsulinPump, Object> context) {
		InsulinPump self = context.getTarget();
		BasalRate rate = (BasalRate) context.getParameterValueMap().get("rate");
		boolean validationResult = ((Number) rate.getInsulinUnitsPerHour()).intValue() >=  self.getCurrentState().getTreatmentPlan().getMinHourlyBasalRate() &&
    ((Number) rate.getInsulinUnitsPerHour()).intValue() <=  self.getCurrentState().getTreatmentPlan().getMaxHourlyBasalRate();
		if (validationResult) {
			return context.proceed();
		} else {
			throw new RuntimeException("The constraint preAdjustBasalRate has been violated.");
		}
	}

}
