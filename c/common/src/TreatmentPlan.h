#ifndef TREATMENTPLAN_H
#define TREATMENTPLAN_H

#include <fogPlatform.h>
#include <BasalRate.h>

#include <Bolus.h>


#include <jansson.h>

/**
 * Describes a TreatmentPlan model type.
 */
typedef struct TreatmentPlan* TreatmentPlan;

TreatmentPlan newTreatmentPlan();

void deleteTreatmentPlan(TreatmentPlan target);

TreatmentPlan TreatmentPlan_deserializeFromJson(json_t *json);

json_t *TreatmentPlan_serializeToJson(TreatmentPlan target);

int_t TreatmentPlan_getMaxInsulinUnitsPerDay(TreatmentPlan target);

bool TreatmentPlan_setMaxInsulinUnitsPerDay(TreatmentPlan target, int_t maxInsulinUnitsPerDay);

int_t TreatmentPlan_getMaxHourlyBasalRate(TreatmentPlan target);

bool TreatmentPlan_setMaxHourlyBasalRate(TreatmentPlan target, int_t maxHourlyBasalRate);

Bolus TreatmentPlan_getBolus(TreatmentPlan target);

bool TreatmentPlan_setBolus(TreatmentPlan target, Bolus bolus);

BasalRate TreatmentPlan_getBasalRate(TreatmentPlan target);

bool TreatmentPlan_setBasalRate(TreatmentPlan target, BasalRate basalRate);

int_t TreatmentPlan_getMinHourlyBasalRate(TreatmentPlan target);

bool TreatmentPlan_setMinHourlyBasalRate(TreatmentPlan target, int_t minHourlyBasalRate);

int_t TreatmentPlan_getMaxInsulinUnitsPerHour(TreatmentPlan target);

bool TreatmentPlan_setMaxInsulinUnitsPerHour(TreatmentPlan target, int_t maxInsulinUnitsPerHour);

int_t TreatmentPlan_getMaxUnitsPerBolus(TreatmentPlan target);

bool TreatmentPlan_setMaxUnitsPerBolus(TreatmentPlan target, int_t maxUnitsPerBolus);



#endif /* TREATMENTPLAN_H */

