#ifndef INSULINPUMPSTATE_H
#define INSULINPUMPSTATE_H

#include <fogPlatform.h>
#include <TreatmentPlan.h>


#include <jansson.h>

/**
 * Describes a InsulinPumpState model type.
 */
typedef struct InsulinPumpState* InsulinPumpState;

InsulinPumpState newInsulinPumpState();

void deleteInsulinPumpState(InsulinPumpState target);

InsulinPumpState InsulinPumpState_deserializeFromJson(json_t *json);

json_t *InsulinPumpState_serializeToJson(InsulinPumpState target);

int_t InsulinPumpState_getInsulinUnitsAdministeredLast24Hours(InsulinPumpState target);

bool InsulinPumpState_setInsulinUnitsAdministeredLast24Hours(InsulinPumpState target, int_t insulinUnitsAdministeredLast24Hours);

int_t InsulinPumpState_getTimeLastBolusEnded(InsulinPumpState target);

bool InsulinPumpState_setTimeLastBolusEnded(InsulinPumpState target, int_t timeLastBolusEnded);

int_t InsulinPumpState_getCurrentTime(InsulinPumpState target);

bool InsulinPumpState_setCurrentTime(InsulinPumpState target, int_t currentTime);

TreatmentPlan InsulinPumpState_getTreatmentPlan(InsulinPumpState target);

bool InsulinPumpState_setTreatmentPlan(InsulinPumpState target, TreatmentPlan treatmentPlan);

int_t InsulinPumpState_getInsulinUnitsAdministeredLastHour(InsulinPumpState target);

bool InsulinPumpState_setInsulinUnitsAdministeredLastHour(InsulinPumpState target, int_t insulinUnitsAdministeredLastHour);

Bolus InsulinPumpState_getBolus(InsulinPumpState target);

bool InsulinPumpState_setBolus(InsulinPumpState target, Bolus bolus);



#endif /* INSULINPUMPSTATE_H */

