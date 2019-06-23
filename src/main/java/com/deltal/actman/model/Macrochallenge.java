package com.deltal.actman.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Macrochallenge implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long macroid;

    @Column
    private String macrotitle;
    @Column
    private String macrodescription;
    @Column
    private String macrocoordinator;

    public long getMacroid() {
        return macroid;
    }

    public void setMacroid(long macroid) {
        this.macroid = macroid;
    }

    public String getMacrotitle() {
        return macrotitle;
    }

    public void setMacrotitle(String macrotitle) {
        this.macrotitle = macrotitle;
    }

    public String getMacrodescription() {
        return macrodescription;
    }

    public void setMacrodescription(String macrodescription) {
        this.macrodescription = macrodescription;
    }

    public String getMacrocoordinator() {
        return macrocoordinator;
    }

    public void setMacrocoordinator(String macrocoordinator) {
        this.macrocoordinator = macrocoordinator;
    }
}
