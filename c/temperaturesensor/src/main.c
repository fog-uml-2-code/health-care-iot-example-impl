#include <fogPlatform.h>
#include <BodyTemperature.h>


#include <TemperatureSensor.h>
#include <HttpServer.h>
#include "TemperatureSensorHandler.h"

int main(int argc, char *argv[]) {
	printf("REST Controller TemperatureSensor starting\n");
	HttpServer server = newHttpServer(LISTEN_PORT);
	if (!server) {
		fprintf(stderr, "Error creating HTTP server\n");
		return 1;
	}

	// Add the endpoints
	TemperatureSensor_setUpHandler(server);

	// Start the server
	if (HttpServer_start(server)) {
		printf("REST Controller TemperatureSensor started on port %d\n", HttpServer_getUlfiusInstance(server)->port);

		// Wait for the user to press Enter to exit the program
		getchar();
	} else {
		fprintf(stderr, "Error starting server\n");
	}

	printf("Stopping server\n");
	TemperatureSensor_shutdownHandler();
	HttpServer_stop(server);
	deleteHttpServer(server);

	return 0;
}

