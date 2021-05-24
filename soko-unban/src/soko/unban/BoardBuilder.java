package soko.unban;

/**
 *
 * @author Victor Josso
 */
public interface BoardBuilder {
    
    
    public void reader(String name, DataBase db);
    public void writer(DataBase db, String[] map);
}
