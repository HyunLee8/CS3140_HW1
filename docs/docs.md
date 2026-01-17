# Documentation

I split this program into two classes; PreprocessGame which is the game
optimizer/randomizer and RunSonnetGame which actually runs the game. This
could've easily been built in the main function but for the purpose of
making modular code and practicing potential for
bigger changes I decided refractor a bit.

## Classes

### PreprocessGame
#### Publics
- PreprocessGame(String sonnet) -> Constructor
  - args: String sonnet
- getSonnetSubString() -> gets the random size substring
  - args: None
- randomize() -> randomizes current Index and gets new substring
  - args: None
#### Privates
- convertStringToArray(String sonnet) -> make indexing for sonnet
  - args: String sonnet
- getRandomIndex() -> generates random length of substring but never the same as before
  - args: None
- makeSonnetSubstring() -> this assigns the new randomized to this.sonnetSubstring

### RunSonnetGame
#### Publics
- RunSonnetGame() -> constructor
  - args: None
#### Privates
- runGame() -> runs the game loop
  - args: None



## Testing
 - Manual Testing was made for this program. By getting the reference of the last string and the answer print the two. Also print a case were both would not be equal to eachother such as indexing to the left once. It will display a false statement.