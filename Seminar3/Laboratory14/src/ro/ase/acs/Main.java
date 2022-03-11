package ro.ase.acs;

import ro.ase.acs.nosql.NoSqlDb;
import ro.ase.acs.sql.SqlDb;

public class Main {

    public static void main(String[] args) {
        Database database = new SqlDb();
//        Database database = new NoSqlDb();
        Orchestrator orchestrator = new Orchestrator(database);
        orchestrator.execute();
    }
}
