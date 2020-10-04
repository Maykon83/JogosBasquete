import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.html.MinimalHTMLWriter;

public class JogosBasquete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int escolha = 0;
		int placar;
		Jogo jogoAux;
		int minJogoPlacar = 0;
		int maxJogoPlacar = 0;
		int minJogoRecord = 0;
		int maxJogoRecord = 0;
		List<Jogo> jogos = new ArrayList<Jogo>();
		Scanner tec = new Scanner(System.in);	
		
		
		
		while(escolha != 3){
			minJogoPlacar = 0;
			maxJogoPlacar = 0;
			minJogoRecord = 0;
			maxJogoRecord = 0;
			
			
			
			System.out.println("Escolha uma opção:");
			System.out.println("[1] Incluir Jogo:");
			System.out.println("[2] Listar Jogos:");
			System.out.println("[3] Sair:");
					
			escolha = tec.nextInt();
			
			switch(escolha){
				case 1:
					JogosBasquete.limparTela();
					String jogoStr = String.format("informe o placar do jogo ( %d ):", jogos.size() + 1);
					System.out.println(jogoStr);
					placar = tec.nextInt();
					jogoAux = new Jogo(placar, jogos.size() + 1);
					
					if(jogos.isEmpty()){
						jogoAux.setMinTemp(placar);
						jogoAux.setMaxtemp(placar);
						jogoAux.setMinRecord(0);
						jogoAux.setMaxRecord(0);
					} else {
						for (Jogo jogoObj : jogos) {
							//obtendo placar mínimo
							if(minJogoPlacar == 0) {
								minJogoPlacar = jogoObj.getPlacar();
							} else if(jogoObj.getPlacar() < minJogoPlacar ) {
								minJogoPlacar = jogoObj.getPlacar();
								
							}
							//obtendo placar maximo
							if(maxJogoPlacar == 0) {
								maxJogoPlacar = jogoObj.getPlacar();
							} else if(jogoObj.getPlacar() > maxJogoPlacar ) {
								maxJogoPlacar = jogoObj.getPlacar();
								
							}
							//obtendo Recordes minimo e maximo
							
							if(jogoObj.getMinRecord() > minJogoRecord ) {
								minJogoRecord = jogoObj.getMinRecord();		
							}			
							if(jogoObj.getMaxRecord() > maxJogoRecord ) {
								maxJogoRecord = jogoObj.getMaxRecord();
							}
						}
						
						if(placar < minJogoPlacar) {
							minJogoPlacar = placar;
							minJogoRecord++;
						}
						if(placar > maxJogoPlacar) {
							maxJogoPlacar = placar;
							maxJogoRecord++;
						}
						
						jogoAux.setMinTemp(minJogoPlacar);
						jogoAux.setMaxtemp(maxJogoPlacar);
						jogoAux.setMinRecord(minJogoRecord);
						jogoAux.setMaxRecord(maxJogoRecord);
						
					}
					
					jogos.add(jogoAux);
					System.out.println("Jogo adicionado com sucesso!");
										
					break;
				case 2:
					JogosBasquete.limparTela();
					List<List<String>> rows = new ArrayList<>();
					List<String> headers = Arrays.asList("Jogo", "Placar", "Minimo da Temporada", "Maximo da Temporada", "Quebra Recorde min.", "Quebra recorde max.");
					rows.add(headers);
					
					for (Jogo jogoObj : jogos) {
						rows.add(Arrays.asList(
							String.valueOf(jogoObj.getNumJogo()),
							String.valueOf(jogoObj.getPlacar()),
							String.valueOf(jogoObj.getMinTemp()),
							String.valueOf(jogoObj.getMaxtemp()),
							String.valueOf(jogoObj.getMinRecord()),
							String.valueOf(jogoObj.getMaxRecord())
						));
					}
					
					System.out.println(JogosBasquete.formatAsTable(rows));
					
					break;
				case 3: 
					break;
				default:
				
				
			}
		}
	
	}

	public static void limparTela() {
		 if (System.getProperty("os.name").contains("Windows"))
			try {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			try {
				Runtime.getRuntime().exec("clear");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public static String formatAsTable(List<List<String>> rows)
	{
	    int[] maxLengths = new int[rows.get(0).size()];
	    for (List<String> row : rows)
	    {
	        for (int i = 0; i < row.size(); i++)
	        {
	            maxLengths[i] = Math.max(maxLengths[i], row.get(i).length());
	        }
	    }

	    StringBuilder formatBuilder = new StringBuilder();
	    for (int maxLength : maxLengths)
	    {
	        formatBuilder.append("%-").append(maxLength + 2).append("s");
	    }
	    String format = formatBuilder.toString();

	    StringBuilder result = new StringBuilder();
	    for (List<String> row : rows)
	    {
	        result.append(String.format(format, row.toArray(new String[0]))).append("\n");
	    }
	    return result.toString();
	}
	
}
