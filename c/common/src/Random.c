#include <Random.h>
#include <time.h>

struct Random {
	char stateBuf[256];
	struct random_data randomData;
};

Random newRandom() {
	Random rand = calloc(1, sizeof(struct Random));
	if (!rand) {
		return NULL;
	}
	if (initstate_r(time(NULL), rand->stateBuf, sizeof(rand->stateBuf), &rand->randomData) != 0) {
		deleteRandom(rand);
		rand = NULL;
	}
	return rand;
}

void deleteRandom(Random target) {
	free(target);
}

int_t Random_next(Random target, int_t lowerBound, int_t upperBound) {
	int32_t randomResult;
	random_r(&target->randomData, &randomResult);

	int_t range = upperBound - lowerBound;
	int_t ret = randomResult % range;
	ret += lowerBound;
	return ret;
}
