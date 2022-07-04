# Module 2 Project Guidelines

## Overview

Console application with user input to build a basic "world", e.g. a hospital
with doctors of various specialties. The hospital has doctors. The doctors are
of different types, and have patients.

## Project Brief

Create a virtual world with the appropriate relationships between a Hospital,
Doctors and Patients.

### Requirements

- The system should create a Hospital with a name property provided by the user.
- The system should create 3 doctors, each with a name and specialty provided by
  the user.
  - The specialty is user-definable, but good examples are:
    - Dermatology
    - Pediatrics
    - Radiology
    - ...
- The system should establish that the doctors work at the system's hospital.
- The system should ask the user to create 5 patients and match each patient to
  a doctor based on the specialty they need.
- When the system is done collecting input from the user and building the world,
  it should "display" the world to the user (text-based display on the command
  line).
- The system must handle invalid input from the user (at all points where input
  is gathered from the user).

### Stretch goals

- User-defined number of doctors.
- Pre-defined list of doctor specialties that the user must select from.
- User-defined number of patients.
- Pre-defined list of patient symptoms that match up to doctor specialties.
- System matches patients to doctors based on user-selected symptoms.

## Getting Started

- Create a class to model each entity in your virtual world, i.e. you should
  have a class for Hospital, a class for Doctor and a class for Patient.
- Determine the data structures you will need to hold the instances of those
  classes. Hint: think about collections.
- You will need a runnable class to start your world and gather input from the
  user.

## Sample Code

Start by creating a runnable class:

```java
public class HospitalWorld {
    public static void HospitalWorld(String[] args) {
        System.out.println("Running...");
    }
}
```

Create a class for each entity you will be modeling:

```java
public class Hospital {

}
```

```java
public class Doctor {

}
```

```java
public class Patient {

}
```

## Reminders

- Use existing built-in Java functions where possible
- The `Scanner` class has useful functionality for getting input from the user
