package ro.ase.acs;

public interface Database {
    public void createDb();

    public void createConnection();

    public void closeConnection();

    public void createEntity();

    public void insertData();

    public void readData();
}
