public class PersonFactory {

    public static Person createPerson(String[] csvRow) {
        // Create Person With FirstName Last Name and Role
        Role role = Role.valueOf(csvRow[0].toUpperCase());
        String firstName = csvRow[1];
        String lastName = csvRow[2];
        // You can extend this factory to handle more properties as needed
        
        return new Person(role, firstName, lastName);
    }
}
