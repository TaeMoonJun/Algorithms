import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//42579
class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        ArrayList<Song> list = new ArrayList<>();

        for (int i = 0; i < plays.length; i++) {
            list.add(new Song(i, plays[i]));
            if (map.containsKey(genres[i])) {
                map.put(genres[i], map.get(genres[i]) + plays[i]);
            } else {
                map.put(genres[i], plays[i]);
            }
        }

        for (int i = 0; i < plays.length; i++) {
            list.get(i).genre = map.get(genres[i]);
        }

        list.sort((o1, o2) -> {
            if (o1.genre == o2.genre) {
                if (o1.plays == o2.plays) {
                    return o1.num-o2.num;
                }
                return o2.plays -o1.plays;
            }
            return o2.genre -o1.genre;
        });

        int genre=0, count = 0;
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Song song = list.get(i);
            if (count > 1 && genre == song.genre) {
                continue;
            }
            if (genre != song.genre) {
                count=0;
                genre = song.genre;
            }
            answer.add(song.num);
            count++;
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Song{
    int genre;
    int plays;
    int num;

    Song(int num, int plays) {
        this.num = num;
        this.plays = plays;
    }
}