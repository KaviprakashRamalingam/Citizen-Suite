# Citizen Suite Application

## Overview

Citizen Suite is a Java Swing-based application that consolidates multiple public services into a unified platform. It streamlines the user experience across Event Management, Education, Employment, Finances, and Government sectors, saving time and resources while improving service delivery.

## Key Features

- Centralized event management with booking capabilities
- Educational course catalog and university application system
- Employment marketplace connecting job seekers with employers
- Financial services management, including credit card transactions
- Government service facilitation for applications and civic management

## System Architecture

Citizen Suite features a modular architecture with distinct enterprises, each containing specialized roles and organizations designed to provide a range of public services.

## Class diagram

<img src="./Citizens Suite/UML Diagrams/CitizenSuite_class_diagram.svg">

### Enterprises, Roles, and Organizations

#### Event Management Enterprise
- **Roles**: Event Creator, Event Approver, Censor Administrator
- **Organizations**: Event Location Creators, Event Organizers

#### Education Enterprise
- **Roles**: Course Creator, University Creator
- **Organizations**: University Affiliates

#### Employment Enterprise
- **Roles**: Job Creator, Company Creator
- **Organizations**: Job posters and Business Founders

#### Finance Enterprise
- **Roles**: Financial Administrator
- **Organizations**: Credit Card Department

#### Government Enterprise
- **Roles**: Government Administrator, City Commissioner
- **Organizations**: Government Oversight, City Planning Department

## Prerequisites

- Java JDK 8+
- NetBeans IDE
- MySQL Server 5.7+
- Internet access for API integration

## Usecase diagram

<img src="./Citizens Suite/UML Diagrams/CitizenSuite_usecase_diagram.svg">

## Usage

To use the Citizen Suite application, follow these steps:

1. Ensure that your SQL server is up and running. The application requires an active SQL service to handle its data storage and retrieval operations.

2. Update the SQL root password in the application's main configuration file. Locate the file at `.\src\com\citizensuite\main\MainJFrame.java` and enter your SQL root password where specified.

3. Before starting the application for the first time, run the `startup.sql` script to set up the initial database schema and populate it with any necessary startup data. This script can be found at `.\startup\Startup.sql`.



## Integrations

Citizen Suite integrates with various third-party services and APIs:

- **Faker.com**: For generating mock data for testing.
- **Java Email API**: Utilized for secure email communications with TLS (Transport Layer Security) enabled, ensuring that all data transmitted is encrypted and secure.
- **Google Maps API**: For location services.
- **JX Browser**: For web content within the application.


## Reporting and Analytics

The Citizen Suite application offers comprehensive reporting and analytics tools specifically tailored for government administrators. Key features include:

- **Approval and Denial Metrics**: Government admins can access detailed reports showing the number of approvals and denials for various categories such as buildings, events, courses, and universities.

- **Interactive Dashboards**: The reporting module includes interactive dashboards that visually display these metrics, making it easier to analyze and interpret the data.

- **Real-time Updates**: The data is updated in real-time, providing government admins with the most current information for decision-making processes.

## DB diagram

<img src="./Citizens Suite/UML Diagrams/CitizenSuite_DB_diagram.png">
