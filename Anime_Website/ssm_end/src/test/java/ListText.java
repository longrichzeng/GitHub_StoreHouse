import java.util.ArrayList;
import java.util.List;

public class ListText {
    public static void main(String[] args){
        List All = new ArrayList();
        for(int i = 0; i < 5; i++){
            All.add(i, "A" + i);
        }
        System.out.println(All);
    }
}
