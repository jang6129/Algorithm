package Programmers;

import java.util.ArrayList;
import java.util.Collections;

public class 여행경로 {
    // 완성된 경로들을 여기에 담고 이후에 앞쪽부터 알파벳 순으로 비교해준다.
    public ArrayList<String> routes = new ArrayList<>();
    public boolean[] visited;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        dfs("ICN", tickets, "ICN", 0);

        Collections.sort(routes);

        return routes.get(0).split(" ");
    } // solution ends

    // DFS를 돌며 경로를 탐색하고, count에 티켓 수 만큼 누적되면 return한다.
    public void dfs(String cur, String[][] tickets, String route, int count) {
        if (count == tickets.length) {
            routes.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (cur.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], tickets, route + " " + tickets[i][1], count + 1);
                visited[i] = false;
            }
        }

    } // dfs ends
}
