# Health Care IoT Example Implementation

A demo implementation of the code generated using [FogUML2Code](https://github.com/fog-uml-2-code/fog-uml-2-code) from the [health-care-iot-example](https://github.com/fog-uml-2-code/health-care-iot-example) model.


## Disclaimer
We would like to note that we are NOT medical doctors and that this application only serves as a theoretic case study for our software engineering approach.


## Fog Device Languages and Port Configurations

The following table shows in which language the code for each fog device from the *health-care-iot-example* model is generated and on which port it is configured to run:

| Fog Device          | Target Language | Listen Port |
| ------------------- | --------------- | ----------- |
| HeartRateSensor     | C               | 8081        |
| TemperatureSensor   | C               | 8082        |
| BloodPressureSensor | C               | 8083        |
| BloodSugarSensor    | Java            | 8084        |
| InsulinPump         | Java            | 8085        |

Since this is a demo for testing FogUML2Code, the ports are all different, such that all applications can be run on a single machine.
