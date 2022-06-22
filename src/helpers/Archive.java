package helpers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Archive {
    public String[] readFile(String path) throws IOException {
        InputStream flux = new FileInputStream(path);
        InputStreamReader lecture = new InputStreamReader(flux);

        List<String> lines = new ArrayList<>();
        try (BufferedReader buff = new BufferedReader(lecture)) {
            String line = buff.readLine();

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
            FileWriter fwFile;

            File fFile = new File(path);

            if (fFile.exists()) {
                fwFile = new FileWriter(fFile, true);
            } else {
                fwFile = new FileWriter(fFile);
            }

            BufferedWriter bw = new BufferedWriter(fwFile);

            bw.write(field);

            bw.close();
            fwFile.close();

            System.out.println("[INFO]: Registro adicionado com sucesso...");
        } catch (Exception e) {
            System.out.println("[ERROR]: Falha ao gravar os dados. \n Detalhes: \n" + e.getMessage());
        }
    }
}