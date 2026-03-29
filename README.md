[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/pG3gvzt-)
# PCCCS495 – Term II Project

## Project Title
Student Attendance Management System
---

## Problem Statement (max 150 words)
Managing student attendance manually using registers is time-consuming and prone to human error. Teachers
must record daily attendance, calculate attendance percentages, and track students with low attendance. When
the number of students increases, maintaining these records becomes inefficient and difficult to manage. The
proposed Student Attendance Management System aims to automate this process using object oriented
programming concepts. The system will allow teachers to store student details, mark attendance, and generate
attendance reports quickly. This automated approach improves accuracy, reduces manual effort, and provides an
organized way to maintain attendance data.

---

## Target User
Teachers or academic staff responsible for managing classroom attendance.
---

## Core Features
- Add and store student information.
- Mark daily attendance (Present or Absent).
- View attendance records for each student.
- Calculate attendance percentage automatically.
- Generate attendance summary reports.

---

## OOP Concepts Used
- Abstraction: Separate classes such as Student, AttendanceRecord, and AttendanceManager.
- Inheritance: Extending base user roles such as Teacher or Admin if required.
- Polymorphism: Method overriding for report generation or data display.
- Exception Handling: Handling invalid input or missing records.
- Collections / Threads: Using ArrayList to manage student and attendance data.

---

## Proposed Architecture Description
The system will follow a modular object oriented architecture. Separate classes will represent the main entities
such as Student, AttendanceRecord, and AttendanceManager. The Student class will store basic student details,
while AttendanceRecord will maintain daily attendance information. The AttendanceManager class will control
operations including adding students, marking attendance, and generating reports. Java collections will be used to
manage data efficiently. This modular design ensures clear separation of responsibilities and demonstrates core
object oriented programming principles.
---

## How to Run
The Student Attendance Management System is developed using Java and can be executed in any standard Java-supported environment.
To run the project, the source code file is first compiled using the Java compiler. This process converts the human-readable source code into bytecode, which can be executed by the Java Virtual Machine (JVM). After successful compilation, the program is executed using the Java runtime environment.
The application is a console-based system and interacts with the user through a menu-driven interface. Users can perform various operations such as adding students, marking attendance, viewing reports, and saving data to a file.
The system requires a properly installed Java Development Kit (JDK) and can be run using any command-line interface or integrated development environment (IDE) such as Eclipse or IntelliJ IDEA.
---

## Git Discipline Notes
1. Frequent Commits
The project was developed incrementally with regular commits after completing each feature (e.g., adding student, attendance marking).
This ensures easy tracking of progress.
2. Meaningful Commit Messages
Each commit includes clear and descriptive messages such as:
“Added Student class with inheritance”
“Implemented attendance marking using HashMap”
This improves readability of version history.
3. Feature-Based Development
Features were developed step-by-step:
Basic structure → OOP implementation → Exception handling → File handling
Each feature was committed separately.
4. Version Tracking
Git was used to maintain different versions of the project.
Changes in code can be easily tracked and reviewed.
5. Code Backup and Recovery
Git provides a reliable backup of the project.
Previous versions can be restored in case of errors.
6. Branching Strategy 
Separate branches can be used for developing new features without affecting the main code.
Example:
main → stable version
feature-attendance → new feature
7. Progressive Enhancement
The project evolved gradually:
Initial basic version
Added OOP concepts
Added file handling and exception handling
Each stage was committed.
8. Bug Fix Tracking
Bugs were fixed with separate commits.
Example:
“Fixed invalid input crash using try-catch”
9. Clean Code Maintenance
Git history reflects improvements in code structure and readability.
Refactoring changes were committed properly.
10. Documentation Updates
Changes in project documentation (report, comments) were also tracked using Git.
Ensures consistency between code and report.

“Git was used effectively to maintain version control, track development progress, and ensure disciplined coding practices throughout the project lifecycle.”
