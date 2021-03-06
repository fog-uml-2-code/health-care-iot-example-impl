package healthcare.treatment.constraints;

import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import javax.inject.Singleton;

import healthcare.treatment.InsulinPump;
import healthcare.models.Bolus;

/**
 * This class implements the constraint preStartBolus.
 * 
 * @generated
 */
@Singleton
public class PreStartBolus implements MethodInterceptor<InsulinPump, Object> {

	@Override
	public Object intercept(MethodInvocationContext<InsulinPump, Object> context) {
		InsulinPump self = context.getTarget();
		Bolus bolus = (Bolus) context.getParameterValueMap().get("bolus");
		boolean validationResult = 
		
		
		self.getCurrentState().getBolus() ==  null &&
		
		
		self.getCurrentState().getCurrentTime() -  self.getCurrentState().getTimeLastBolusEnded() >= 3600000 &&
		
		
		self.getCurrentState().getInsulinUnitsAdministeredLastHour() + ((Number) bolus.getInsulinUnits()).intValue() <=  self.getCurrentState().getTreatmentPlan().getMaxInsulinUnitsPerHour() &&
		
		
		self.getCurrentState().getInsulinUnitsAdministeredLast24Hours() + ((Number) bolus.getInsulinUnits()).intValue() <=  self.getCurrentState().getTreatmentPlan().getMaxInsulinUnitsPerDay();
		if (validationResult) {
			return context.proceed();
		} else {
			throw new RuntimeException("The constraint preStartBolus has been violated.");
		}
	}

}
