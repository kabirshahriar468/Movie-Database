# JavaFX Demo Project

A comprehensive JavaFX application demonstrating various GUI components, animations, and multi-scene application architecture with a movie management system.

## Project Overview

This project showcases different aspects of JavaFX development organized into four main modules:

- **Animation** - Interactive animations and graphics demonstrations
- **Controls** - JavaFX UI controls examples (buttons, lists, tables)
- **Single Scene** - Basic single-window application examples
- **Multi Scene** - Advanced multi-window movie management application

## Features

### Animation Module
- **Ball Simulation** - Physics-based ball animation with collision detection
- **Interactive Graphics** - Mouse and keyboard event handling
- **Frame Rate Display** - Performance monitoring and FPS counter
- **Geometric Transformations** - Rotation, scaling, and translation examples

### Controls Module
- **Basic Controls** - Buttons, text fields, labels, and other standard UI elements
- **List View** - Dynamic list management with add/remove functionality
- **Table View** - Data display in tabular format with sorting and filtering
- **Person Management** - CRUD operations demonstration

### Single Scene Module
- Simple "Hello World" JavaFX application
- Basic window management and layout

### Multi Scene Movie Management System
- **User Authentication** - Login system for access control
- **Movie Database** - Complete movie information management
- **Data Analysis** - Revenue analysis and profit calculations
- **Search & Filter** - Find movies by various criteria
- **Multi-threaded Operations** - Background data processing
- **Client-Server Architecture** - Network communication capabilities

## Technology Stack

- **JavaFX 17.0.2** - GUI framework
- **Java 17** - Programming language
- **Maven** - Build automation and dependency management
- **FXML** - Declarative UI markup
- **JUnit 5.8.2** - Unit testing framework

## Project Structure

```
src/main/java/
├── animation/          # Animation and graphics examples
│   ├── Ball.java
│   ├── BallSim.java
│   ├── FrameRate.java
│   └── JFX*.java
├── controls/           # UI controls demonstrations
│   ├── ListViewController.java
│   ├── TableViewController.java
│   └── Person.java
├── singlescene/        # Basic single window app
│   ├── Main.java
│   └── Controller.java
└── multiplescene/      # Movie management system
    ├── Main.java
    ├── *Controller.java
    ├── clientmain/
    ├── server/
    └── util/

src/main/resources/     # FXML files and assets
├── animation/
├── controls/
├── singlescene/
└── multiplescene/
```

## Prerequisites

- **Java Development Kit (JDK) 17** or higher
- **Maven 3.6+** for build management
- **JavaFX SDK** (included via Maven dependencies)

## Installation & Setup

1. **Clone the repository:**
   ```bash
   git clone <repository-url>
   cd JavaFX-Demo-Project
   ```

2. **Build the project:**
   ```bash
   mvn clean compile
   ```

3. **Run the applications:**

   ### Animation Examples:
   ```bash
   mvn exec:java -Dexec.mainClass="animation.JFXHelloWorld"
   mvn exec:java -Dexec.mainClass="animation.BallSim"
   mvn exec:java -Dexec.mainClass="animation.FrameRate"
   ```

   ### Controls Examples:
   ```bash
   mvn exec:java -Dexec.mainClass="controls.Main"
   ```

   ### Single Scene App:
   ```bash
   mvn exec:java -Dexec.mainClass="singlescene.Main"
   ```

   ### Movie Management System:
   ```bash
   mvn exec:java -Dexec.mainClass="multiplescene.Main"
   ```

   ### Using JavaFX Maven Plugin:
   ```bash
   mvn clean javafx:run
   ```

## Usage Guide

### Movie Management System

1. **Login:** Start with the login screen to access the system
2. **Home Dashboard:** Navigate through different movie operations
3. **Add Movies:** Input new movie data with validation
4. **View Movies:** Browse the complete movie database
5. **Analytics:** 
   - View total profit calculations
   - Find highest revenue movies
   - Check most recent additions
6. **Data Transfer:** Import/export movie data

### Animation Demos

- **Ball Simulation:** Watch physics-based ball movements and collisions
- **Interactive Graphics:** Use mouse and keyboard to interact with shapes
- **Transformations:** See geometric transformations in real-time

### UI Controls

- Experiment with different JavaFX controls
- Test list and table view functionalities
- Practice CRUD operations with the Person management system

## Data Format

The movie data (`movies.txt`) follows this CSV format:
```
Title,Year,Genre1,Genre2,Genre3,Runtime,ProductionCompany,Budget,Revenue
```

Example:
```
Toy Story,1995,Animation,Comedy,Family,81,Pixar Animation Studios,30000000,373554033
```

## Development Notes

- **Module System:** Uses Java 9+ module system (see `module-info.java`)
- **FXML Integration:** UI layouts defined in FXML files for better separation
- **MVC Architecture:** Controllers handle business logic, views handle presentation
- **Event-Driven:** Extensive use of JavaFX event handling
- **Threading:** Background operations for smooth UI experience

## Building & Testing

```bash
# Compile the project
mvn compile

# Run tests
mvn test

# Package the application
mvn package

# Clean build artifacts
mvn clean
```

## Troubleshooting

### Common Issues:

1. **Module Path Issues:**
   - Ensure JavaFX modules are properly configured
   - Check `module-info.java` for correct module declarations

2. **FXML Loading Errors:**
   - Verify FXML files are in the correct resource directories
   - Check controller class names match FXML fx:controller attributes

3. **Runtime Errors:**
   - Ensure JavaFX runtime is available
   - Use `mvn javafx:run` for proper module path setup

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## License

This project is for educational purposes and demonstrates JavaFX capabilities.

## Author

Student ID: 2005114
Course: L1 T2 JavaProject

---

*This project demonstrates comprehensive JavaFX development including animations, UI controls, multi-scene navigation, and data management systems.*
