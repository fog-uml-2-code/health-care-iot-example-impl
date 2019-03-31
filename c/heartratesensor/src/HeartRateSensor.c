
#include <fogPlatform.h>
#include <HeartRateSensor.h>
#include <Random.h>
#include <ErrorSimulator.h>

#define ERROR_PROBABILITY 10
#define MIN_HEART_RATE 40
#define MAX_HEART_RATE 200

struct HeartRateSensor {
	Random random;
	ErrorSimulator errorSim;
};

HeartRateSensor newHeartRateSensor() {
	HeartRateSensor sensor = calloc(1, sizeof(struct HeartRateSensor));
	if (!sensor) {
		return NULL;
	}
	sensor->random = newRandom();
	sensor->errorSim = newErrorSimulator(ERROR_PROBABILITY);
	if (!sensor->random || !sensor->errorSim) {
		deleteHeartRateSensor(sensor);
		sensor = NULL;
	}
	return sensor;
}

void deleteHeartRateSensor(HeartRateSensor target) {
	if (target->errorSim) {
		deleteErrorSimulator(target->errorSim);
	}
	if (target->random) {
		deleteRandom(target->random);
	}
	free(target);
}


bool HeartRateSensor_getBatteryLevel(HeartRateSensor target, int_t *result) {
	*result = 90;
	printf("getBatteryLevel() = %i\n", *result);
	return true;
}

bool HeartRateSensor_getHeartRate(HeartRateSensor target, int_t *result) {
	if (!ErrorSimulator_isNextOperationSuccessful(target->errorSim)) {
		printf("getHeartRate() = Error\n");
		return false;
	}

	*result = Random_next(target->random, MIN_HEART_RATE, MAX_HEART_RATE + 1);
	printf("getHeartRate() = %i\n", *result);
	return true;
}


