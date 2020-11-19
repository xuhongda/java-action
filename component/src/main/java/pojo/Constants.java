package pojo;

/**
 * @author xuhongda on 2020/11/19
 * pojo
 * java-action
 */
public enum Constants {
    /**
     *  me
     */
    ME("me","xuhongda");

    private String name;

    private String value;

    Constants(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
