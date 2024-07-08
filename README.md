### ATM System Project

This project simulates an ATM system implemented in Java. It allows users to create new bank cards, perform transactions such as balance inquiries, withdrawals, deposits, and view transaction histories. Below is an overview of the project components:

#### Files Included:

- **Atm.java**: Contains the main application logic including user interface and card operations handling.
- **Card.java**: Defines the `Card` class which encapsulates card details and transaction functionalities.

#### Key Features:

1. **User Interface**: Simple console-based interface for interacting with the ATM system.
2. **Card Management**: Supports creation of new cards and storage in a HashMap.
3. **Transaction Handling**: Allows users to perform operations like balance checks, withdrawals, deposits, and view recent transaction history.
4. **Data Persistence**: Uses collections (`HashMap` for cards and `Queue` for transaction history) to store and manage card and transaction data.

#### How to Use:

1. **Compile**: Compile both `Atm.java` and `Card.java` files.

   ```
   javac Atm.java Card.java
   ```

2. **Run**: Execute the `Atm` class to start the ATM application.

   ```
   java Atm
   ```

3. **Follow On-Screen Instructions**: The application will prompt users with options to either continue with an existing card or create a new one. Subsequent options include various banking operations and the ability to exit the application.

#### Project Structure:

- **Main Class (`Atm.java`)**:

  - Manages user interaction and main control flow.
  - Uses `HashMap` to store `Card` objects keyed by card number.

- **Card Class (`Card.java`)**:
  - Represents a bank card with attributes like card number, card holder name, PIN, and balance.
  - Provides methods for balance check, deposit, withdrawal, and viewing transaction history.
  - Ensures transaction history retains only the last 5 transactions using a `Queue`.

#### Additional Notes:

- **Transaction Timestamps**: Each transaction records the date and time using Java's `LocalDateTime` and `DateTimeFormatter`.
- **Security**: PIN validation ensures secure access to card operations.
- **Input Validation**: Basic validation for withdrawal and deposit amounts (multiples of 100 or 500) is implemented.

#### Future Enhancements:

- Implement more robust error handling and edge case management.
- Integrate with a persistent data store (like databases) for more reliable data storage.
- Improve user interface for better user experience.

This ATM system project serves as a foundational implementation demonstrating basic banking functionalities in a console-based Java application.
