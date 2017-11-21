Requirements                                                                Date                                        Notes

1. It is "best of three", though I can quit mid-way through.
2. Characters: O (naught) and X (cross)
3. Players have names and scores.
4. Winner has better score. Draw is possible.
5. Interactive:
-it should accept players instructions about each move
-it should ask who begins
-it informs about session result, who’s turn it is now and the like

6.Match gives points: win 3, draw 1, loss 0. 3 matches == game.
7.Game works with square or rectangular board.
8.Player wins, if he has unbroken line of his characters,
in a row, in a column or diagonally.
9.Winning is announced in a message:
Winning O. O: 1 X: 0 (numbers are current points).
10.Game is configurable:
11.Board dimensions: 3x3, 4x4, 99x101, etc. (user provides)
12.Winning condition has variable number of characters: 3, 4, 5, etc. (user provides)
13.Game messages should have configurable target: console (System.out)
or logs (for the sake of this exercise it’s OK to make it System.err), or external printer.
14.before game starts it asks who goes first, O or X
15.We are bi-lingual: Polish and English are fine.
In future we want to add more languages:
messages are to be read from a file for chosen language.
Choosing the language depends on configuration variable.