import com.bridgelabz.AddressBookDB;
import com.bridgelabz.Contacts;
import com.bridgelabz.IOFile;
import com.bridgelabz.Operations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DBTest {

	@Test
	public void givenAddressBook_WhenDataAddedInTextFile_ShouldReturnTrue(){
		Assertions.assertTrue(IOFile.writingFile(Operations.hashmap));
	}
	@Test
	public void givenAddressBook_WhenReadTextFileData_ShouldReturnTrue (){
		Assertions.assertTrue(IOFile.readFromFile());
	}
	@Test
	public void givenAddressBookInDB_WhenRetrieved_ShouldMatchContactCount()  {
		List<Contacts> employeeData= AddressBookDB.readData();
		for(Contacts data:employeeData){
			System.out.println(data);
		}
		Assertions.assertEquals(4,employeeData.size());
	}
}

