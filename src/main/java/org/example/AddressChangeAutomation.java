package org.example;

import java.util.List;
import java.util.Objects;

public class AddressChangeAutomation {
    private final UsersDataProvider usersDataProvider = new UsersDataProvider();

    public void testAddressCanChangeSuccessfully() {
        // Given
        int id = 5;
        String newPhone = "(254)954-1289";
        String newStreetAddress = "Skiles Walks";

        // When
        changeAddress();

        // Assert
        List<User> users = usersDataProvider.getAllUsers();
        assert users.size() > 0;
        for (User user: users) {
            if (user.id == id) {
                assert Objects.equals(user.address.street, newStreetAddress);
                assert user.phone.equals(newPhone);
            }
        }
    }

    private void changeAddress() {

    }
}
