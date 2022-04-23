import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.io.File;

public class AI {

    private Graph<String, DefaultEdge> gameTree;

    public AI(String fileName){
        gameTree = readTreeFromFile(new File(fileName));
    }

    private SimpleWeightedGraph<String, DefaultEdge> readTreeFromFile(File file){
        return new SimpleWeightedGraph<String, DefaultEdge>(DefaultEdge.class);
    }


}