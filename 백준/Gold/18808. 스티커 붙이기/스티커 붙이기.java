import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static int noteBook[][], sticker[][],tmp[][];
	static int stickerN, stickerM;
	static boolean can=false;
	private static void turn() {
		int tmp[][] = new int[stickerM][stickerN];
		for(int i=0;i<stickerM;i++) {
			for(int j=0;j<stickerN;j++) {
				tmp[i][j] =sticker[stickerN-1-j][i];
			}
		}
		int tmpI = stickerN;
		stickerN = stickerM;
		stickerM =tmpI;
		sticker = tmp;	
	}
	private static boolean inRange(int x,int y) {
		return 0<=x && x<N&&0<=y&&y<M;
	}
	private static void put(int x,int y) {
			boolean out =false;
			if(!inRange(x+stickerN-1, y+stickerM-1)) {
				return;
			}
			for(int j=x;j<(x+stickerN);j++) {
				for(int k=y;k<(y+stickerM);k++) {
					if(noteBook[j][k]==1 && sticker[j-x][k-y]==1) {
						out=true;
						break;
					}
				}
				if(out) break;
			}
			if(out) return;
			can=true;
			for(int j=x;j<(x+stickerN);j++) {
				for(int k=y;k<(y+stickerM);k++) {
					if(sticker[j-x][k-y]==1) {
						noteBook[j][k] = sticker[j-x][k-y];
					}
				}
			}
			
		}
	
	private static void findPosition() {
		for(int q=0;q<4;q++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
						put(i,j);
						if(can) return;
				}
			}
			turn();
		}
	}
    public static void main(String[] args) throws IOException {
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	//입력부
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	noteBook = new int[N][M];
    	for(int i=0;i<K;i++) {
    		StringTokenizer st2 = new StringTokenizer(br.readLine());
    		stickerN =Integer.parseInt(st2.nextToken());
    		stickerM =Integer.parseInt(st2.nextToken());
    		sticker = new int[stickerN][stickerM];
    		for(int j=0;j<stickerN;j++) {
    			StringTokenizer st3= new StringTokenizer(br.readLine());
    			for(int k=0;k<stickerM;k++) {
    				sticker[j][k] = Integer.parseInt(st3.nextToken());
    			}
    		}
    		//기능부
    		findPosition();
    		can=false;
    	}
    	//출력부
    	int count=0;
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<M;j++) {
    			if(noteBook[i][j]==1) {
    				count++;
    			}
    		}
    	}
    	System.out.println(count);
    }
}
