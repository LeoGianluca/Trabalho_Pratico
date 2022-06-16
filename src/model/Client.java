package model;

import java.util.UUID;

/**
 * Entidade para representação do cliente no sistema.
 */
public class Client {
    private String uuid;
    private String name;
    private String document;

    public Client(String _name, String _document) {
        this.uuid = UUID.randomUUID().toString();
        this.name = _name;
        this.document = _document;
    }

    public Client(String _uuid, String _name, String _document) {
        this.uuid = _uuid;
        this.name = _name;
        this.document = _document;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String toString() {
        return this.uuid + "\t" + this.name + "\t" + this.document;
    }
}
