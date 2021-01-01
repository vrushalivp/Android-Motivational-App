package com.example.motivationalspeaker;

public class Speaker {
    private String name;

    private int imgid1 = R.drawable.lesbrown;
    private int imgid2 = R.drawable.nickvujicic;

    private String url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRRd7cK3KwVPPTeuj8PrgIYfT1EtZ2grBaDxQ&usqp=CAU";

    public Speaker(){}

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getImgid1() {
        return imgid1;
    }

    public void setImgid1(int imgid1) {
        this.imgid1 = imgid1;
    }

    public int getImgid2() {
        return imgid2;
    }

    public void setImgid2(int imgid2) {
        this.imgid2 = imgid2;
    }

    public Speaker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
