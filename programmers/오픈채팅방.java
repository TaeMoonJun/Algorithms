import java.util.HashMap;
import java.util.Map;

//42888
class 오픈채팅방 {
    static String ENTER = "님이 들어왔습니다.";
    static String LEAVE = "님이 나갔습니다.";

    public String[] solution(String[] record) {
        String[] answer;
        int count = 0;
        Map<String, String> map = new HashMap<>();

        for (String r: record) {
            String[] cmd = r.split(" ");

            if (cmd[0].equals("Change")) {
                count++;
            }

            if (cmd.length == 3) {
                map.put(cmd[1], cmd[2]);
            }
        }

        answer = new String[record.length - count];
        int p = 0;
        for (String r: record) {
            String[] cmd = r.split(" ");

            if (!cmd[0].equals("Change")) {
                String str = map.get(cmd[1]);
                str += cmd[0].equals("Enter") ? ENTER : LEAVE;
                answer[p++] = str;
            }
        }

        return answer;
    }
}
