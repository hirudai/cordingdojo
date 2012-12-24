package com.dojo;

/**
 * Hello world!
 * 
 */
public class BowlingScore {
	private Game g ;
	public BowlingScore() {
		g = new Game();
	}

	public int getTotalScore(String score) {
		parseIntScore(score);
		return g.score();
	}

	public void parseIntScore(String score) {
		String sc = "";
		String preSc = "";
		for (int i = 0; i < score.length(); i++) {
			sc = score.substring(i, i + 1);
			if (sc.matches("X")) {
				g.roll(10);
			} else if (sc.matches("-")) {
				g.roll(0);
			} else if (sc.matches("/")) {
				if (preSc.matches("\\d")) {
					//first roll is Spare
					g.roll(10 - Integer.parseInt(preSc));
				}else{
					//first roll is Spare (irregular case)
					g.roll(5);
					g.roll(5);
				}
			} else {
				g.roll(Integer.parseInt(sc));
			}
			preSc = sc;
		}
	}
}
