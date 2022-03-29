package Controller;

import View.Principal;
import java.util.concurrent.Semaphore;

public class ThreadF1 extends Thread {
	private int idTeam;
	private String id;
	private Semaphore semaforoCar;
	private Semaphore semaforoTeam;
	private static int finalcorrida;

	public ThreadF1(String ids, Semaphore semaforoCarros, Semaphore semaforoEquipes, int IdTeam) {
		this.id = ids;
		this.semaforoCar = semaforoCarros;
		this.semaforoTeam = semaforoEquipes;
		this.idTeam = IdTeam;
	}

	public void run() {
		for (int i = 1; i < 3; i++) { // carroQnt = 2
			try {
				semaforoCar.acquire();
				CorridaDisputa(i);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				semaforoCar.release();
				System.out.println("O Carro " + i + " da equipe " + id + " saiu na pista");
				finalcorrida++;
			}
			if (finalcorrida == 14) {
				Grid();
			}
		}
	}

	private void CorridaDisputa(int idcarro) {
		System.out.println("O Carro " + idcarro + " da equipe " + id + " entrou na pista");
		for (int voltas = 1; voltas < 4; voltas++) {
			int Time = ((int) (Math.random() * 200) + 100);
			;
			try {
				sleep(Time * 30);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(
					"Equipe: " + id + "; Carro: " + idcarro + "; Volta: " + voltas + "; Tempo: " + Time + " segundos.");
			try {
				semaforoTeam.acquire();
				if (Time < Principal.QntVoltas[(2 * idTeam) - idcarro]
						|| Principal.QntVoltas[(2 * idTeam) - idcarro] == 0) {

					Principal.QntVoltas[(2 * idTeam - 2 + idcarro) - 1] = Time;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				semaforoTeam.release();
			}
			System.out.println("------------Tempo armazenado--------- ");
		}
	}

	private void Grid() {
		int aux; // auxiliar de valores, para inversão de variaveis
		String auxiliar;
		for (int i = 0; i < 13; i++) {
			for (int j = i + 1; j < 14; j++) {
				if (Principal.QntVoltas[i] > Principal.QntVoltas[j]) {
					aux = Principal.QntVoltas[i];
					Principal.QntVoltas[i] = Principal.QntVoltas[j];
					Principal.QntVoltas[j] = aux;
					auxiliar = Principal.Voltas[i];
					Principal.Voltas[i] = Principal.Voltas[j];
					Principal.Voltas[j] = auxiliar;
				}
			}
		}
		for (int i = 0; i < 14; i++) {
			System.out.println("Posição " + (i + 1) + ": " + Principal.Voltas[i] + Principal.QntVoltas[i] + " segundos");
		}
	}

}
