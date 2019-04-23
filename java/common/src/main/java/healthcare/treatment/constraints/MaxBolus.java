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
		
		Object ret = context.proceed();
		boolean validationResult = self.getBolus().getInsulinUnits() <=  self.getMaxUnitsPerBolus();
		if (validationResult) {
			return ret;
		} else {
			throw new RuntimeException("The constraint maxBolus has been violated.");
		}
	}

}
