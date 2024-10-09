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
