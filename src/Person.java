import java.util.UUID;
import java.io.File;
import java.io.FileWriter;

public class Person {
    private String uuid;
    public String name;
    private String document;
    private String password;

    public String getPassword() {
        return password;
    }

    private static final String PATH = "people.txt";

    public Person(String _name, String _document, String _password) {
        this.name = _name;
        this.document = _document;
        this.password = _password;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) throws Exception {
        if (name.length() > 0) {
            throw new Exception("[ERROR] Nome não pode ser vazio");
        }

        return this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public String setDocument(String document) throws Exception {
        if (document.length() > 0) {
            throw new Exception("[ERROR] Documento não pode ser vazio");
        }

        return this.document = document;
    }

    public String setPassword(String password) throws Exception {
        if (document.length() > 0) {
            throw new Exception("[ERROR] Senha não pode ser vazio");
        }

        return this.password = password;
    }
    
    public boolean register(String name, String document, String password) throws Exception {
        System.out.println("[INFO]: Registrando pessoa...");

        uuid = UUID.randomUUID().toString();
        name = setName(name);
        document = setDocument(document);
        password = setPassword(password);

        boolean fileSuccess = writeFile(PATH, uuid + ";" + name + ";" + document + ";" + password + "\n");

        if (fileSuccess) {
            System.out.println("[INFO]: Pessoa registrada com sucesso!");
            return true;
        } else {
            System.out.println("[ERROR]: Não foi possível registrar a pessoa!");
            return false;
        }
    }

    private static boolean writeFile(String path, String data) throws Exception {
        try {
            File file = new File("people.txt");

            if (file.isFile()) {
                //TODO IMPLEMENT ME
            } else {
                FileWriter writer = new FileWriter("people.txt");

                writer.append(data);

                writer.close();
            }

            return true;
        } catch (Exception e) {
            System.out.println("[ERROR]: Falha ao gravar os dados. \n Detalhes: \n" + e.getMessage());

            return false;
        }
    }
}