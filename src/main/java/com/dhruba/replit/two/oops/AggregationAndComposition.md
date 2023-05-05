Aggregation - 2 independant objects which can be a part of one another but their lifetime is independant.
e.g. : Driver and vehicle, both can exist independantly but a driver can be assigned to a vehicle. So the Driver can be part of vehicle

Composition - objects are part of another object and they only exist for the lifetime of the parent object.
e.g. : A car has engine, doors and tires. Engine, Doors and Tires exist only till the Car exists. We can create the dependant objects in the constructor of the car class.