package repository;
import java.util.List;

import model.Client;

public interface ClientRepository {
    void create(Client client);
    void delete(String uuid);
    List<Client> readAll();
}
