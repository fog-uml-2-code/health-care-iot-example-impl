#ifndef HEARTRATESENSOR_H
#define HEARTRATESENSOR_H

#include <fogPlatform.h>


/**
 * HeartRateSensor REST interface.
 */
typedef struct HeartRateSensor* HeartRateSensor;

HeartRateSensor newHeartRateSensor();

void deleteHeartRateSensor(HeartRateSensor target);

/**
 * Documentation of the REST interface operation getBatteryLevel.
 * 

 * @param result The result of the REST operation.
 * @return true if the operation completed successfully, otherwise false.
 * 
 * @generated
 */
bool HeartRateSensor_getBatteryLevel(HeartRateSensor target, int_t *result);

/**
 * Documentation of the REST interface operation getHeartRate.
 * 

 * @param result The result of the REST operation.
 * @return true if the operation completed successfully, otherwise false.
 * 
 * @generated
 */
bool HeartRateSensor_getHeartRate(HeartRateSensor target, int_t *result);


#endif /* HEARTRATESENSOR_H */

