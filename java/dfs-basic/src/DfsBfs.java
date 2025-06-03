import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class DfsBfs {

    final static int MAX = 1000 + 10;
    static boolean graph[][];
    static boolean visited[];
    static ArrayList<Integer> queue;
    static int N,M,V;

    public static void dfs(int idx){
        visited[idx] = true;
        System.out.println(idx + " ");

        for(int i = 1; i <= N; i++)
            if(!visited[i] && graph[idx][i])
                dfs(i);
    }

    public static void bfs(){
        queue = new ArrayList<>();
        visited = new boolean[MAX];

        queue.add(V);
        visited[V] = true;

        while(!queue.isEmpty()){
            int idx = queue.remove(index);
            System.out.println(idx + " ");

            for(int i = 1; i <= N; i++){
                if(!visited[i] && graph[idx][i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {

        // 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // graph에 연결 정보 추가
        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

        // dfs
        dfs(V);
        System.out.println();

        // bfs
        bfs();

    }

}
