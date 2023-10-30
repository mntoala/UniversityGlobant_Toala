# UniversityGlobant - University Management System
## Description
This project represents an academic administration system built in Java. It has been developed with the purpose of facilitating the management of data related to information about teachers, students and classes. In addition, its functionalities include adding students, assigning classes, calculating teacher salaries, and presenting more details about teachers and students.

## Requirements
- Java 12 or higher.
- A Java development environment such as IntelliJ IDEA or Eclipse.
- Internet access to fetch libraries and dependencies.

## Installation
- Clone this repository on your local machine: <br>
`git clone https://github.com/mntoala/UniversityGlobant_Toala.git`
- Open the project in your Java development environment.
- Configure the project and make sure that dependencies are downloaded automatically. If not, add the required libraries to the project.
- Run the UniversityView.java file to start the application.

## Project Structure
The project is organized into packages and classes as follows:
- ***ModelStructure**: Contains classes representing the university's structure.
- ***Controller***: Contains classes and methods that control the application's logic and input validation.
- ***View***: Contains classes that handle the user interface.
## Class diagram
Below is the class diagram that represents the structure and relationships between classes in the university system:
![University Final Proyect Globant - Design Diagram](https://github.com/mntoala/UniversityGlobant_Toala/assets/66579043/d25b7ae4-40dd-47b6-8f3d-9934b7d38a82)


## Structure Details
### Teacher
Teacher is an interface whose attributes are:
- name: Name of the teacher.
- baseSalary: Base salary of the teacher.<br>
The Teacher class also has the **getSalary()** method, which is used to calculate the teacher's salary. This class has two subclasses:
- **FullTimeTeacher**: Teachers who work 40 hours a week, and whose salary is multiplied by 110% of their years of experience.
- **PartTimeTeacher**: Teachers who work 20 to 30 hours a week, and whose base salary is multiplied by their hours worked.

### Student
The Student class represents a student in the university system. It has the following attributes:
- name: The name of the student.
- age: The age of the student.
- id: The student's identification document or ID card, this consists of 10 numbers.

### Class
The Class class represents a class in the university system. It has the following attributes:
- name: The name of the class.
- classroom: The location of the classroom.
- teacher: The teacher who teaches the class.
- students: A list of students attending the class.

### Contribution
If you wish to contribute to this project, follow these steps:
- Fork the repository.
- Create a new branch for your contribution.
- Make your changes and ensure tests pass.
- Submit a pull request to this repository.

### Contact
Name: Marina Toala<br>
Email: nicotoala@outlook.com<br>
LinkedIn: https://www.linkedin.com/in/marina-toala/
