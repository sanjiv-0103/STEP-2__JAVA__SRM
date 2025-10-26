class Tool {
    private String name = "Tool";
    protected String type = "Generic";
    public String use = "Utility";

    public String getName() {
        return name;
    }
}

class Hammer extends Tool {
    public void showAccess() {
        System.out.println(getName());
        System.out.println(type);
        System.out.println(use);
    }
}

public class TestTool {
    public static void main(String[] args) {
        new Hammer().showAccess();
    }
}
