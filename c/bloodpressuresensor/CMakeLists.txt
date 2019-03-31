project(bloodpressuresensor C)

include("../common/CMakeLists.txt" "src/platform-include")

set(SRCS
	"src/main.c"
	"src/BloodPressureSensor.c"
	"src/BloodPressureSensorHandler.c"
)

add_executable(bloodpressuresensor ${SRCS} ${COMMON_LIB_SRCS})

target_include_directories(bloodpressuresensor PUBLIC "../common/src" "src/platform-include")

target_link_libraries(bloodpressuresensor "jansson" "ulfius" "m")

