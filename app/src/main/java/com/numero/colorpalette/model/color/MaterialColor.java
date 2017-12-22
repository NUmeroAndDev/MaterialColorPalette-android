package com.numero.colorpalette.model.color;

public class MaterialColor {

    private String color50;
    private String color100;
    private String color200;
    private String color300;
    private String color400;
    private String color500;
    private String color600;
    private String color700;
    private String color800;
    private String color900;

    private String colorA100;
    private String colorA200;
    private String colorA400;
    private String colorA700;

    public MaterialColor(String color50,
                         String color100,
                         String color200,
                         String color300,
                         String color400,
                         String color500,
                         String color600,
                         String color700,
                         String color800,
                         String color900,
                         String colorA100,
                         String colorA200,
                         String colorA400,
                         String colorA700) {
        this.color50 = color50;
        this.color100 = color100;
        this.color200 = color200;
        this.color300 = color300;
        this.color400 = color400;
        this.color500 = color500;
        this.color600 = color600;
        this.color700 = color700;
        this.color800 = color800;
        this.color900 = color900;
        this.colorA100 = colorA100;
        this.colorA200 = colorA200;
        this.colorA400 = colorA400;
        this.colorA700 = colorA700;
    }

    public String getColor50() {
        return color50;
    }

    public String getColor100() {
        return color100;
    }

    public String getColor200() {
        return color200;
    }

    public String getColor300() {
        return color300;
    }

    public String getColor400() {
        return color400;
    }

    public String getColor500() {
        return color500;
    }

    public String getColor600() {
        return color600;
    }

    public String getColor700() {
        return color700;
    }

    public String getColor800() {
        return color800;
    }

    public String getColor900() {
        return color900;
    }

    public String getColorA100() {
        return colorA100;
    }

    public String getColorA200() {
        return colorA200;
    }

    public String getColorA400() {
        return colorA400;
    }

    public String getColorA700() {
        return colorA700;
    }
}
