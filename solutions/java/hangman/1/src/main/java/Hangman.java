import java.util.Set;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

class Hangman {

  Observable<Output> play(Observable<String> words, Observable<String> letters) {
    // output needs to subscribe to the list of words?
    // output needs to subscribe to the list of letters?

    Observer<String> wordObserver = new Observer<>() {
      @Override
      public void onSubscribe(Disposable d) {
      }

      @Override
      public void onNext(String t) {
        System.out.println("New word: " + t);
      }

      @Override
      public void onError(Throwable e) {
      }

      @Override
      public void onComplete() {
      }
    };

    Observer<String> letterObserver = new Observer<>() {
      @Override
      public void onSubscribe(Disposable d) {
      }

      @Override
      public void onNext(String t) {
        System.out.println("New letter: " + t);
      }

      @Override
      public void onError(Throwable e) {
      }

      @Override
      public void onComplete() {
      }
    };

    words.subscribe(wordObserver);
    letters.subscribe(letterObserver);

    return Observable.fromArray(Output.empty());
  }

  // as a word comes in a new instance of the Hangman class should be created
  // no don't do this because the tests only create one

}

class Game {
  String word;
  Set<String> guesses;
  Set<String> misses;

  Game(String word) {
    this.word = word;
  }

  void guess(String input) {
    if (guesses.contains(input) || misses.contains(input))
      throw new IllegalArgumentException("Letter " + input + " was already played");

    if (word.contains(input)) {
      guesses.add(input);
    } else {
      misses.add(input);
    }
  }

  String getDiscovered() {
    StringBuilder discoveredBuilder = new StringBuilder(word.length());

    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (guesses.contains(String.valueOf(c))) {
        discoveredBuilder.append(c);
      } else {
        discoveredBuilder.append('_');
      }
    }

    return discoveredBuilder.toString();
  }

}