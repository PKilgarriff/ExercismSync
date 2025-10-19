import io.reactivex.Observable;

class Hangman {

  Observable<Output> play(Observable<String> words, Observable<String> letters) {
    Game game = new Game();
    return words
        .map(game::newGame)
        .mergeWith(letters.map(game::makeGuess));
  }
}