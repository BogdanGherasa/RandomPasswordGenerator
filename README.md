# Random Password Generator

A professional Java-based CLI application that generates secure, randomized passwords based on user-defined length. This project serves as a demonstration of clean code practices, effective use of the Java Standard Library, and Maven project structure.

## 🚀 Key Features

- **Dynamic Length:** Generates passwords of any length specified by the user.
- **Enhanced Security:** Combines uppercase, lowercase, numbers, and special symbols for maximum entropy.
- **Input Validation:** Handles user interaction through the `Scanner` API.
- **Optimized Performance:** Uses `StringBuilder` for efficient string manipulation.

## 🛠️ Technical Stack

- **Language:** Java 21 (LTS)
- **Build System:** Maven
- **Execution:** Terminal/Command Line

## ⚙️ Requirements

- **Java Development Kit (JDK) 21** or later.
- **Maven 3.9+** (optional for building from source).

## 🚀 Installation & Usage

### 1. Clone the Project
```bash
git clone https://github.com/your-username/RandomPasswordGenerator.git
cd RandomPasswordGenerator
```

### 2. Build with Maven
If you have Maven installed, you can package the project into an executable JAR:
```bash
mvn clean package
```

### 3. Run the Application
Navigate to the `target` folder and run the generated JAR:
```bash
java -cp target/GeneratorParole-1.0-SNAPSHOT.jar org.example.Main
```

Alternatively, you can run it directly using the Java compiler if Maven is not available:
```bash
javac -d bin src/main/java/org/example/Main.java
java -cp bin org.example.Main
```

## 📂 Project Architecture

```text
RandomPasswordGenerator/
├── src/
│   └── main/
│       └── java/
│           └── org/
│               └── example/
│                   └── Main.java     # Application entry point & logic
├── .gitignore                        # Standard exclusions
├── pom.xml                           # Maven project configuration
└── README.md                         # Documentation
```

## 📈 Future Enhancements

- **Secure Selection:** Implementing `java.security.SecureRandom` for cryptographic strength.
- **Command Line Arguments:** Support for passing parameters directly via CLI flags.
- **Multi-language Support:** Localizing the console output.

---
*Developed as a portfolio project to demonstrate core Java competencies.*
