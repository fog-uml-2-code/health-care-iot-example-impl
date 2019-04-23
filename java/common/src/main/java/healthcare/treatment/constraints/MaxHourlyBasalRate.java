package healthcare.treatment.constraints;

import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import javax.inject.Singleton;

import healthcare.treatment.TreatmentPlan;


/**
 * This class implements the constraint maxHourlyBasalRate.
 * 
 * @generated
 */
@Singleton
public class MaxHourlyBasalRate implements MethodInterceptor<TreatmentPlan, Object> {

	@Override
	public Object intercept(MethodInvocationContext<TreatmentPlan, Object> context) {
		TreatmentPlan self = context.getTarget();
		
		Object ret = context.proceed();
		boolean validationResult = self.getMaxHourlyBasalRate() <=  self.getMaxInsulinUnitsPerHour() &&
		     self.getMaxHourlyBasalRate() * 24 <  self.getMaxInsulinUnitsPerDay();
		if (validationResult) {
			return ret;
		} else {
			throw new RuntimeException("The constraint maxHourlyBasalRate has been violated.");
		}
	}

}
