#ifndef BASALRATE_H
#define BASALRATE_H

#include <fogPlatform.h>

#include <jansson.h>

/**
 * Describes a BasalRate model type.
 */
typedef struct BasalRate* BasalRate;

BasalRate newBasalRate();

void deleteBasalRate(BasalRate target);

BasalRate BasalRate_deserializeFromJson(json_t *json);

json_t *BasalRate_serializeToJson(BasalRate target);

int_t BasalRate_getInsulinUnitsPerHour(BasalRate target);

bool BasalRate_setInsulinUnitsPerHour(BasalRate target, int_t insulinUnitsPerHour);



#endif /* BASALRATE_H */

