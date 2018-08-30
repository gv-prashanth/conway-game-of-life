package com.vadrin.conwaygameoflife.services;

import com.vadrin.conwaygameoflife.models.Cell;

public class World {

	private Cell[][] cells;

	public World(int xSize, int ySize) {
		super();
		cells = new Cell[xSize][ySize];
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				cells[i][j] = new Cell();
			}
		}
	}

	public void tick() {
		Cell[][] tempCells = createTemp();
		for (int i = 0; i < tempCells.length; i++) {
			for (int j = 0; j < tempCells[i].length; j++) {
				// Rule1
				if (tempCells[i][j].isAlive() && getNumberOfAliveNeighbours(tempCells, i, j) < 2) {
					cells[i][j].markDead();
				}
				// Rule3
				if (tempCells[i][j].isAlive() && getNumberOfAliveNeighbours(tempCells, i, j) > 3) {
					cells[i][j].markDead();
				}
				// Rule4
				if (!tempCells[i][j].isAlive() && getNumberOfAliveNeighbours(tempCells, i, j) == 3) {
					cells[i][j].markAlive();
				}
			}
		}
	}

	// public void paint(Graphics g) {
	// for (int i = 0; i < cells.length; i++) {
	// for (int j = 0; j < cells[i].length; j++) {
	// if (cells[i][j].isAlive()) {
	// g.fillRect(5 * i, 5 * j, 5, 5);
	// } else {
	// g.drawRect(5 * i, 5 * j, 5, 5);
	// }
	// }
	// }
	// }

	public void setLive(int x, int y) {
		cells[x][y].markAlive();
	}

	private Cell[][] createTemp() {
		Cell[][] tempCells = new Cell[cells.length][cells[0].length];
		for (int i = 0; i < tempCells.length; i++) {
			for (int j = 0; j < tempCells[i].length; j++) {
				tempCells[i][j] = new Cell();
				if (cells[i][j].isAlive()) {
					tempCells[i][j].markAlive();
				}
			}
		}
		return tempCells;
	}

	private int getNumberOfAliveNeighbours(Cell[][] tc, int x, int y) {
		int toReturn = 0;
		try {
			if (tc[x - 1][y - 1].isAlive()) {
				toReturn++;
			}
		} catch (Exception ex) {

		}
		try {
			if (tc[x][y - 1].isAlive()) {
				toReturn++;
			}
		} catch (Exception ex) {

		}
		try {
			if (tc[x + 1][y - 1].isAlive()) {
				toReturn++;
			}
		} catch (Exception ex) {

		}
		try {
			if (tc[x - 1][y].isAlive()) {
				toReturn++;
			}
		} catch (Exception ex) {

		}
		try {
			if (tc[x + 1][y].isAlive()) {
				toReturn++;
			}
		} catch (Exception ex) {

		}
		try {
			if (tc[x - 1][y + 1].isAlive()) {
				toReturn++;
			}
		} catch (Exception ex) {

		}
		try {
			if (tc[x][y + 1].isAlive()) {
				toReturn++;
			}
		} catch (Exception ex) {

		}
		try {
			if (tc[x + 1][y + 1].isAlive()) {
				toReturn++;
			}
		} catch (Exception ex) {

		}
		return toReturn;
	}

	public Cell[][] getCells() {
		return cells;
	}

}
