package Programmers;

import java.util.PriorityQueue;
import java.util.Stack;

public class 과제_진행하기 {

    class Plan {
        String name;
        int start;
        int playtime;

        public Plan(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    } // Plan ends

    public int convertToMinute(String s) {
        String[] divider = s.split(":");
        int hour = Integer.parseInt(divider[0]);
        int minute = Integer.parseInt(divider[1]);

        return hour * 60 + minute;
    } // converToMinute ends

    public String[] solution(String[][] plans) {
        PriorityQueue<Plan> q = new PriorityQueue<>((o1, o2) -> o1.start - o2.start);
        Stack<Plan> stack = new Stack<>();
        String[] answer = new String[plans.length];

        // 큐에 객체 넣어주기
        for (String[] plan : plans) {
            String name = plan[0];
            int start = convertToMinute(plan[1]);
            int playtime = Integer.parseInt(plan[2]);
            q.add(new Plan(name, start, playtime));
        }

        int counter = 0;
        while (!(q.isEmpty() && stack.isEmpty())) {
            // plan이 모두 끝나고 하던 일들만 남은 경우
            if (q.isEmpty()) {
                answer[counter] = stack.pop().name;
                counter++;
            }
            // plan이 아직 끝나지 않은 경우
            else {
                Plan cur = q.poll();
                // 다음 plan이 없는 경우
                if (q.isEmpty()) {
                    answer[counter] = cur.name;
                    counter++;
                }
                // 다음 plan이 있는 경우
                else {
                    Plan next = q.peek();
                    int timeEnd = cur.start + cur.playtime;
                    // 현재 plan이 끝나기 전에 다음 plan이 있는 경우
                    if (timeEnd > next.start) {
                        stack.push(new Plan(cur.name, Integer.MAX_VALUE, timeEnd - next.start));
                    }
                    // 딱 끝난 경우
                    else if (timeEnd == next.start) {
                        answer[counter] = cur.name;
                        counter++;
                    }
                    // 현재 plan과 다음 plan 사이에 시간이 뜨는 경우
                    else if (timeEnd < next.start) {
                        answer[counter] = cur.name;
                        counter++;
                        while (timeEnd < next.start && !stack.isEmpty()) {
                            Plan middle = stack.pop();
                            timeEnd += middle.playtime;
                            // plan을 완료하고도 시간이 뜨는 경우
                            if (timeEnd <= next.start) {
                                answer[counter] = middle.name;
                                counter++;
                            }
                            // plan을 완료하기 전에 다음 plan이 시작되는 경우
                            else {
                                stack.push(new Plan(middle.name, Integer.MAX_VALUE, timeEnd - next.start));
                            }
                        }
                    }
                }
            }

        }


        return answer;
    } // solution ends
}
