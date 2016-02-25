# Scoreboard

Example Code Base for TDD exercises and workshops - optionally using JUnit 5.

## Task

Test-Drive an application to display and track the score of a game. 

![Scoreboard](https://github.com/jlink/scoreboard/blob/master/scoreboard.png?raw=true)

Target a UI technology of your choice -- e.g. Swing, JavaFX, Web, Console -- but keep your code open
for change of technology.

### Minimum Viable Product

- Plus and minus keys increase or decrease a team's score by 1 point
- The score is always displayed with 3 digits
- The back key rewinds the score history by a single step
- The C key resets the score to 000:000 and deletes the history

### Future Requirements

1. An external, programmable input device can be attached that will send character sequences to `stdin`
1. The current score must be written to an external file for other displays to pick up
1. Current score and history must survive an application restart


