package helpers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Archive {
    public String[] readFile(String path) throws IOException {
        List<String> lines = new ArrayList<String>();
        String line;

        InputStream flux = new FileInputStream(path);
        InputStreamReader lecture = new InputStreamReader(flux);

        try (BufferedReader buff = new BufferedReader(lecture)) {
            line = buff.readLine();

            while (line != null && !line.isEmpty()) {
                lines.add(line);
                line = buff.readLine();
            }
        }

        String[] data = lines.toArray(new String[]{});

        flux.close();
        return data;
    }

    public void writeFile(String path, String field) {
        try {
            File fFile = null;
            fFile = new File(path);
            FileWriter fwFile = null;

            if (fFile.exists()) {
                fwFile = new FileWriter(fFile, true);
            } else {
                fwFile = new FileWriter(fFile);
            }

            BufferedWriter bw = new BufferedWriter(fwFile);

            bw.write(field + " \n");

            bw.close();
            fwFile.close();

            System.out.println("[INFO]: Registro adicionado com sucesso...");
        } catch (Exception e) {
            System.out.println("[ERROR]: Falha ao gravar os dados. \n Detalhes: \n" + e.getMessage());
        }
    }
}