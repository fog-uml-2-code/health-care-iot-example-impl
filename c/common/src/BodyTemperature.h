#ifndef BODYTEMPERATURE_H
#define BODYTEMPERATURE_H

#include <fogPlatform.h>

#include <jansson.h>

/**
 * Describes a BodyTemperature model type.
 */
typedef struct BodyTemperature* BodyTemperature;

BodyTemperature newBodyTemperature();

void deleteBodyTemperature(BodyTemperature target);

BodyTemperature BodyTemperature_deserializeFromJson(json_t *json);

json_t *BodyTemperature_serializeToJson(BodyTemperature target);

real_t BodyTemperature_getDegCelsius(BodyTemperature target);

bool BodyTemperature_setDegCelsius(BodyTemperature target, real_t degCelsius);



#endif /* BODYTEMPERATURE_H */

