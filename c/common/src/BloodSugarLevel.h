#ifndef BLOODSUGARLEVEL_H
#define BLOODSUGARLEVEL_H

#include <fogPlatform.h>

#include <jansson.h>

/**
 * Describes a BloodSugarLevel model type.
 */
typedef struct BloodSugarLevel* BloodSugarLevel;

BloodSugarLevel newBloodSugarLevel();

void deleteBloodSugarLevel(BloodSugarLevel target);

BloodSugarLevel BloodSugarLevel_deserializeFromJson(json_t *json);

json_t *BloodSugarLevel_serializeToJson(BloodSugarLevel target);

int_t BloodSugarLevel_getMmolPerLiter(BloodSugarLevel target);

bool BloodSugarLevel_setMmolPerLiter(BloodSugarLevel target, int_t mmolPerLiter);



#endif /* BLOODSUGARLEVEL_H */

