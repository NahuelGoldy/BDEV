import model.Client;

import java.io.*;
import java.util.ArrayList;

public class Utils {

    public static ArrayList<Client> readFile(String filename) {
        ArrayList<Client> clients = new ArrayList<>();

        FileInputStream stream = null;
        try {
            stream = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String strLine;
        try {
            while ((strLine = reader.readLine()) != null) {
                String[] parsedLine = strLine.split("\\|");
                clients.add(new Client.Builder(parsedLine[0])
                        .withName(parsedLine[1])
                        .withLastName(parsedLine[2])
                        .withRole(parsedLine[3])
                        .atCountry(parsedLine[4])
                        .inIndustry(parsedLine[5])
                        .withNumberOfRecommendations(Integer.parseInt(parsedLine[6]))
                        .withNumberOfConnections(Integer.parseInt(parsedLine[7]))
                        .build()
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clients;
    }

    public static void writeToFile(String filename, ArrayList<Client> content) {
        File file = new File(filename);
        try (
                final BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(file));
                final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        ) {
            for (Client c : content) {
                writer.write(c.getPersonId());
                writer.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
