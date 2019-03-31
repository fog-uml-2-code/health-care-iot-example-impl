#ifndef INSULINPUMP_H
#define INSULINPUMP_H

#include <fogPlatform.h>
#include <BasalRate.h>

#include <Bolus.h>

#include <InsulinPumpState.h>



/**
 * InsulinPump REST interface.
 */
typedef struct InsulinPump* InsulinPump;

InsulinPump newInsulinPump();

void deleteInsulinPump(InsulinPump target);

/**
 * Documentation of the REST interface operation setCurrentTime.
 * 
 * @param timestamp

 * @return true if the operation completed successfully, otherwise false.
 * 
 * @generated
 */
bool InsulinPump_setCurrentTime(InsulinPump target, int_t timestamp);

/**
 * Documentation of the REST interface operation getBatteryLevel.
 * 

 * @param result The result of the REST operation.
 * @return true if the operation completed successfully, otherwise false.
 * 
 * @generated
 */
bool InsulinPump_getBatteryLevel(InsulinPump target, int_t *result);

/**
 * Documentation of the REST interface operation getCurrentState.
 * 

 * @param result The result of the REST operation.
 * @return true if the operation completed successfully, otherwise false.
 * 
 * @generated
 */
bool InsulinPump_getCurrentState(InsulinPump target, InsulinPumpState result);

/**
 * Documentation of the REST interface operation adjustBasalRate.
 * 
 * @param rate

 * @return true if the operation completed successfully, otherwise false.
 * 
 * @generated
 */
bool InsulinPump_adjustBasalRate(InsulinPump target, BasalRate rate);

/**
 * Documentation of the REST interface operation startBolus.
 * 
 * @param bolus

 * @return true if the operation completed successfully, otherwise false.
 * 
 * @generated
 */
bool InsulinPump_startBolus(InsulinPump target, Bolus bolus);


#endif /* INSULINPUMP_H */

