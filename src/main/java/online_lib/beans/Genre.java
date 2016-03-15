package online_lib.beans;

/**
 * Created by Proxima on 14.03.2016.
 */
public class Genre {
    private String genreName;
    private long id;

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getGenreName() {
        return genreName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Genre() {
    }


    public Genre(String genreName, long id) {
        this.id = id;
        this.genreName = genreName;
    }

}
