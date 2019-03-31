#ifndef RANDOM_H
#define RANDOM_H

#include <fogPlatform.h>

/**
 * A random number generator. Each instance must be used from a single thread only.
 */
typedef struct Random *Random;

Random newRandom();

void deleteRandom(Random target);

/**
 * Returns a random number between lowerBound (inclusive) and upperBound (exclusive).
 */
int_t Random_next(Random target, int_t lowerBound, int_t upperBound);

#endif /* RANDOM_H */
