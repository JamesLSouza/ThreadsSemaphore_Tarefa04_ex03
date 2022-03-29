package View;

import java.util.concurrent.Semaphore;
import Controller.ThreadF1;

public class Principal {

	public static String[] Voltas = { "Scuderia Ferrari | Carro 1 | Melhor volta: ",
			"Scuderia Ferrari | Carro 2 | Melhor volta: ", "Mercedes-AMG | Carro 1 | Melhor volta: ",
			"Mercedes-AMG | Carro 2 | Melhor volta: ", "McLaren | Carro 1 | Melhor volta: ",
			"McLaren | Carro 2 | Melhor volta: ", "Aston Martin | Carro 1 | Melhor volta: ",
			"Aston Martin | Carro 2 | Melhor volta: ", "Red Bull | Carro 1 | Melhor volta: ",
			"Red Bull | Carro 2 | Melhor volta: ", "Alpine | Carro 1 | Melhor volta: ",
			"Alpine | Carro 2 | Melhor volta: ", "AlphaTauri | Carro 1 | Melhor volta: ",
			"AlphaTauri | Carro 2 | Melhor volta: " };

	public static int[] QntVoltas = new int[14];

	public static void main(String[] args) {
		int carros = 5;
		int equipes = 1;

		Semaphore semaforocarros = new Semaphore(carros);
		Semaphore semaforoequipes = new Semaphore(equipes);
		for (int id = 1; id < 8; id++) {
			if(id == 1){
				String nameTeam = "Scuderia Ferrari"; 
			Thread corrida = new ThreadF1(nameTeam, semaforocarros, semaforoequipes, id);
			corrida.start();
			}
			else if(id == 2){
				String nameTeam = "Mercedes-AMG"; 
				Thread corrida = new ThreadF1(nameTeam, semaforocarros, semaforoequipes, id);
				corrida.start();
			}
			else if(id == 3){
				String nameTeam = "McLaren"; 
				Thread corrida = new ThreadF1(nameTeam, semaforocarros, semaforoequipes, id);
				corrida.start();
			}
			else if(id == 4){
				String nameTeam = "Aston Martin"; 
				Thread corrida = new ThreadF1(nameTeam, semaforocarros, semaforoequipes, id);
				corrida.start();
			}
			else if(id == 5){
				String nameTeam = "Red Bull"; 
				Thread corrida = new ThreadF1(nameTeam, semaforocarros, semaforoequipes, id);
				corrida.start();
			}
			else if(id == 6){
				String nameTeam = "Alpine"; 
				Thread corrida = new ThreadF1(nameTeam, semaforocarros, semaforoequipes, id);
				corrida.start();
			}
			else if(id == 7){
				String nameTeam = "AlphaTauri"; 
				Thread corrida = new ThreadF1(nameTeam, semaforocarros, semaforoequipes, id);
				corrida.start();
			}
			
		}

	}

}
