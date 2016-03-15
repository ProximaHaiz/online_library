package online_lib.beans;

/**
 * Created by Proxima on 14.03.2016.
 */
public class Author {
    private String name;
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Author(String name, long id) {
        this.id=id;

        this.name = name;
    }


}
