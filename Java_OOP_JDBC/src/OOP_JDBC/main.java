package OOP_JDBC;

import Module.DB_Handler;
import Module.Json_Handler;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author Quang Sang <quangsang.red@gmail.com>
 */
public class main {

    public static NPC.Npc_Lasname[] mainData;

    public static void main(String[] args) {
        System.out.println("Finally can work with git in Netbeans. Damn it!!!");
        lobby();
    }

    public static void lobby() {
        System.out.print(">_ ");
        Scanner inp = new Scanner(System.in);

        String choice = inp.nextLine();
        switch (choice) {
            case "init" ->
                DB_Handler.createTable();
            case "getjson" -> {
                System.out.print("input file path(blank for default): ");
                Scanner filepath = new Scanner(System.in);
                String path = filepath.nextLine();
                
                if (!isValidPath(path)||path.length()==0) {
                    path = "src/OOP_JDBC/test_data.json";
                }
                
                System.out.println(path);
                mainData = Json_Handler.getLnameJson(path);
                for (NPC.Npc_Lasname data : mainData) {
                    System.out.println(data);
                }
            }
            case "push2db" -> {
                for (NPC.Npc_Lasname data : mainData) {
                    DB_Handler.pushData(data.getId(), data.getGender(), data.getName(), data.getTc(), data.getEn());
                }
            }
            case "exit" ->
                System.exit(0);
            default ->
                throw new AssertionError();
        }
        lobby();
    }

    public static boolean isValidPath(String path) {
        try {
            Paths.get(path);
        } catch (InvalidPathException | NullPointerException ex) {
            return false;
        }
        return true;
    }
}
