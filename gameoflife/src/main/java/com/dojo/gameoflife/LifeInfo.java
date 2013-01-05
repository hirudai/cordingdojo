package com.dojo.gameoflife;

public class LifeInfo {
	private char[][] lifeMatrix;
	private int generation;
	private int matColCount;
	private int matRowCount;

	public void initLifeMatrix(){
		lifeMatrix = new char[matRowCount][matColCount];
	}
	
	public char[][] getLifeMatrix() {
		return lifeMatrix;
	}
	public void setLifeMatrix(char[][] lifeMatrix) {
		this.lifeMatrix = lifeMatrix;
	}
	public int getGeneration() {
		return generation;
	}
	public void setGeneration(int generation) {
		this.generation = generation;
	}
	public int getMatColCount() {
		return matColCount;
	}
	public void setMatColCount(int matColCount) {
		this.matColCount = matColCount;
	}
	public int getMatRowCount() {
		return matRowCount;
	}
	public void setMatRowCount(int matRowCount) {
		this.matRowCount = matRowCount;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Generation " + this.generation + ":\n");
		sb.append(this.matRowCount + " " + this.matColCount + "\n");
		for(int i = 0 ; i < this.matRowCount ; i++ ){
			for(int j = 0 ; j < this.matColCount ; j++  ){
				sb.append(this.lifeMatrix[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		return sb.toString();
	} 
	
	
}
