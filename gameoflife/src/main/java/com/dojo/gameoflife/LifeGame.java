package com.dojo.gameoflife;

public class LifeGame {
	
	private LifeGameInfoParserInterface parser;
	private LifeInfo li;

	public LifeGame() {
	}
	
	public void initGame(){
		li = parser.parseLifeGameInfo();
	}

	public LifeInfo nextGeneration() {
		LifeInfo nextInfo = new LifeInfo();
		nextInfo.setMatRowCount(li.getMatRowCount());
		nextInfo.setMatColCount(li.getMatColCount());
		nextInfo.initLifeMatrix();
		char[][] mat = li.getLifeMatrix();
		for (int row = 0; row < mat.length; row++) {
			for (int col = 0; col < mat[row].length; col++) {
				nextInfo.getLifeMatrix()[row][col] = getNextState(mat, row, col);
			}
		}
		nextInfo.setGeneration(li.getGeneration() + 1);
		
		return nextInfo;
	}

	public char getNextState(char[][] mat, int row, int col) {
		char nextState = '.';
		if (mat[row][col] == '*') {
			if (countAliveCell(mat, row, col) < 2) {
				nextState = '.';
			} else if (countAliveCell(mat, row, col) > 3) {
				nextState = '.';
			} else if (countAliveCell(mat, row, col) == 2
					|| countAliveCell(mat, row, col) == 3) {
				nextState = '*';
			}
		} else if (mat[row][col] == '.') {
			if (countAliveCell(mat, row, col) == 3) {
				nextState = '*';
			}
		}
		return nextState;
	}

	private int countAliveCell(char[][] mat, int row, int col) {
		int aliveCount = 0;

		for (int i = row - 1; i <= row + 1; i++) {
			if (row - 1 >= 0 && row + 1 < mat.length) {
				for (int j = col - 1; j <= col + 1; j++) {
					if (col - 1 >= 0 && col + 1 < mat[row].length) {
						if (mat[i][j] == '*') {
							aliveCount++;
						}
					}
				}
			}
		}

		return aliveCount;
	}
	
	public void setParser(LifeGameInfoParserInterface parser){
		this.parser = parser;
	}
}
