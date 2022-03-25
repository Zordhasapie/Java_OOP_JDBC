/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NPC;

/**
 *
 * @author sangv
 */
public class Npc_Lasname {

    public int id;
    public int gender;
    public String name;
    public String tc;
    public String en;

    public Npc_Lasname(int id, int gender, String name, String tc, String en) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.tc = tc;
        this.en = en;
    }

    public String getEn() {
        return en;
    }

    public int getGender() {
        return gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTc() {
        return tc;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

@Override
public String toString(){
    return Integer.toString(id)+": "+ Integer.toString(gender)+";"+name+";"+tc+";"+en;
}
    
}
