package it.ial.termostato;

public class Termostato {

	private int[][] griglia = new int[7][24];

	private int tempMin = 8;

	private int tempMax = 28;

	private boolean acceso;

	public Termostato() {
		inizializza((tempMin + tempMax) / 2);
	}

	public Termostato(int tempMin, int tempMax) {
		this.tempMin = tempMin;
		this.tempMax = tempMax;
		inizializza((tempMin + tempMax) / 2);
	}

	public void setTemperatura(int temp, int giorno, int dalle, int alle) {
		for (int ora = dalle; ora <= alle; ora++) {
			griglia[giorno - 1][ora] = temp;
		}
	}

	private void inizializza(int temp) {
		for (int giorno = 1; giorno <= 7; giorno++) {
			setTemperatura(temp, giorno, 0, 23);
		}
	}

	public void stampa() {
		for (int giorno = 0; giorno <= 7; giorno++) {
			for (int ora = -1; ora <= 23; ora++) {
				if (ora == -1) {
					// prima colonna
					System.out.print(toGiorno(giorno) + " | ");
				} else {
					if (giorno == 0) {
						// prima riga
						System.out.print(toHour(ora) + " | ");
					} else {
						// righe interne
						System.out.print(toTemp(griglia[giorno - 1][ora]) + " | ");
					}
				}
				if (ora == 23) {
					// rine riga
					System.out.println();
				}
			}
		}
	}

	private String toHour(int numero) {
		if (numero <= 9) {
			return " " + numero + "h";
		} else {
			return "" + numero + "h";
		}
	}

	private String toTemp(int numero) {
		if (numero <= 9) {
			return " " + numero + "°";
		} else {
			return "" + numero + "°";
		}
	}

	private String toGiorno(int giorno) {
		switch (giorno) {
		case 1:
			return "lun";
		case 2:
			return "mar";
		case 3:
			return "mer";
		case 4:
			return "gio";
		case 5:
			return "ven";
		case 6:
			return "sab";
		case 7:
			return "dom";
		default:
			return "   ";
		}
	}
}
