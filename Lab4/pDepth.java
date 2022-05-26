import java.util.Objects;

public class pDepth {
    public static int maxDepth(String s) {
        if(Objects.equals(s, "") ||((s.length()==1)&&(!s.equals("(") && !s.equals(")")))){
            return 0;
        }
        int aux = 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            if (s.charAt(i)=='('){
                aux++;
            }else if(s.charAt(i)==')'){
                max = Math.max(max,aux);
                aux--;
            }else if(s.charAt(i)!='('&&s.charAt(i)!=')'){
                max = Math.max(max,aux);
            }
        }
        return max;
    }
}
