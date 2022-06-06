import java.util.*;
import java.util.function.Consumer;

public class Randoms implements Iterable<Integer>{
    protected Random random;
    protected int max;
    protected int min;
    private List<Integer> list = new ArrayList<>();
    public Randoms(int min, int max){

        this.max = max;
        this.min = min;

    }

    @Override
    public Iterator<Integer> iterator() {
        random = new Random();

        return new Iterator<>(){
            boolean isList = true;
            int next = 0;


            @Override
            public boolean hasNext() {
                if (isList){
                    list.add(random.nextInt(min,max + 1));
                    if (next < list.size())
                        return true;
                }
                return false;
            }

            @Override
            public Integer next() {
                if (isList){
                   if (next < list.size()){
                       int result = list.get(next);
                       next++;
                       return result;
                    }
                }
                return 0;
            }
        };
    }

}
