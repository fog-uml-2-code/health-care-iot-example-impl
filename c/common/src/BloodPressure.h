#ifndef BLOODPRESSURE_H
#define BLOODPRESSURE_H

#include <fogPlatform.h>

#include <jansson.h>

/**
 * Describes a BloodPressure model type.
 */
typedef struct BloodPressure* BloodPressure;

BloodPressure newBloodPressure();

void deleteBloodPressure(BloodPressure target);

BloodPressure BloodPressure_deserializeFromJson(json_t *json);

json_t *BloodPressure_serializeToJson(BloodPressure target);

int_t BloodPressure_getMmHgSystolic(BloodPressure target);

bool BloodPressure_setMmHgSystolic(BloodPressure target, int_t mmHgSystolic);

int_t BloodPressure_getMmHgDiastolic(BloodPressure target);

bool BloodPressure_setMmHgDiastolic(BloodPressure target, int_t mmHgDiastolic);



#endif /* BLOODPRESSURE_H */

