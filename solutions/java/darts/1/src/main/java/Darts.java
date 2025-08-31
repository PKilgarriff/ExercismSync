class Darts {
  int score(double xOfDart, double yOfDart) {
    double distance = distanceToCentre(Math.abs(xOfDart), Math.abs(yOfDart));

    if (distance > 10) {
      return 0;
    } else if (distance > 5) {
      return 1;
    } else if (distance > 1) {
      return 5;
    } else {
      return 10;
    }
  }

  private double distanceToCentre(double xOfDart, double yOfDart) {
    return Math.sqrt(Math.pow(xOfDart, 2) + Math.pow(yOfDart, 2));
  }
}
