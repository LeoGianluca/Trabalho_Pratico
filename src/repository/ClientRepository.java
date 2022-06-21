package repository;

import model.Client;

public interface ClientRepository {
    void create(Client client);

    void delete();

    void readAll();
}
