
#include <fogPlatform.h>
#include <BloodPressure.h>


#include <BloodPressureSensor.h>
#include <HttpServer.h>
#include "BloodPressureSensorHandler.h"

BloodPressureSensor restController;

bool BloodPressureSensor_setUpHandler(HttpServer server) {
	restController = newBloodPressureSensor();

	// Register all endpoints
	HttpServer_addEndpoint(server, GET, "/bloodpressuresensor/getbatterylevel", &BloodPressureSensor_getBatteryLevelHandler, restController);
	HttpServer_addEndpoint(server, GET, "/bloodpressuresensor/measurebloodpressure", &BloodPressureSensor_measureBloodPressureHandler, restController);
	return true;
}

void BloodPressureSensor_shutdownHandler() {
	deleteBloodPressureSensor(restController);
	restController = NULL;
}

int BloodPressureSensor_getBatteryLevelHandler(const HttpRequest request, HttpResponse response, void *userData) {
	BloodPressureSensor target = (BloodPressureSensor) userData;

	bool validationResult = true;
	
	if (!validationResult) {
		goto End;
	}
	int_t result;


	bool opSuccess = BloodPressureSensor_getBatteryLevel(target, &result);
	if (!opSuccess) {
		validationResult = opSuccess;
	}

	
	if (validationResult) {
		json_t *jsonBody = json_integer(result);
		HttpResponse_setJsonBody(response, 200, jsonBody);
		json_decref(jsonBody);
	}

End:
	
	return validationResult ? U_CALLBACK_COMPLETE : U_CALLBACK_ERROR;
}

int BloodPressureSensor_measureBloodPressureHandler(const HttpRequest request, HttpResponse response, void *userData) {
	BloodPressureSensor target = (BloodPressureSensor) userData;

	bool validationResult = true;
	
	if (!validationResult) {
		goto End;
	}
	BloodPressure result;
result = newBloodPressure();

	bool opSuccess = BloodPressureSensor_measureBloodPressure(target, result);
	if (!opSuccess) {
		validationResult = opSuccess;
	}

	
	if (validationResult) {
		json_t *jsonBody = BloodPressure_serializeToJson(result);
		HttpResponse_setJsonBody(response, 200, jsonBody);
		json_decref(jsonBody);
	}
	deleteBloodPressure(result);

End:
	
	return validationResult ? U_CALLBACK_COMPLETE : U_CALLBACK_ERROR;
}


