package Programmers;

import java.util.ArrayList;
import java.util.List;

public class 양과_늑대 {

    static int sheep = 0;
    List<Node> nodes = new ArrayList<>();

    public int solution(int[] info, int[][] edges) {

        for (int i = 0; i < info.length; i++) {
            nodes.add(new Node(info[i]));
        }

        for (int i = 0; i < edges.length; i++) {
            nodes.get(edges[i][0]).childs.add(nodes.get(edges[i][1]));
        }

        List<Node> route = nodes.get(0).childs;

        for (int i = 0; i < info.length; i++) {
            search(nodes.get(0), 0, 0, route);
        }

        return sheep;
    }

    public void search(Node node, int sheepCount, int wolfCount, List<Node> routes) {
        if (node.isWolf == 0) sheepCount++;
        else wolfCount++;

        if (sheepCount <= wolfCount) {
            return;
        }
        sheep = Math.max(sheep, sheepCount);


    }

    public class Node {
        List<Node> childs;
        int isWolf;

        public Node(int isWolf) {
            this.isWolf = isWolf;
        }
    } // Node ends
}
