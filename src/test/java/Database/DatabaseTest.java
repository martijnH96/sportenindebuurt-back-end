package Database;

import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

public class DatabaseTest {
	Database testDB;
	public final ExpectedException exception = ExpectedException.none();

	public void setup(){
		testDB = new Database();
	}
}