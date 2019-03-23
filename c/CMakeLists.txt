cmake_minimum_required(VERSION 3.8)

project("HealthCare")

set(CMAKE_C_STANDARD 11)

# Include sub-projects.
add_subdirectory("heartratesensor")
add_subdirectory("temperaturesensor")

add_subdirectory("bloodpressuresensor")


