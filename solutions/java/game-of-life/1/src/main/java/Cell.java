public class Cell {
  private boolean isAlive;
  private int livingNeighbours;

  public Cell(boolean isAlive, int livingNeighbours) {
    this.isAlive = isAlive;
    this.livingNeighbours = livingNeighbours;
  }

  public boolean shouldBeAliveNextTick() {
    // Any dead cell with exactly three live neighbors becomes a live cell.
    boolean isDeadShouldBeAlive = !this.isAlive && this.livingNeighbours == 3;
    // Any live cell with two or three live neighbors lives on.
    boolean isAliveShouldBeAlive = this.isAlive && (this.livingNeighbours == 2 || this.livingNeighbours == 3);
    // All other cells die or stay dead.
    return isDeadShouldBeAlive || isAliveShouldBeAlive;
  }

}