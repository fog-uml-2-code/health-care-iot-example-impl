package healthcare.treatment.constraints;

import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import javax.inject.Singleton;

import healthcare.treatment.TreatmentPlan;


/**
 * This class implements the constraint basalRateLimits.
 * 
 * @generated
 */
@Singleton
public class BasalRateLimits implements MethodInterceptor<TreatmentPlan, Object> {

	@Override
	public Object intercept(MethodInvocationContext<TreatmentPlan, Object> context) {
		TreatmentPlan self = context.getTarget();
		
		Object ret = context.proceed();
		boolean validationResult = self.getBasalRate().getInsulinUnitsPerHour() >=  self.getMinHourlyBasalRate() &&
		     self.getBasalRate().getInsulinUnitsPerHour() <=  self.getMaxHourlyBasalRate();
		if (validationResult) {
			return ret;
		} else {
			throw new RuntimeException("The constraint basalRateLimits has been violated.");
		}
	}

}
