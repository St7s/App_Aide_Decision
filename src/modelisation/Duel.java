package modelisation;

import java.util.Comparator;

public class Duel implements Comparable<Duel> {
	private int gagnant;
	private int perdant;
	private boolean isEgal;

	public static Comparator<Duel> COMPARATOR = new Comparator<Duel>() {
		@Override
		public int compare(Duel o1, Duel o2) {
			return o1.compareTo(o2);
		}
	};

	public Duel(int g, int p, boolean e) {
		this.setGagnant(g);
		this.setPerdant(p);
		this.setEgal(e);
	}

	@Override
	public String toString() {
		if (!this.isEgal())
			return this.getGagnant() + " > " + this.getPerdant();
		else
			return this.getGagnant() + " = " + this.getPerdant();
	}

	@Override
	public int compareTo(Duel o) {
		return this.gagnant - o.gagnant;
	}

	/******************** GETTERS && SETTERS **********************/
	public int getGagnant() {
		return gagnant;
	}

	public void setGagnant(int gagnant) {
		this.gagnant = gagnant;
	}

	public int getPerdant() {
		return perdant;
	}

	public void setPerdant(int perdant) {
		this.perdant = perdant;
	}

	public boolean isEgal() {
		return isEgal;
	}

	public void setEgal(boolean isEgal) {
		this.isEgal = isEgal;
	}

}
