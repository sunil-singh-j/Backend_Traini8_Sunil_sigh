# Backend_Traini8_Sunil_singh
Training Center Registry API
Project Overview
The Training Center Registry API is designed to manage government-funded training centers. The API provides two primary functionalities: saving a new training center with related details and retrieving a list of all stored training centers.
Key Features
•	Training Center Registration: Register a new training center with fields such as center name, code, address, student capacity, courses offered, and contact information.
•	Validation: Server-side validation ensures that mandatory fields are present, and valid values are provided for email, phone, and other fields.
•	Filtering: Filter the list of registered training centers based on city and state.
•	Exception Handling: Global exception handling using @ControllerAdvice to manage errors and provide meaningful responses.
Tech Stack
•	Language: Java 17
•	Framework: Spring Boot
•	Database: MYSQL
•	ORM: Hibernate (JPA)
•	Build Tool: Maven
•	Validation: Spring’s validation framework (JSR 380/Bean Validation)

Instructions for Project Setup
1. Setup from ZIP File
1.	Extract the ZIP:
o	Download the ZIP file containing the project.
o	Extract it to your preferred directory.
2.	Open Project in IDE:
o	Use an IDE such as IntelliJ IDEA, Eclipse, or VS Code to open the extracted folder.

3.	Configure MySQL:
o	The application is configured to automatically create the database. No manual creation is required.
o	Make sure that MySQL is running on your machine, and the credentials (username=root, password=root) match your MySQL setup. Modify application.properties if you have different credentials.

spring.datasource.url=jdbc:mysql://localhost:3306/Training-centre-registery?createDatabaseIfNotExist=true

spring.datasource.username=root 
spring.datasource.password=root
4.	Build and Run:
o	In the terminal, navigate to the project directory and run the following Maven commands:
mvn clean install
mvn spring-boot:run
o	The application will start, and the database will be created automatically.
OR
Alternative Approach: Run from IDE
•	If you prefer using an IDE:
1.	Open the project in your IDE (Eclipse or IntelliJ).
2.	Locate the main application class (e.g., TrainingCentreRegistryApplication.java).
3.	Right-click on the file and select Run As > Java Application.

5.	Access the APIs:
o	You can access the APIs at:
	POST API to add a new training center:
 http://localhost:8080/save
	GET API to retrieve all training centers:
 http://localhost:8080/training-centers
6.	Check the Database:
o	Verify that the Training-centre-registery database has been created in your MySQL server.
2. Setup from Git
1.	Clone the Repository:
o	Open a terminal and clone the Git repository:git clone <repository-url>
o	Replace <repository-url> with the actual URL of the Git repository.
2.	Open the Project in Your IDE:
o	After cloning, open the project folder in your IDE (IntelliJ, Eclipse, VS Code, etc.).
3.	Configure MySQL:
o	The database will be created automatically upon running the application, provided that MySQL is running and the credentials in application.properties match your MySQL credentials.
4.	Build and Run:
o	Use Maven to build and run the project: mvn clean install
mvn spring-boot:run
OR
Alternative Approach: Run from IDE
•	If you prefer using an IDE:
1.	Open the project in your IDE (Eclipse or IntelliJ).
2.	Locate the main application class (e.g., TrainingCentreRegistryApplication.java).
3.	Right-click on the file and select Run As > Java Application.
5.	Test the APIs:
o	The endpoints will be the same as mentioned above:
	POST API to create a new training center:
	 http://localhost:8080/save
	GET API to fetch all training centers: 
http://localhost:8080/training-centers
6.	Check the Database:
o	Confirm that the Training-centre-registery database has been created automatically in MySQL.

Project Structure
  ── controller
      ── TrainingCenterController.java
 ── dto
      ── Address.java
      ── Course.java
      ── TrainingCenter.java

 ── repository
     ── TrainingCenterRepository.java

 ── service
     ── TrainingCenterService.java

 ── exception
    ── GlobalExceptionHandler.java

 ── TrainingCentreRegistryApplication.java

API Endpoints
1. POST : http://localhost:8080/save
Description:
Create and save a new training center.
Request:
•	URL: http://localhost:8080/save
•	Method: POST
•	Content-Type: application/json
•	Body:json
{
  "centerName": "ABC Training Center",
  "centerCode": "ABC123456789",
  "address": {
    "detailedAddress": "123 Main Street",
    "city": "Hyderabad",
    "state": "Telangana",
    "pincode": "500001"
  },
  "studentCapacity": 200,
  "courses": [
    {
      "courseName": "Java Programming"
    },
    {
      "courseName": "Data Science"
    }
  ],
  "contactEmail": "info@abctraining.com",
  "contactPhone": "9876543210"
}

Validation:
•	centerName: Required, max 40 characters.
•	centerCode: Required, exactly 12 alphanumeric characters.
•	city: Required.
•	state: Required.
•	contactPhone: Required, must be exactly 10 digits.
•	contactEmail: Optional, if present, must be a valid email.
Response:
•	On success:
o	Status: 201 Created
o	Body:json
{
  "id": 1,
  "centerName": "ABC Training Center",
  "centerCode": "ABC123456789",
  "address": {
    "detailedAddress": "123 Main Street",
    "city": "Hyderabad",
    "state": "Telangana",
    "pincode": "500001"
  },
  "studentCapacity": 200,
  "courses": [
    {
      "courseName": "Java Programming"
    },
    {
      "courseName": "Data Science"
    }
  ],
  "contactEmail": "info@abctraining.com",
  "contactPhone": "9876543210",
  "createdOn": 1621234567890
}
On validation failure:
•	Status: 400 Bad Request
•	Body (example):json
{
  "message": "Center code must be exactly 12 characters"
}
2. GET :http://localhost:8080/training-centers?city=Hyderabad&state=Telangana
Description:
Retrieve a list of all saved training centers, with optional filtering by city and state.
Request:
•	URL: http://localhost:8080/training-centers?city=Hyderabad&state=Telangana
•	Method: GET
•	Parameters:
o	city: Optional, filters by city.
o	state: Optional, filters by state.
Response:
•	On success:
o	Status: 200 OK
o	Body:Json
 [  {
    "id": 1,
    "centerName": "ABC Training Center",
    "centerCode": "ABC123456789",
    "address": {
      "detailedAddress": "123 Main Street",
      "city": "Hyderabad",
      "state": "Telangana",
      "pincode": "500001"
    },
    "studentCapacity": 200,
    "courses": [
     {
      "courseName": "Java Programming"
      },
      {
        "courseName": "Data Science"
}
    ],
    
    "contactEmail": "info@abctraining.com",
    "contactPhone": "9876543210",
    "createdOn": 1621234567890
  }
]
•	On no data found:
o	Status: 200 OK
o	Body: [] (empty array)



