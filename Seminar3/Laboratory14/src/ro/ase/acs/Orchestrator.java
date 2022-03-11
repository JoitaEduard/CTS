package ro.ase.acs;

public class Orchestrator {
    private Database database;

    public Orchestrator(Database database) {
        this.database = database;
    }

    public void execute() {
        database.createDb();
    }
}