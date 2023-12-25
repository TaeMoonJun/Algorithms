import java.util.HashSet;
import java.util.List;
import java.util.Set;

//72410
// 구현   문자열
class 신규아이디추천 {
    public String solution(String new_id) {
        Set<Character> set = new HashSet<>(List.of(new Character[]{'-', '_', '.'}));

        StringBuilder id = new StringBuilder();

        //1. 대문자 -> 소문자
        new_id = new_id.toLowerCase();

        //2. 비허용 문자 제외
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);

            if ((c >= 'a' && c <= 'z') || Character.isDigit(c) || set.contains(c)) {
                id.append(c);
            }
        }

        //3. .. -> .으로 치환
        for (int i = 0; i < id.length() -1; i++) {
            char c = id.charAt(i);

            if (c == '.') {
                while (i+1 < id.length() && id.charAt(i + 1) == '.') {
                    id.deleteCharAt(i + 1);
                }
            }
        }

        //4. 처음이나 끝의 . 제거
        if (id.charAt(0) == '.') {
            id.deleteCharAt(0);
        }
        if (id.length() >= 1 && id.charAt(id.length() - 1) == '.') {
            id.deleteCharAt(id.length() - 1);
        }

        //5. 빈 문자열이면 a 대입
        if (id.length() == 0) {
            id.append('a');
        }

        //6. 16자 이상이면 뒤에 자르고 .이면 또 삭제
        if (id.length() >= 16) {
            id.delete(15, id.length());
            while (id.charAt(id.length() - 1) == '.') {
                id.deleteCharAt(id.length() - 1);
            }
        }

        //7. 2자 이하면 마지막 문자 반복
        if (id.length() <= 2) {
            id.append(id.charAt(id.length() - 1));
            if (id.length() <= 2) {
                id.append(id.charAt(id.length() - 1));
            }
        }

        return id.toString();
    }
}