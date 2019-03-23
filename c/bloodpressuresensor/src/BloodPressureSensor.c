
#include <fogPlatform.h>
#include <BloodPressure.h>
#include <Random.h>
#include <BloodPressureSensor.h>

#define MIN_SYSTOLIC 80
#define MAX_SYSTOLIC 190
#define MIN_DIASTOLIC 20
#define MAX_DIASTOLIC 110

struct BloodPressureSensor {
	Random random;
};

BloodPressureSensor newBloodPressureSensor() {
	BloodPressureSensor sensor = calloc(1, sizeof(struct BloodPressureSensor));
	if (!sensor) {
		return NULL;
	}
	sensor->random = newRandom();
	if (!sensor->random) {
		deleteBloodPressureSensor(sensor);
		sensor = NULL;
	}
	return sensor;
}

void deleteBloodPressureSensor(BloodPressureSensor target) {
	free(target);
}


bool BloodPressureSensor_getBatteryLevel(BloodPressureSensor target, int_t *result) {
	*result = 80;
	printf("getBatteryLevel() = %i\n", *result);
	return true;
}

bool BloodPressureSensor_measureBloodPressure(BloodPressureSensor target, BloodPressure result) {
	int_t systolic = Random_next(target->random, MIN_SYSTOLIC, MAX_SYSTOLIC + 1);
	int_t diastolic = Random_next(target->random, MIN_DIASTOLIC, fminl(MAX_DIASTOLIC + 1, systolic));
	printf("measureBloodPressure() = %i/%i\n", systolic, diastolic);
	BloodPressure_setMmHgSystolic(result, systolic);
	BloodPressure_setMmHgDiastolic(result, diastolic);
	return true;
}


