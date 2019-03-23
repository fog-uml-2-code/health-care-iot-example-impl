package healthcare.models.constraints;

import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import javax.inject.Singleton;

import healthcare.models.InsulinPumpState;


/**
 * This class implements the constraint maxInsulinDosage.
 * 
 * @generated
 */
@Singleton
public class MaxInsulinDosage implements MethodInterceptor<InsulinPumpState, Object> {

	@Override
	public Object intercept(MethodInvocationContext<InsulinPumpState, Object> context) {
		InsulinPumpState self = context.getTarget();
		
		boolean validationResult = self.getInsulinUnitsAdministeredLast24Hours() <=  self.getTreatmentPlan().getMaxInsulinUnitsPerDay() && 
     self.getInsulinUnitsAdministeredLastHour() <=  self.getTreatmentPlan().getMaxInsulinUnitsPerHour();
		if (validationResult) {
			return context.proceed();
		} else {
			throw new RuntimeException("The constraint maxInsulinDosage has been violated.");
		}
	}

}
