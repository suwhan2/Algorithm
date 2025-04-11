public class Main {
    private static int calculate(int n ){
        int sum=n;
        String s = String.valueOf(n);
        for(int i=0;i<s.length();i++){sum+=(s.charAt(i)-'0');}
        return sum;
    }

    public static void main(String[] args){
        boolean[] check = new boolean[10001];
        for(int i=1;i<=10000;i++){
            int n = i;
            if(check[n]) continue;
            while(n<=10000){
                n=calculate(n);
                if(n>10000) break;
                check[n]=true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=10000;i++){
            if(!check[i]) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}