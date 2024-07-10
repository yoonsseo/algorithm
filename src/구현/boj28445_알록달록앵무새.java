package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class boj28445_알록달록앵무새 {
    static Set<String> colour = new HashSet<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        colour.add(st.nextToken());
        colour.add(st.nextToken());
        st = new StringTokenizer(br.readLine());
        colour.add(st.nextToken());
        colour.add(st.nextToken());

        List<String> colours = colour.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < colours.size(); i++) {
            for (int j = 0; j < colours.size(); j++) {
                System.out.println(colours.get(i) + " " + colours.get(j));
            }
        }

    }
}
