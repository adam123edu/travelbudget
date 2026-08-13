# Travel Budget

A terminal-based travel budget planner built with Java. You add destinations you want to visit and manage them from a simple text menu.

## What it does

- Add a destination (name, country, price, priority)
- Show all destinations
- Show the total cost of all destinations
- Show destinations sorted by priority
- Show which destinations fit within a budget you enter
- Remove a destination

## Tech

- Java 21
- No external libraries — plain Java (Scanner for input, ArrayList for storage)

## Structure

- `Destination` — holds the data for one destination
- `DestinationManager` — stores the list and handles the logic (add, remove, total, sort, budget)
- `Menu` — the terminal menu and user input
- `Main` — starts the app

## How to run

1. Clone the repo
2. Open it in IntelliJ (or compile with `javac`)
3. Run `Main`

## About

Built by Adam as a learning project to practice core Java.