# AoC-Kotlin-Foundation
If you're logged in to GitHub, you can use the green "Use this template" button to create a repo based on this template under your own account - no need to fork this one.

## Features
- Input handling
- Timing of solvers

## Usage
Import build.gradle.kts as an IntelliJ project.
The "aoc2022" directory contains a folder for each challenge. Copy your input into the input.txt file in the folder, then implement your solver in the day<n>Solver.kt file. Each solver can be run as a standalone script directly from IntelliJ.
The solver framework expects the implementation to contain a *parser* block and one or more *solver* blocks. The output of the parser block is passed into each solver.

## Examples
Check out aoc2022/helloworld for a commented example and aoc2015/day1 for a solution to the first AoC challenge using the foundation.
