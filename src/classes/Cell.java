package classes;

public class Cell {
	private int x;
	private int y;
	private boolean alive;
	private int aliveNeighbors;

	public Cell() throws NegativeCoordinateException {
	}

	public Cell(int i, int j, boolean b) {
		this.x = i;
		this.y = j;
		this.alive = b;
		this.aliveNeighbors = 0;
	}

	public void setNumberOfAliveNeighbors(Cell[][] cells) {
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				if (cells[i][j] != this && cells[i][j] != null && cells[i][j].alive
						&& (cells[i][j].x == i && cells[i][j].y == j)) {
					aliveNeighbors++;
				}
			}
		}
	}

	public int getNumberOfAliveNeighbords() {
		return this.aliveNeighbors;
	}

	public boolean willSurvive() {
		boolean result = false;

		if (this.alive && (this.getNumberOfAliveNeighbords() == 2 || this.getNumberOfAliveNeighbords() == 3))
			result = true;

		return result;
	}

	public boolean willDie() {
		boolean result = false;

		if (this.alive && (this.getNumberOfAliveNeighbords() > 3 || this.getNumberOfAliveNeighbords() < 2)) {
			result = true;
		}

		return result;
	}

	public boolean willRevive() {
		boolean result = false;

		if (!this.alive && this.getNumberOfAliveNeighbords() >= 3)
			result = true;

		return result;
	}

	/*private boolean isNeighbor(Cell cell) {
		boolean result = false;

		if ((cell.x == this.x + 1 && cell.y == this.y) || (cell.x == this.x && cell.y == this.y + 1)
				|| (cell.x == this.x + 1 && cell.y == this.y + 1) || (cell.x == this.x - 1 && cell.y == this.y)
				|| (cell.x == this.x && cell.y == this.y - 1) || (cell.x == this.x - 1 && cell.y == this.y - 1))
			result = true;

		return result;
	}*/
}
