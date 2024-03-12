# JavaProjectGames
# Tic Tac Toe Game

This is a simple Tic Tac Toe game implemented in Java. It allows for two modes of play: Pass&Play and against a Bot Player.

## How to Play

1. Run the `LaunchGame` class.
2. Choose the game mode:
   - Pass&Play: Two human players take turns on the same device.
   - Bot Player: Play against an AI opponent.
3. Follow the prompts to input your moves.
4. The game continues until one player wins or the game ends in a draw.

## Classes

### TicTacToe

This class represents the Tic Tac Toe game board and contains methods to initialize the board, display it, place marks, and check for wins or draws.

### Player

This is an abstract class representing a player in the game. It contains a name and a mark (X or O) and an abstract method `makeMove()` to be implemented by subclasses.

#### HumanPlayer

A subclass of Player representing a human player. It prompts the user to input their move via the console.

#### BotPlayer

A subclass of Player representing a bot player. It generates random moves within the board's constraints.

### LaunchGame

The main class to launch the game. It initializes the game, prompts the user to select the game mode, creates player instances accordingly, and manages the game flow.

## How to Compile and Run

1. Compile the Java files using `javac`:
   ```
   javac LaunchGame.java
   ```
2. Run the compiled program using `java`:
   ```
   java LaunchGame
   ```

## Contributors

- Harish Prasanth M(harish-hp)

