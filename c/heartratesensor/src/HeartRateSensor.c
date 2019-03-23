
#include <fogPlatform.h>
#include <HeartRateSensor.h>
#include <Random.h>

#define MIN_HEART_RATE 40
#define MAX_HEART_RATE 200

struct HeartRateSensor {
	Random random;
};

HeartRateSensor newHeartRateSensor() {
	HeartRateSensor sensor = calloc(1, sizeof(struct HeartRateSensor));
	if (!sensor) {
		return NULL;
	}
	sensor->random = newRandom();
	if (!sensor->random) {
		deleteHeartRateSensor(sensor);
		sensor = NULL;
	}
	return sensor;
}

void deleteHeartRateSensor(HeartRateSensor target) {
	free(target);
}


bool HeartRateSensor_getBatteryLevel(HeartRateSensor target, int_t *result) {
	*result = 90;
	printf("getBatteryLevel() = %i\n", *result);
	return true;
}

bool HeartRateSensor_getHeartRate(HeartRateSensor target, int_t *result) {
	*result = Random_next(target->random, MIN_HEART_RATE, MAX_HEART_RATE + 1);
	printf("getHeartRate() = %i\n", *result);
	return true;
}


