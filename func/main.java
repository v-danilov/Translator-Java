import java.io.*;
import java.util.ArrayList;

public class Main {

    private static PrintWriter pw = null;
    private static File table = new File("table.txt");

    public static void main(String[] args) {
        add_1();//Волков 59 176
delete_1(); //
delete_2(); //(n="Новиков" and w=42) or (n="Шершов" and h=171)
delete_3(); //n="Муравьева"
delete_4(); //w=100
delete_1(); //
display_1();//
display_2();//n="Титова"
display_3();//w=66
add_2();//Шипарев 67 150
display_4();//h=179
sort_1();//n,w,h
display_1();//

    }

     public static void add_1() {
            try {
                pw = new PrintWriter(new FileWriter(table.getAbsoluteFile(), true));
                pw.write("Волков 59 176" + "\n" );
                pw.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
    }
public static void delete_1() {
        int i = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(table.getAbsoluteFile()));

            String s;
            ArrayList<People> ppl = new ArrayList<>();
            ArrayList<String> output_list = new ArrayList<>();

            while ((s = in.readLine()) != null) {
                ppl.add(new People(s));
                if (!(false)){
                    output_list.add(s);
                }
                i++;
            }
            in.close();
            pw = new PrintWriter(new FileWriter(table.getAbsoluteFile()));
            int size = output_list.size();
            for(int j = 0; j < size - 1; j++){
                pw.write(output_list.get(j) + "\n");
            }
            pw.close();
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
public static void delete_2() {
        int i = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(table.getAbsoluteFile()));

            String s;
            ArrayList<People> ppl = new ArrayList<>();
            ArrayList<String> output_list = new ArrayList<>();

            while ((s = in.readLine()) != null) {
                ppl.add(new People(s));
                if (!((ppl.get(i).getName().equals("Новиков") && ppl.get(i).getWeight()==42) || (ppl.get(i).getName().equals("Шершов") && ppl.get(i).getHeight()==171))){
                    output_list.add(s);
                }
                i++;
            }
            in.close();
            pw = new PrintWriter(new FileWriter(table.getAbsoluteFile()));
            int size = output_list.size();
            for(int j = 0; j < size; j++){
                pw.write(output_list.get(j) + "\n");
            }
            pw.close();
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
public static void delete_3() {
        int i = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(table.getAbsoluteFile()));

            String s;
            ArrayList<People> ppl = new ArrayList<>();
            ArrayList<String> output_list = new ArrayList<>();

            while ((s = in.readLine()) != null) {
                ppl.add(new People(s));
                if (!(ppl.get(i).getName().equals("Муравьева"))){
                    output_list.add(s);
                }
                i++;
            }
            in.close();
            pw = new PrintWriter(new FileWriter(table.getAbsoluteFile()));
            int size = output_list.size();
            for(int j = 0; j < size; j++){
                pw.write(output_list.get(j) + "\n");
            }
            pw.close();
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
public static void delete_4() {
        int i = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(table.getAbsoluteFile()));

            String s;
            ArrayList<People> ppl = new ArrayList<>();
            ArrayList<String> output_list = new ArrayList<>();

            while ((s = in.readLine()) != null) {
                ppl.add(new People(s));
                if (!(ppl.get(i).getWeight()==100)){
                    output_list.add(s);
                }
                i++;
            }
            in.close();
            pw = new PrintWriter(new FileWriter(table.getAbsoluteFile()));
            int size = output_list.size();
            for(int j = 0; j < size; j++){
                pw.write(output_list.get(j) + "\n");
            }
            pw.close();
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
public static void display_1() {
        int i = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(table.getAbsoluteFile()));
            String s;
            ArrayList<String> display_list = new ArrayList<>();
            int tmp_index = 0;
            ArrayList<People> ppl = new ArrayList<>();
            while ((s = in.readLine()) != null) {
                ppl.add(new People(s));
                if(true){
                    display_list.add(s);
                }
                i++;
            }
            int size = display_list.size();
            for (int j = 0; j < size; j++) {
                System.out.println(display_list.get(j));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
public static void display_2() {
        int i = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(table.getAbsoluteFile()));
            String s;
            ArrayList<String> display_list = new ArrayList<>();
            int tmp_index = 0;
            ArrayList<People> ppl = new ArrayList<>();
            while ((s = in.readLine()) != null) {
                ppl.add(new People(s));
                if(ppl.get(i).getName()=="Титова"){
                    display_list.add(s);
                }
                i++;
            }
            int size = display_list.size();
            for (int j = 0; j < size; j++) {
                System.out.println(display_list.get(j));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
public static void display_3() {
        int i = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(table.getAbsoluteFile()));
            String s;
            ArrayList<String> display_list = new ArrayList<>();
            int tmp_index = 0;
            ArrayList<People> ppl = new ArrayList<>();
            while ((s = in.readLine()) != null) {
                ppl.add(new People(s));
                if(ppl.get(i).getWeight()==66){
                    display_list.add(s);
                }
                i++;
            }
            int size = display_list.size();
            for (int j = 0; j < size; j++) {
                System.out.println(display_list.get(j));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
 public static void add_2() {
            try {
                pw = new PrintWriter(new FileWriter(table.getAbsoluteFile(), true));
                pw.write("Шипарев 67 150" + "\n" );
                pw.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
    }
public static void display_4() {
        int i = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(table.getAbsoluteFile()));
            String s;
            ArrayList<String> display_list = new ArrayList<>();
            int tmp_index = 0;
            ArrayList<People> ppl = new ArrayList<>();
            while ((s = in.readLine()) != null) {
                ppl.add(new People(s));
                if(ppl.get(i).getHeight()==179){
                    display_list.add(s);
                }
                i++;
            }
            int size = display_list.size();
            for (int j = 0; j < size; j++) {
                System.out.println(display_list.get(j));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
 public static void sort_1() {
        try {
            File table = new File("table.txt");
            BufferedReader in = new BufferedReader(new FileReader(table.getAbsoluteFile()));
            String s;
            ArrayList<People> ppl = new ArrayList<>();

            while ((s = in.readLine()) != null) {
                ppl.add(new People(s));
            }
            Collections.sort(ppl,Comparator.comparing(People::getName).thenComparing(People::getWeight).thenComparing(People::getHeight));
            in.close();
            pw = new PrintWriter(new FileWriter(table.getAbsoluteFile());
             for (People p : ppl) {
             pw.write(p.getName() + "  " + p.getWeight() + "    " + p.getHeight() + "\n");
              }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

}
