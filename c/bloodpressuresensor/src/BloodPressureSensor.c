
#include <fogPlatform.h>
#include <BloodPressure.h>
#include <Random.h>
#include <BloodPressureSensor.h>
#include <ErrorSimulator.h>

#define ERROR_PROBABILITY 10
#define MIN_SYSTOLIC 80
#define MAX_SYSTOLIC 190
#define MIN_DIASTOLIC 20
#define MAX_DIASTOLIC 110

struct BloodPressureSensor {
	Random random;
	ErrorSimulator errorSim;
};

BloodPressureSensor newBloodPressureSensor() {
	BloodPressureSensor sensor = calloc(1, sizeof(struct BloodPressureSensor));
	if (!sensor) {
		return NULL;
	}
	sensor->random = newRandom();
	sensor->errorSim = newErrorSimulator(ERROR_PROBABILITY);
	if (!sensor->random || !sensor->errorSim) {
		deleteBloodPressureSensor(sensor);
		sensor = NULL;
	}
	return sensor;
}

void deleteBloodPressureSensor(BloodPressureSensor target) {
	if (target->errorSim) {
		deleteErrorSimulator(target->errorSim);
	}
	if (target->random) {
		deleteRandom(target->random);
	}
	free(target);
}


bool BloodPressureSensor_getBatteryLevel(BloodPressureSensor target, int_t *result) {
	*result = 80;
	printf("getBatteryLevel() = %i\n", *result);
	return true;
}

bool BloodPressureSensor_measureBloodPressure(BloodPressureSensor target, BloodPressure result) {
	if (!ErrorSimulator_isNextOperationSuccessful(target->errorSim)) {
		printf("measureBloodPressure() = Error\n");
		return false;
	}

	int_t systolic = Random_next(target->random, MIN_SYSTOLIC, MAX_SYSTOLIC + 1);
	int_t diastolic = Random_next(target->random, MIN_DIASTOLIC, fminl(MAX_DIASTOLIC + 1, systolic));
	printf("measureBloodPressure() = %i/%i\n", systolic, diastolic);
	BloodPressure_setMmHgSystolic(result, systolic);
	BloodPressure_setMmHgDiastolic(result, diastolic);
	return true;
}


