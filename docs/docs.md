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

### RunSonnetGame
#### Publics
- RunSonnetGame() -> constructor
  - args: None