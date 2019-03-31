package healthcare.treatment.constraints;

import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import javax.inject.Singleton;

import healthcare.treatment.TreatmentPlan;


/**
 * This class implements the constraint maxBolus.
 * 
 * @generated
 */
@Singleton
public class MaxBolus implements MethodInterceptor<TreatmentPlan, Object> {

	@Override
	public Object intercept(MethodInvocationContext<TreatmentPlan, Object> context) {
		TreatmentPlan self = context.getTarget();
		
		boolean validationResult = self.getBolus().getInsulinUnits() <=  self.getMaxUnitsPerBolus();
		if (validationResult) {
			return context.proceed();
		} else {
			throw new RuntimeException("The constraint maxBolus has been violated.");
		}
	}

}
