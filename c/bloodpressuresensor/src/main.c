#include <fogPlatform.h>
#include <BloodPressure.h>


#include <BloodPressureSensor.h>
#include <HttpServer.h>
#include "BloodPressureSensorHandler.h"

int main(int argc, char *argv[]) {
	printf("REST Controller BloodPressureSensor starting\n");
	HttpServer server = newHttpServer(LISTEN_PORT);
	if (!server) {
		fprintf(stderr, "Error creating HTTP server\n");
		return 1;
	}

	// Add the endpoints
	BloodPressureSensor_setUpHandler(server);

	// Start the server
	if (HttpServer_start(server)) {
		printf("REST Controller BloodPressureSensor started on port %d\n", HttpServer_getUlfiusInstance(server)->port);

		// Wait for the user to press Enter to exit the program
		getchar();
	} else {
		fprintf(stderr, "Error starting server\n");
	}

	printf("Stopping server\n");
	BloodPressureSensor_shutdownHandler();
	HttpServer_stop(server);
	deleteHttpServer(server);

	return 0;
}

