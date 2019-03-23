#include <ErrorSimulator.h>
#include <Random.h>

struct ErrorSimulator {
	Random random;
	int_t errorProbability;
};

ErrorSimulator newErrorSimulator(int_t errorProbability) {
	if (errorProbability < 0 || errorProbability > 100) {
		return NULL;
	}
	ErrorSimulator simulator = calloc(1, sizeof(ErrorSimulator));
	if (!simulator) {
		return NULL;
	}
	simulator->errorProbability = errorProbability;
	simulator->random = newRandom();
	if (!simulator->random) {
		deleteErrorSimulator(simulator);
		simulator = NULL;
	}
	return simulator;
}

void deleteErrorSimulator(ErrorSimulator target) {
	if (target->random) {
		deleteRandom(target->random);
	}
	free(target);
}

bool ErrorSimulator_isNextOperationSuccessful(ErrorSimulator target) {
	int_t r = Random_next(target->random, 0, 100);
	printf("random = %i, errorProbability = %i\n", r, target->errorProbability);
	return !(r < target->errorProbability);
}
