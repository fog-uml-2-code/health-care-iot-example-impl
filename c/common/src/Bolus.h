#ifndef BOLUS_H
#define BOLUS_H

#include <fogPlatform.h>

#include <jansson.h>

/**
 * Describes a Bolus model type.
 */
typedef struct Bolus* Bolus;

Bolus newBolus();

void deleteBolus(Bolus target);

Bolus Bolus_deserializeFromJson(json_t *json);

json_t *Bolus_serializeToJson(Bolus target);

int_t Bolus_getInsulinUnits(Bolus target);

bool Bolus_setInsulinUnits(Bolus target, int_t insulinUnits);

int_t Bolus_getDurationMinutes(Bolus target);

bool Bolus_setDurationMinutes(Bolus target, int_t durationMinutes);



#endif /* BOLUS_H */

