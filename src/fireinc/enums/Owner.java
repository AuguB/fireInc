package fireinc.enums;

public enum Owner {
    STIJN("Stijn de Boer"), MANTAS("Mantas Makelis"), RON("Ron Hommelsheim");
    private final String name;

    Owner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
