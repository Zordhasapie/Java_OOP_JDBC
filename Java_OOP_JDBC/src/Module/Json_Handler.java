package Module;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author Quang Sang <quangsang.red@gmail.com>
 */
public class Json_Handler {

    public static NPC.Npc_Lasname[] getLnameJson(String filename) {
        NPC.Npc_Lasname[] data = null;
        try ( Reader reader = new FileReader(filename)) {

            Gson gson = new Gson();
            data = gson.fromJson(reader, NPC.Npc_Lasname[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}
