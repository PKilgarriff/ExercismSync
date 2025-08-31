class Bob {

  private static final String DEFAULT_RESPONSE = "Whatever.";
  private static final String SHOUTING_RESPONSE = "Whoa, chill out!";
  private static final String QUESTION_RESPONSE = "Sure.";
  private static final String SHOUTED_QUESTION_RESPONSE = "Calm down, I know what I'm doing!";
  private static final String SILENCE_RESPONSE = "Fine. Be that way!";

  String hey(String input) {
    input = input.trim();

    if (isSilence(input)) {
      return SILENCE_RESPONSE;
    } else if (isShouted(input) && isQuestion(input)) {
      return SHOUTED_QUESTION_RESPONSE;
    } else if (isShouted(input)) {
      return SHOUTING_RESPONSE;
    } else if (isQuestion(input)) {
      return QUESTION_RESPONSE;
    } else {
      return DEFAULT_RESPONSE;
    }
  }

  private boolean isQuestion(String input) {
    return input.charAt(input.length() - 1) == '?';
  }

  private boolean isShouted(String input) {
    return input.equals(input.toUpperCase()) && !input.equals(input.toLowerCase());
  }

  private boolean isSilence(String input) {
    return input.isBlank();
  }

}