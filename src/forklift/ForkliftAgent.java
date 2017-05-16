package forklift;

import agent.Agent;
import java.io.File;
import java.io.IOException;

public class ForkliftAgent extends Agent<ForkliftState>{
    
    protected ForkliftState initialEnvironment;    
    
    public ForkliftAgent(ForkliftState environemt) {
        super(environemt);
        initialEnvironment = (ForkliftState) environemt.clone();
        heuristics.add(new HeuristicDistanceBetweenDoor());
        heuristics.add(new HeuristicObjectsBetweenDoor());
        heuristic = heuristics.get(0);
    }
            
    public ForkliftState resetEnvironment(){
        environment = (ForkliftState) initialEnvironment.clone();
        return environment;
    }
                 
    public ForkliftState readInitialStateFromFile(File file) throws IOException {
        java.util.Scanner scanner = new java.util.Scanner(file);

        int tamanho = scanner.nextInt();
        scanner.nextLine();
        
        int[][] matrix = new int [tamanho][tamanho];
        int doorRow = 0;
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                matrix[i][j] = scanner.nextInt();
                if (matrix[i][j] == 1){
                    doorRow = i;
                }
            }
            scanner.nextLine();
        }
        
        matrix[doorRow][tamanho-1] = 10;
        
        //guardar linha onde está carro e no fim da linha porta = tamanho-1
        //matrix[linha][tamanho-1] = 10;
        initialEnvironment = new ForkliftState(matrix);
        resetEnvironment();
        return environment;
    }
}
