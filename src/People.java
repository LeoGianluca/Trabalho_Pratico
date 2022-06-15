import java.util.Scanner;
import java.util.UUID;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class People {
    private String uuid;
    public String name;
    private String document;
    private String password;

    private static final String PATH = "people.txt";

    public People() {}

    public People(String _name, String _document, String _password) {
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

    public String getPassword() {
        return password;
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
            File fFile = null;
            fFile = new File(PATH);
            FileWriter fwFile = null;

            if (fFile.exists()) {
                fwFile = new FileWriter(fFile, true);
            } else {
                fwFile = new FileWriter(fFile);
            }

            BufferedWriter bw = new BufferedWriter(fwFile);

            bw.write(data + "\n");

            bw.close();
            fwFile.close();

            System.out.println("[INFO]: Registro adicionado com sucesso...");

            return true;
        } catch (Exception e) {
            System.out.println("[ERROR]: Falha ao gravar os dados. \n Detalhes: \n" + e.getMessage());

            return false;
        }
    }

    public static void readAllPeople() {
        Scanner readFile = null;

        File file = null;

        try {
            // abrindo o arquivo para leitura
            // se o arquivo nao existir será disparada uma exceção
            file = new File(PATH);
            readFile = new Scanner(file);

            // leia o arquivo linha por linha até chegar ao seu fim
            while (readFile.hasNextLine()) {
                processLines(readFile.nextLine());
            }
        } catch (FileNotFoundException e) { // tratando quando o arquivo nao existe
            System.err.println("[ERROR]: Arquivo não existe " + file);
        }

        readFile.close();
    }

    private static void processLines(String linha) {
        // toda linha do arquivo segue o formato:
        // uuid; name; document; password (que não será exposta)
        if (linha != null) {
            // separando os campos através do delimitador ';'
            String[] campos = linha.split(";");

            System.out.println("UUID \t Documento \t Nome");
            System.out.print("--------------------------------------------------------\n");
            System.out.println(campos[0].trim() + "\t" + campos[2].trim() + "\t" + campos[1].trim());
            System.out.print("--------------------------------------------------------\n");
        }
    }
}