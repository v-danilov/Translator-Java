import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    private static File table = new File("table.txt");
    private static File commands = new File("commands.txt");
    private static File code = new File("code.txt");
    private static File call = new File("call.txt");

    private static File add = new File("func/add.txt");
    private static File display = new File("func/display.txt");
    private static File delete = new File("func/delete.txt");
    private static File sort = new File("func/sort.txt");
    private static PrintWriter pw = null;
    private static File main = new File("func/Main.java");


    public static void main(String[] args) {

        int count_add = 0, count_del = 0, count_disp = 0, count_sort = 0;
        int saved_del = 0, saved_disp = 0;
        code.delete();
        main.delete();

        try {
            BufferedReader func_reader = null;
            code.createNewFile();
            main.createNewFile();

            pw = new PrintWriter(new FileWriter(main.getAbsoluteFile()));
            pw.write("import java.io.*;\n" +
                    "import java.util.ArrayList;\n" +
                    "\n" +
                    "import java.util.Collections;\n" +
                            "import java.util.Comparator;" + "\n" +
                    "public class Main {\n" +
                    "\n" +
                    "    private static PrintWriter pw = null;\n" +
                    "    private static File table = new File(\"table.txt\");\n" +
                    "\n" +
                    "    public static void main(String[] args) {\n" +
                    "        @call\n" +
                    "    }\n" +
                    "\n" +
                    "    @func\n" +
                    "}\n");
            pw.close();

            BufferedReader in = new BufferedReader(new FileReader(commands.getAbsoluteFile()));
            String s, command, arguments = "";
            int space_index;
            Boolean uniq_disp = true;
            Boolean uniq_del = true;
            Boolean check = false;

            while ((s = in.readLine()) != null) {
                space_index = s.indexOf(" ");
                arguments = "";

                if (space_index > 0) {
                    command = s.substring(0, space_index);


                    arguments = s.substring(space_index + 1);

                } else {
                    command = s;
                }


                String string_for_reading_func;

                switch (command) {
                    case ("add"):
                        count_add++;

                        String array_args[];
                        array_args = arguments.split(" ");
                        if (array_args.length == 3) {
                            try {
                                Integer.parseInt(array_args[1]);
                                Integer.parseInt(array_args[2]);
                                check = true;
                            } catch (Exception e) {
                                error(004);
                            }
                        } else {
                            error(002);
                        }

                        if (check) {
                            func_reader = new BufferedReader(new FileReader(add.getAbsoluteFile()));
                            pw = new PrintWriter(new FileWriter(code.getAbsoluteFile(), true));
                            while ((string_for_reading_func = func_reader.readLine()) != null) {
                                string_for_reading_func = string_for_reading_func.replaceAll("@i", Integer.toString(count_add));
                                string_for_reading_func = string_for_reading_func.replaceAll("@mark", "\"" + arguments + "\"");
                                pw.write(string_for_reading_func + "\n");
                            }
                            pw.close();
                            pw = new PrintWriter(new FileWriter(call.getAbsoluteFile(), true));
                            pw.write("add_" + count_add + "();" + "//" + arguments + "\n");
                            pw.write("System.out.println(\"added\");" + "\n");
                            pw.close();
                            func_reader.close();
                        }
                        break;
                    case ("delete"):
                        count_del++;
                        func_reader = new BufferedReader(new FileReader(delete.getAbsoluteFile()));
                        pw = new PrintWriter(new FileWriter(code.getAbsoluteFile(), true));

                        if (arguments.isEmpty()) {
                            if (uniq_del) {

                                pw = new PrintWriter(new FileWriter(code.getAbsoluteFile(), true));
                                while ((string_for_reading_func = func_reader.readLine()) != null) {
                                    string_for_reading_func = string_for_reading_func.replaceAll("@mark", "false");
                                    string_for_reading_func = string_for_reading_func.replaceAll("@size", "size - 1");
                                    string_for_reading_func = string_for_reading_func.replaceAll("@i", Integer.toString(count_del));
                                    pw.write(string_for_reading_func + "\n");
                                }
                                pw.close();
                                pw = new PrintWriter(new FileWriter(call.getAbsoluteFile(), true));
                                pw.write("delete_" + count_del + "();" + " //" + arguments + "\n");
                                pw.write("System.out.println(\"deleted\");" + "\n");
                                pw.close();
                                saved_del = count_del;
                                uniq_del = false;
                            } else {
                                pw = new PrintWriter(new FileWriter(call.getAbsoluteFile(), true));
                                pw.write("delete_" + saved_del + "();" + " //" + arguments + "\n");
                                pw.write("System.out.println(\"deleted\");" + "\n");
                                pw.close();
                            }

                        } else {

                            pw = new PrintWriter(new FileWriter(code.getAbsoluteFile(), true));
                            while ((string_for_reading_func = func_reader.readLine()) != null) {
                                if (string_for_reading_func.contains("@mark")) {
                                    String convert_args = arguments.replaceAll("and", "&&");
                                    convert_args = convert_args.replaceAll("or", "||");
                                    if (convert_args.contains("n=")) {
                                        convert_args = wrapper(convert_args);
                                    }

                                    convert_args = convert_args.replaceAll("n=", "ppl.get(i).getName().equals(");
                                    convert_args = convert_args.replaceAll("w=", "ppl.get(i).getWeight()==");
                                    convert_args = convert_args.replaceAll("h=", "ppl.get(i).getHeight()==");


                                    string_for_reading_func = string_for_reading_func.replaceAll("@mark", convert_args);
                                }
                                string_for_reading_func = string_for_reading_func.replaceAll("@size", "size");
                                string_for_reading_func = string_for_reading_func.replaceAll("@i", Integer.toString(count_del));

                                pw.write(string_for_reading_func + "\n");

                            }
                            pw.close();
                            pw = new PrintWriter(new FileWriter(call.getAbsoluteFile(), true));
                            pw.write("delete_" + count_del + "();" + " //" + arguments + "\n");
                            pw.write("System.out.println(\"deleted\");" + "\n");
                            pw.close();
                        }

                        break;
                    case ("display"):
                        count_disp++;
                        func_reader = new BufferedReader(new FileReader(display.getAbsoluteFile()));
                        pw = new PrintWriter(new FileWriter(code.getAbsoluteFile(), true));
                        if (arguments.isEmpty()) {
                            if (uniq_disp) {
                                while ((string_for_reading_func = func_reader.readLine()) != null) {
                                    string_for_reading_func = string_for_reading_func.replaceAll("@mark", "true");
                                    string_for_reading_func = string_for_reading_func.replaceAll("@i", Integer.toString(count_disp));
                                    pw.write(string_for_reading_func + "\n");
                                }
                                pw.close();
                                uniq_disp = false;
                                saved_disp = count_disp;
                                pw = new PrintWriter(new FileWriter(call.getAbsoluteFile(), true));
                                pw.write("display_" + count_disp + "();" + "//" + arguments + "\n");
                                pw.write("System.out.println(\"displayed\");" + "\n");
                                pw.close();


                            } else {
                                pw = new PrintWriter(new FileWriter(call.getAbsoluteFile(), true));
                                pw.write("display_" + saved_disp + "();" + "//" + arguments + "\n");
                                pw.write("System.out.println(\"displayed\");" + "\n");
                                pw.close();
                            }
                        } else {
                            pw = new PrintWriter(new FileWriter(code.getAbsoluteFile(), true));
                            while ((string_for_reading_func = func_reader.readLine()) != null) {
                                if (string_for_reading_func.contains("n=")) {
                                    string_for_reading_func = wrapper(string_for_reading_func);
                                }
                                if (string_for_reading_func.contains("@mark")) {

                                    String convert_args = arguments.replaceAll("and", "&&");
                                    convert_args = convert_args.replaceAll("or", "||");
                                    if(convert_args.contains("n=")){
                                        convert_args = wrapper(convert_args);
                                    }
                                    convert_args = convert_args.replaceAll("n=", "ppl.get(i).getName().equals(");
                                    convert_args = convert_args.replaceAll("w=", "ppl.get(i).getWeight()==");
                                    convert_args = convert_args.replaceAll("h=", "ppl.get(i).getHeight()==");

                                    string_for_reading_func = string_for_reading_func.replaceAll("@mark", convert_args);
                                }
                                string_for_reading_func = string_for_reading_func.replaceAll("@i", Integer.toString(count_disp));
                                pw.write(string_for_reading_func + "\n");
                            }
                            pw.close();
                            pw = new PrintWriter(new FileWriter(call.getAbsoluteFile(), true));
                            pw.write("display_" + count_disp + "();" + "//" + arguments + "\n");
                            pw.write("System.out.println(\"displayed\");" + "\n");
                            pw.close();
                        }

                        break;
                    case ("sort"):
                        count_sort++;
                        try {
                            func_reader = new BufferedReader(new FileReader(sort.getAbsoluteFile()));
                            pw = new PrintWriter(new FileWriter(code.getAbsoluteFile(), true));
                            String array[];
                            String params = "";
                            if (!arguments.isEmpty()) {
                                array = arguments.split(",");
                                for (int i = 0; i < array.length; i++) {
                                    switch (array[i]) {
                                        case ("n"):
                                            if (params.isEmpty()) {
                                                params = "Comparator.comparing(People::getName)";
                                            } else {
                                                params += ".thenComparing(People::getName)";
                                            }
                                            break;
                                        case ("w"):
                                            if (params.isEmpty()) {
                                                params = "Comparator.comparing(People::getWeight)";
                                            } else {
                                                params += ".thenComparing(People::getWeight)";
                                            }
                                            break;
                                        case ("h"):
                                            if (params.isEmpty()) {
                                                params = "Comparator.comparing(People::getHeight)";
                                            } else {
                                                params += ".thenComparing(People::getHeight)";
                                            }
                                            break;
                                        default:
                                            error(001);
                                    }
                                }
                                //params += "\n";
                                while ((string_for_reading_func = func_reader.readLine()) != null) {
                                    string_for_reading_func = string_for_reading_func.replaceAll("@i", Integer.toString(count_sort));
                                    string_for_reading_func = string_for_reading_func.replaceAll("@mark", params);
                                    pw.write(string_for_reading_func + "\n");
                                }
                                pw.close();
                                pw = new PrintWriter(new FileWriter(call.getAbsoluteFile(), true));
                                pw.write("sort_" + count_sort + "();" + "//" + arguments + "\n");
                                pw.write("System.out.println(\"soted\");" + "\n");
                                pw.close();
                            } else {
                                error(004);
                            }
                        } catch (Exception e) {
                        }

                        break;
                    default:
                        error(000);
                }
            }

            ArrayList<String> out_main = new ArrayList<>();
            String func_str = "", call_str = "";
            in = new BufferedReader(new FileReader(code.getAbsoluteFile()));
            while ((s = in.readLine()) != null) {
                func_str += s + "\n";
            }

            in = new BufferedReader(new FileReader(call.getAbsoluteFile()));
            while ((s = in.readLine()) != null) {
                call_str += s + "\n";
            }

            in = new BufferedReader(new FileReader(main.getAbsoluteFile()));
            while ((s = in.readLine()) != null) {
                if (s.contains("@func")) {
                    out_main.add(s.replaceAll("@func", func_str));

                } else {
                    if (s.contains("@call")) {
                        out_main.add(s.replaceAll("@call", call_str));
                    } else {
                        out_main.add(s);
                    }
                }

            }
            in.close();
            pw = new PrintWriter(new FileWriter(main.getAbsoluteFile()));

            for (String anOut_main : out_main) {
                //System.out.println(k + "?" + " ??????: " + out_main.get(k));
                pw.write(anOut_main + "\n");
            }
            pw.close();

        } catch (IOException e) {
            System.err.println("File error!" + e.getMessage());

        }


    }

    public static void error(int e) {
        switch (e) {
            case (000):
                System.err.println("������������ �������������� �������");
                break;
            case (001):
                System.err.println("������������ �������������� ���������");
                break;
            case (002):
                System.err.println("�������� �� ����� ����� ������ ��������");
            case (003):
                System.err.println("������� ����������� ������");
                break;
            case (004):
                System.err.println("��� ������ ��� ���������� ���������� �������");
                break;
        }
    }

    public static String wrapper(String str) {
        int tmp = 0;
        String out = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '"') {
                if (tmp % 2 != 0) {
                    out += str.charAt(i) + ")";
                } else {
                    out += "" + str.charAt(i);
                }
                tmp++;
            } else {
                out += "" + str.charAt(i);
            }

        }
        return out;
    }

    //DISPLAY

    /*public static void display_@i() {
        int i = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(table.getAbsoluteFile()));
            String s;
            ArrayList<String> display_list = new ArrayList<>();
            int tmp_index = 0;
            ArrayList<People> ppl = new ArrayList<>();
            while ((s = in.readLine()) != null) {
                ppl.add(new People(s));
                if(@mark){
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
    }*/

    //ADD

   /*  public static void add_@i() {
            try {
                pw = new PrintWriter(new FileWriter(table.getAbsoluteFile(), true));
                pw.write(@mark + "\\n" );
                pw.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
    }*/


    //DELETE

    /*public static void delete_@i() {
        int i = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(table.getAbsoluteFile()));

            String s;
            ArrayList<People> ppl = new ArrayList<>();
            ArrayList<String> output_list = new ArrayList<>();

            while ((s = in.readLine()) != null) {
                ppl.add(new People(s));
                if (!(@mark)){
                    output_list.add(s);
                }
                i++;
            }
            in.close();
            pw = new PrintWriter(new FileWriter(table.getAbsoluteFile()));
            int size = output_list.size();
            for(int j = 0; j < @size; j++){
                pw.write(output_list.get(j) + "\\n");
            }
            pw.close();
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
    }*/

    public static void sort() {
        try {
            File table = new File("table.txt");
            BufferedReader in = new BufferedReader(new FileReader(table.getAbsoluteFile()));
            String s;
            ArrayList<People> ppl = new ArrayList<>();

            while ((s = in.readLine()) != null) {
                ppl.add(new People(s));
            }
            Collections.sort(ppl, Comparator.comparing(People::getName).thenComparing(People::getWeight));
            for (People p : ppl) {
                System.out.println(p.getName() + "  " + p.getWeight() + "    " + p.getHeight());
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

}

