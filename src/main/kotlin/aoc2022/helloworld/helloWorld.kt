package aoc2022.helloworld

import challenge

suspend fun main() {
    //The type arguments specify what kind of data the solvers operate on
    challenge<List<String>> {

        //Specifying day defines which input file to use
        day(0)

        //The code block in parser takes an input file (it)
        //and must be implemented such that it returns a value
        //matching the type argument given to challenge, in
        //this case List<String>
        parser {
            //it.readLines()
            emptyList()
        }

        //The code block in the solver takes an input (it)
        //of the type specified in the type argument and returns
        //a string representation of the solution
        solver {
            "Hello,"
        }

        //You can define as many solver blocks as you like.
        //They will all be run sequentially on the parsed
        //input. Generally you will have a solver block for
        //part 1 and one for part 2
        solver {
            "World!"
        }
    }
}