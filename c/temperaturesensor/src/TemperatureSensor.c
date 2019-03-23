
#include <fogPlatform.h>
#include <BodyTemperature.h>
#include <TemperatureSensor.h>
#include <Random.h>

#define MIN_TEMPERATURE 30
#define MAX_TEMPERATURE 42

struct TemperatureSensor {
	Random random;
};

TemperatureSensor newTemperatureSensor() {
	TemperatureSensor sensor = calloc(1, sizeof(struct TemperatureSensor));
	if (!sensor) {
		return NULL;
	}
	sensor->random = newRandom();
	if (!sensor->random) {
		deleteTemperatureSensor(sensor);
		sensor = NULL;
	}
	return sensor;
}

void deleteTemperatureSensor(TemperatureSensor target) {
	free(target);
}


bool TemperatureSensor_getBatteryLevel(TemperatureSensor target, int_t *result) {
	*result = 90;
	printf("getBatteryLevel() = %i\n", *result);
	return true;
}

bool TemperatureSensor_measureTemperature(TemperatureSensor target, BodyTemperature result) {
	real_t temp = Random_next(target->random, MIN_TEMPERATURE, MAX_TEMPERATURE + 1);
	printf("measureTemperature() = %f\n", temp);
	BodyTemperature_setDegCelsius(result, temp);
	return true;
}


