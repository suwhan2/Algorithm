import java.util.*;
import java.io.*;

class Shark{
    int r,c,s,d,z;
    boolean isDead;

    public Shark(int r, int c, int s, int d, int z, boolean isDead) {
        this.r = r;
        this.c = c;
        this.s = s;
        this.d = d;
        this.z = z;
        this.isDead = isDead;
    }
}
public class Main{
    static int[][] sea;
    static int[][] visited;
    static int riskShark=-1;
    static Shark[] sharkList;
    static int R,C,M;
    static int totalCatchSize=0;

    private static void checkRiskShark(int i){
        if(riskShark==-1 || sharkList[riskShark].r>=sharkList[i].r){
            riskShark= i;
        }
    }
    private static void move(int sharkIndex){

        Shark shark = sharkList[sharkIndex];

        //전처리
        int makeEasyR=((R-1)*2);
        int makeEasyC=((C-1)*2);
        int dir,dis,tmp;
//        System.out.println(shark.d+"방향");
        switch (shark.d){
            case 1 :
                if(shark.s>makeEasyR) shark.s = shark.s%makeEasyR;
                tmp = shark.s;
//                System.out.println("케이스 1 시작");
                if(shark.s<=shark.r){
                    //그냥 계산하고 끝
                    shark.r-=shark.s;
                    sharkList[sharkIndex] = shark;
                    break;
                }

                //일단 끝으로 이동
                if(shark.r!=0){
                    tmp-=shark.r;
                    shark.r=0;
                }

                //계산
                dir = tmp/(R-1);
                dis = tmp%(R-1);
                if(dir==0){
                    shark.d=2;
                    shark.r=dis;
                }
                if(dir==1){
                    shark.r=(R-1-dis);
                }
                if(shark.r==(R-1)) shark.d=2;
                sharkList[sharkIndex] = shark;
                break;
            case 2:
                if(shark.s>makeEasyR) shark.s = shark.s%makeEasyR;
                tmp = shark.s;
//                System.out.println("케이스 2 시작");
                if(shark.s<=(R-shark.r-1)){
                    //그냥 계산하고 끝
                    shark.r+=shark.s;
                    sharkList[sharkIndex] = shark;
//                    System.out.println("바로탈출");
                    break;
                }

                //일단 끝으로 이동
                if(shark.r!=(R-1)){
                    tmp-=(R-1-shark.r);
                    shark.r=(R-1);
                }

                //계산
                dir = tmp/(R-1);
                dis = tmp%(R-1);
                if(dir==0){
                    shark.d=1;
                    shark.r=(R-1-dis);
                }
                if(dir==1){
                    shark.r=dis;
                }
                if(shark.r==0) shark.d=1;
                sharkList[sharkIndex] = shark;
//                System.out.println("움직인 직후" +shark.r+" "+shark.c);
                break;
            case 3:
                if(shark.s>makeEasyC) shark.s = shark.s%makeEasyC;
                tmp = shark.s;
//                System.out.println("케이스 3 시작");
                if(shark.s<=(C-shark.c-1)){
                    //그냥 계산하고 끝
                    shark.c+=shark.s;
                    sharkList[sharkIndex] = shark;
                    break;
                }

                //일단 끝으로 이동
                if(shark.c!=(C-1)){
                    tmp-=(C-1-shark.c);
                    shark.c=(C-1);
                }

                //계산
                dir = tmp/(C-1);
                dis = tmp%(C-1);
                if(dir==0){
                    shark.d=4;
                    shark.c=(C-1-dis);
                }
                if(dir==1){
                    shark.c=dis;
                }
                if(shark.c==0) shark.d=4;
                sharkList[sharkIndex] = shark;
                break;
            case 4:
                if(shark.s>makeEasyC) shark.s = shark.s%makeEasyC;
                tmp = shark.s;
//                System.out.println("케이스 4 시작"+shark.s);
                if(shark.s<=shark.c){
                    //그냥 계산하고 끝
                    shark.c-=shark.s;
                    sharkList[sharkIndex] = shark;
//                    System.out.println("걍 끝남");
                    break;
                }

                //일단 끝으로 이동
                if(shark.c!=0){
                    tmp-=shark.c;
                    shark.c=0;
                }

                //계산
                dir = tmp/(C-1);
                dis = tmp%(C-1);
//                System.out.println(dir);
                if(dir==0){
                    shark.d=3;
                    shark.c=dis;
                }
                if(dir==1){
                    shark.c=(C-1-dis);
                }
                if(shark.c==(C-1)) shark.d=3;
                sharkList[sharkIndex] = shark;
                break;
        }

        //fight
        int tmpR = sharkList[sharkIndex].r;
        int tmpC = sharkList[sharkIndex].c;
        if(visited[tmpR][tmpC]==-1) visited[tmpR][tmpC]=sharkIndex;
        if(visited[tmpR][tmpC]!=-1){
            //기존이 더큼
            if(sharkList[visited[tmpR][tmpC]].z>sharkList[sharkIndex].z){
//                System.out.println("기존 상어가 이겼다.");
                sharkList[sharkIndex].isDead=true;
            }

            //새로운게 더 큼
            if(sharkList[visited[tmpR][tmpC]].z<sharkList[sharkIndex].z){
//                System.out.println("새로운 상어가 이겼다");
                sharkList[visited[tmpR][tmpC]].isDead=true;
                visited[tmpR][tmpC]=sharkIndex;

            }
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sea = new int[R][C];
        sharkList = new Shark[M];

        for(int i=0;i<M;i++){
            st= new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            Shark sharkInput = new Shark(r,c,s,d,z,false);
            sharkList[i] = sharkInput;
            if(sharkInput.c==0) checkRiskShark(i);

        }

//        move(0);
//        System.out.println(sharkList[0].r+" "+sharkList[0].c+" "+sharkList[0].d+" "+sharkList[0].s);

        for(int i=0;i<C;i++){
            //상어잡기
            if(riskShark!=-1){
//                System.out.println("잡았다"+riskShark);
                sharkList[riskShark].isDead=true;
                totalCatchSize+=sharkList[riskShark].z;
            }

            //상어 이동
            riskShark=-1;
            visited = new int[R][C];
            for(int w=0;w<R;w++){
                for(int j=0;j<C;j++){
                    visited[w][j]=-1;
                }
            }
            for(int j=0;j<M;j++){
                if(sharkList[j].isDead)continue;
                //이동
                move(j);
                // 위험상어 설정
                if(!sharkList[j].isDead && sharkList[j].c==(i+1)){
                    checkRiskShark(j);
//                    System.out.println("위험상어 = "+riskShark);
                }
//                System.out.println(sharkList[j].r+" "+sharkList[j].c+" "+ sharkList[j].d+" "+j);
            }
//            System.out.println(i);

//            System.out.println(totalCatchSize);
//            System.out.println("-------------------------------");
        }
        System.out.println(totalCatchSize);
    }
}