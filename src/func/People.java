import javax.lang.model.element.Name;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by Vadim on 24.02.2016.
 */
public class People{

    private String name;
    private int weight;
    private int height;

    public People(String string) {
        StringTokenizer string_token = new StringTokenizer(string);
        this.name = string_token.nextToken();
        this.weight = Integer.parseInt(string_token.nextToken());
        this.height = Integer.parseInt(string_token.nextToken());
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void print(){
        System.out.println(name + " " + weight + " " + height);
    }

   /* public int compareTo(People p) {
        int result = this.name.compareTo(p.name);
        return result;
    }*/

   /*
        public int compare (People p1, People p2){
        int result = p1.name.compareTo(p2.name);
        if(result != 0) {
            return result;
        }
        result = Integer.compare(p1.weight,p2.weight);
        if(result != 0) {
            return result;
        }
        result = Integer.compare(p1.height,p2.height);
        if(result != 0)
        {
            return result;
        }
        else
        {
            return  0;
        }

    }*/


   /* Comparator<People> by_weight = new Comparator<People>() {

        public int compare(People o1, People o2) {
            return o1.weight.compareTo(o2.weight);
        }
    }

    Comparator<People> by_height = new Comparator<People>() {

        public int compare(People o1, People o2) {
            return o1.weight.compareTo(o2.weight);
        }
    }*/

}


