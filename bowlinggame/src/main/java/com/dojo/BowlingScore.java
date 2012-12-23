package com.dojo;

/**
 * Hello world!
 * 
 */
public class BowlingScore {
	public BowlingScore() {
	}

	public int getTotalScore(String score) {
		int totalScore = 0;
		String sc = "";
		String parsedScore = parseScore(score);
		System.out.println(score);
		System.out.println(parsedScore);
		for (int i = 0; i < parsedScore.length(); i++) {
			sc = parsedScore.substring(i, i + 1);
			if (sc.matches("\\d")) {
				totalScore += Integer.parseInt(sc);
			} else if (sc.matches("A")) {
				totalScore += 10;
			}
		}
		return totalScore;
	}

	public String parseScore(String score) {
		return parseStrike(parseSpare(parseMiss(score)));
	}

	public String parseMiss(String score) {
		StringBuffer sb = new StringBuffer();
		String sc = "";
		for (int i = 0; i < score.length(); i++) {
			sc = score.substring(i, i + 1);
			if (sc.matches("-")) {
				sb.append("0");
			} else {
				sb.append(sc);
			}
		}
		return sb.toString();
	}

	public String parseSpare(String score) {
		StringBuffer sb = new StringBuffer();
		String sc = "";
		for (int i = 0; i < score.length(); i++) {
			sc = score.substring(i, i + 1);
			if (sc.matches("/")) {
				if (i - 1 >= 0) {
					// 前の値との差分でappend
					sb.append(10 - Integer.parseInt(score.substring(i - 1, i)));
					if (i < score.length() - 2) {
						// 次の文字を余分にappend
						sb.append(score.substring(i + 1, i + 2));
					}
				} else {
					// 初回が"/"だった場合の対策
					sb.append("A");
					if (i < score.length() - 2) {
						// 次の文字を余分にappend
						sb.append(score.substring(i + 1, i + 2));
					}
				}
			} else {
				sb.append(sc);
			}
		}
		return sb.toString();
	}

	public String parseStrike(String score) {
		StringBuffer sb = new StringBuffer();
		String sc = "";
		for (int i = 0; i < score.length(); i++) {
			sc = score.substring(i, i + 1);
			if (sc.matches("X")) {
				if (i < score.length() - 2) {
					sb.append("A");

					if (score.substring(i + 1, i + 2).matches("X")) {
						sb.append("A");
					} else {
						sb.append(score.substring(i + 1, i + 2));
					}
					if (score.substring(i + 2, i + 3).matches("X")) {
						sb.append("A");
					} else {
						sb.append(score.substring(i + 2, i + 3));
					}
					if (i == score.length() - 3) {
						break;
					}
				}
			} else {
				sb.append(sc);
			}
		}
		return sb.toString();
	}
}
