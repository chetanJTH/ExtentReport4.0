package utils;



public enum Devices {

    Oppo("4SB6QKOZVWZPSCPV","6.0"),
    Asus("K5AAGF00A667MCP","8.0"),
    Sony("RQ3006RCL6", "8.0"),
    SamsungA6("5200a531ee5e3531","8.0"),
    Emulator("Pixel","9"),
    SamsungS6("03157df33b841622", "7.0"),
    SamsungA10("RZ8M422FZJA", "9"),
    Infinix("0328724939000205","9"),
    Redmi("c621a5789906","9"),
    Moto("ZH33L2JWWT","7.1.1"),
    SamsungJ7("330033acecf394bd","8.1"),
    Xiaomi("c2000a3d0105", "9");

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private String version;
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }


    Devices(String name, String version) {
        this.name = name;
        this.version = version;
    }


}
