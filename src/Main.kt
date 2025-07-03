fun main() {
    val winner = winner(userInput(), computerChoice())

    if (winner == "Tie") {
        println("The match was a $winner")
    }
    else {
        println("$winner won the match")
    }
}

// prompts the use input and returns in lowercase
private fun input(): String {
    print("Rock, Paper or Scissors? Enter your choice: ")
    return readln().lowercase()
}

// returns the actual user input in lowercase after checking if it's valid or not
fun userInput(): String {
    var userInput = input()

    // checks for incorrect user input and asks for input until the user enters a valid input
    while ((userInput != "rock") && (userInput != "paper") && (userInput != "scissors")) {
        println("Wrong choice. Please enter again.")
        userInput = input()
    }

    return userInput
}

// returns random generated computer choice
fun computerChoice(): String {
    return when ((1..3).random()) {
        1 -> "rock"
        2 -> "paper"
        else -> "scissors"
    }
}

// returns the winner
fun winner(userInput: String, computerChoice: String):String {

    println("Computer chose: $computerChoice")

    // checks for tie
    if (userInput == computerChoice) {
        return "Tie"
    }

    // checks for the winner
    return when (userInput) {
        "rock" -> when (computerChoice) {
            "paper" -> "Computer"
            else -> "User"
        }

        "paper" -> when (computerChoice) {
            "rock" -> "User"
            else -> "Computer"
        }

        else -> when (computerChoice) {
            "rock" -> "Computer"
            else -> "User"
        }
    }
}