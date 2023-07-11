package com.cricket.cricket.model;

import jakarta.persistence.*;

@Entity
@Table(name = "crickets")

public class Cricket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "teamname")
    private String teamname;

    @Column(name = "teammembers")
    private String teammembers;

    @Column(name = "totalmatches")
    private String totalmatches;

    @Column(name = "won")
    private String won;

    @Column(name = "loss")
    private String loss;

    @Column(name = "runrate")
    private String runrate;

    public Cricket() {

    }

    public Cricket(String teamname, String teammembers, String totalmatches, String won, String loss, String runrate) {
        this.teamname = teamname;
        this.teammembers = teammembers;
        this.totalmatches = totalmatches;
        this.won = won;
        this.loss = loss;
        this.runrate = runrate;
    }

    public long getId() {
        return id;
    }

    public String geteamname() {
        return teamname;
    }

    public void setteamname(String teamname) {
        this.teamname = teamname;
    }

    public String geteammembers() {
        return teammembers;
    }

    public void setteammembers(String teammembers) {
        this.teammembers = teammembers;
    }

    public String gettotalmatches() {
        return totalmatches;
    }

    public void settotalmatches(String totalmatches) {
        this.totalmatches = totalmatches;
    }

    public String getwon() {
        return won;

    }

    public void setwon(String won) {
        this.won = won;
    }

    public String getloss() {
        return loss;

    }

    public void setloss(String loss) {
        this.loss = loss;
    }

    public String getrunrate() {
        return runrate;

    }

    public void setrunrate(String runrate) {
        this.runrate = runrate;
    }

    @Override
    public String toString() {
        return "Cricket [id=" + id + ", teamname=" + teamname + ", teammembers=" + teammembers + ", totalmatches=" + totalmatches + ", won=" + won
                + ", loss=" + loss + ", runrate=" + runrate + "]";
    }

}
