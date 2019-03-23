#ifndef TEMPERATURESENSOR_H
#define TEMPERATURESENSOR_H

#include <fogPlatform.h>
#include <BodyTemperature.h>



/**
 * TemperatureSensor REST interface.
 */
typedef struct TemperatureSensor* TemperatureSensor;

TemperatureSensor newTemperatureSensor();

void deleteTemperatureSensor(TemperatureSensor target);

/**
 * Documentation of the REST interface operation getBatteryLevel.
 * 

 * @param result The result of the REST operation.
 * @return true if the operation completed successfully, otherwise false.
 * 
 * @generated
 */
bool TemperatureSensor_getBatteryLevel(TemperatureSensor target, int_t *result);

/**
 * Documentation of the REST interface operation measureTemperature.
 * 

 * @param result The result of the REST operation.
 * @return true if the operation completed successfully, otherwise false.
 * 
 * @generated
 */
bool TemperatureSensor_measureTemperature(TemperatureSensor target, BodyTemperature result);


#endif /* TEMPERATURESENSOR_H */

