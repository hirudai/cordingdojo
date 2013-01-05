package com.dojo.gameoflife;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LifeGameInfoTextParser implements LifeGameInfoParserInterface {

	public LifeInfo parseLifeGameInfo() {
		LifeInfo li = new LifeInfo();
		char[][] setMatrix;
		try {
			List<String> textContents = readTextFile();
			if (textContents.get(0).matches("^Generation *\\d+:$")) {
				li.setGeneration(getGeneration(textContents.get(0)));
			}
			if (textContents.get(1).matches("^\\d+ \\d+$")) {
				String[] matRowCol = textContents.get(1).split(" ");
				li.setMatRowCount(Integer.parseInt(matRowCol[0]));
				li.setMatColCount(Integer.parseInt(matRowCol[1]));
				li.initLifeMatrix();
			}

			setMatrix = li.getLifeMatrix();

			for (int lineNo = 2; lineNo < textContents.size()
					&& lineNo < li.getMatRowCount() + 2; lineNo++) {
				String lineStr = textContents.get(lineNo);
				if (lineStr.matches("^[\\.\\*]+$")) {
					for (int index = 0; index < lineStr.length(); index++) {
						setMatrix[lineNo - 2][index] = lineStr.charAt(index);
					}
				}
			}
			
			li.setLifeMatrix(setMatrix);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return li;
	}

	public List<String> readTextFile() throws IOException,
			FileNotFoundException {
		List<String> textContents = new ArrayList<String>();
		File file = new File("resource\\LifeGame.txt");
//		File file = new File("LifeGame.txt");
		FileReader filereader = new FileReader(file);
		BufferedReader br = new BufferedReader(filereader);
		String line = br.readLine();
		while (line != null) {
			textContents.add(line);
			line = br.readLine();
		}
		return textContents;
	}

	public int getGeneration(String str) {
		int begin = str.indexOf(" ");
		int end = str.indexOf(":");
		String strGen = str.substring(begin + 1, end);
		if (strGen.matches("[0-9]+")) {
			return Integer.parseInt(strGen);
		} else {
			return 0;
		}
	}

}
