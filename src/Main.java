import model.Client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        ArrayList<Client> clients = Utils.readFile("src/resources/people.in");

        clients.sort(
                Comparator.comparing(Client::isPotentialTarget)
                        .thenComparing(Client::getNumberOfConnections)
                        .thenComparing(Client::getNumberOfRecommendations)
        );

        ArrayList<Client> top100clients = new ArrayList<>();
        top100clients.addAll(clients.subList(clients.size()-101, clients.size()-1));
        Collections.reverse(top100clients);

        Utils.writeToFile("src/resources/people.out", top100clients);
    }

}
