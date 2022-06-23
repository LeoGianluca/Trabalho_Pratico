package repository;

import model.Sale;

public interface SaleRepository {

	void create(Sale sale);

	void delete();

	void salesForClient(String uuidClient);
}
