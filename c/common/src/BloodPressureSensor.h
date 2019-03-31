#ifndef BLOODPRESSURESENSOR_H
#define BLOODPRESSURESENSOR_H

#include <fogPlatform.h>
#include <BloodPressure.h>



/**
 * BloodPressureSensor REST interface.
 */
typedef struct BloodPressureSensor* BloodPressureSensor;

BloodPressureSensor newBloodPressureSensor();

void deleteBloodPressureSensor(BloodPressureSensor target);

/**
 * Documentation of the REST interface operation getBatteryLevel.
 * 

 * @param result The result of the REST operation.
 * @return true if the operation completed successfully, otherwise false.
 * 
 * @generated
 */
bool BloodPressureSensor_getBatteryLevel(BloodPressureSensor target, int_t *result);

/**
 * Documentation of the REST interface operation measureBloodPressure.
 * 

 * @param result The result of the REST operation.
 * @return true if the operation completed successfully, otherwise false.
 * 
 * @generated
 */
bool BloodPressureSensor_measureBloodPressure(BloodPressureSensor target, BloodPressure result);


#endif /* BLOODPRESSURESENSOR_H */

