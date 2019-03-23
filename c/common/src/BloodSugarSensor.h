#ifndef BLOODSUGARSENSOR_H
#define BLOODSUGARSENSOR_H

#include <fogPlatform.h>
#include <BloodSugarLevel.h>



/**
 * BloodSugarSensor REST interface.
 */
typedef struct BloodSugarSensor* BloodSugarSensor;

BloodSugarSensor newBloodSugarSensor();

void deleteBloodSugarSensor(BloodSugarSensor target);

/**
 * Documentation of the REST interface operation getBatteryLevel.
 * 

 * @param result The result of the REST operation.
 * @return true if the operation completed successfully, otherwise false.
 * 
 * @generated
 */
bool BloodSugarSensor_getBatteryLevel(BloodSugarSensor target, int_t *result);

/**
 * Documentation of the REST interface operation measureBloodSugar.
 * 

 * @param result The result of the REST operation.
 * @return true if the operation completed successfully, otherwise false.
 * 
 * @generated
 */
bool BloodSugarSensor_measureBloodSugar(BloodSugarSensor target, BloodSugarLevel result);


#endif /* BLOODSUGARSENSOR_H */

