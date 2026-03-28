# X and O (Tic-Tac-Toe Game)

A classic Tic-Tac-Toe game implemented in Java using Swing GUI framework.

## Features

- **Interactive GUI**: Clean, user-friendly graphical interface
- **Two-Player Gameplay**: Alternating turns between X and O players
- **Win Detection**: Automatically detects wins in all directions (horizontal, vertical, diagonal)
- **Tie Detection**: Handles draw games when the board is full
- **Score Tracking**: Keeps track of wins for each player (XandO2 version)
- **New Game Button**: Restart functionality to play multiple rounds (XandO2 version)
- **Visual Feedback**: Color-coded winning tiles and status messages

## Project Structure

```
XandO/
├── src/
│   ├── App.java          # Main entry point (runs XandO2)
│   ├── XandO.java        # Basic Tic-Tac-Toe implementation
│   └── XandO2.java       # Enhanced version with score tracking
├── bin/                  # Compiled class files
├── lib/                  # Dependencies (if any)
└── README.md            # This file
```

## How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Visual Studio Code with Java extensions (recommended)

### Running the Game
1. Open the project in VS Code
2. Compile the Java files:
   ```bash
   javac -d bin src/*.java
   ```
3. Run the application:
   ```bash
   java -cp bin App
   ```

The game window will open, and you can start playing immediately.

## Game Rules

- Players take turns placing X's and O's on a 3x3 grid
- The first player to get 3 marks in a row (horizontally, vertically, or diagonally) wins
- If all 9 squares are filled without a winner, the game is a tie
- Click on any empty square to make your move

## Versions

- **XandO.java**: Basic implementation with win/tie detection
- **XandO2.java**: Enhanced version with score tracking and restart functionality

## Technologies Used

- Java
- Swing (GUI framework)
- AWT (Abstract Window Toolkit)

## Future Enhancements

- AI opponent for single-player mode
- Customizable board sizes
- Sound effects
- Save/load game functionality
