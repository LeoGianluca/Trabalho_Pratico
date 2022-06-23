package model;

import java.util.UUID;

public class Sale {
	private String uuid;
	private String uuidClient;
	private String uuidGame;

	public Sale(String _uuidClient, String _uuidGame) {
		this.uuid = UUID.randomUUID().toString();
		this.uuidClient = _uuidClient;
		this.uuidGame = _uuidGame;
	}

	public Sale(String _uuid, String _uuidClient, String _uuidGame) {
		this.uuid = _uuid;
		this.uuidClient = _uuidClient;
		this.uuidGame = _uuidGame;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUuidClient() {
		return uuidClient;
	}

	public void setUuidClient(String uuidClient) {
		this.uuidClient = uuidClient;
	}

	public String getUuidGame() {
		return uuidGame;
	}

	public void setUuidGame(String uuidGame) {
		this.uuidGame = uuidGame;
	}

	public String toString() {
		return this.uuid + "\t";
	}
}
