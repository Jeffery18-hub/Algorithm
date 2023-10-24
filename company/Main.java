package company;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /* days between */
        // int[] date1 = new int[]{2010,5,1};
        // int[] date2 = new int[]{2010,8,4};

        // int totalDays = daysBetween.getDaysBetween(date1, date2);

        // LocalDate startDate = LocalDate.of(date1[0], date1[1], date1[2]);
        // LocalDate enDate = LocalDate.of(date2[0], date2[1], date2[2]);
        // long totalDaysSys = ChronoUnit.DAYS.between(startDate, enDate);

        // System.out.println(
        // " date1 : " + date1[0] + "/" + date1[1] + "/" + date1[2] + "\n" +
        // " date2 : " + date2[0] + "/" + date2[1] + "/" + date2[2] + "\n" +
        // " total days between two dates(self define): " + totalDays + "\n" +
        // " total days between two dates(system methods):" + totalDaysSys
        // );

        /* worst trade */
        // Worst_trade worst = new Worst_trade();
        // worst.handleStdIn();

        /* truck postion */
        Server server = new Server();
        Subscriber subscriber = new Subscriber(server);
        List<Client> clients = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int numTrucks = sc.nextInt();
        for (int i = 0; i < numTrucks; i++) {
            TruckPosition pos = new TruckPosition();
            pos.x = sc.nextDouble();
            pos.y = sc.nextDouble();
            server.addPosition(i, pos);
        }

        while (sc.hasNext()) {
            char command = sc.next().charAt(0);
            if (command == 'S') {
                int clientId = sc.nextInt();
                if (clientId >= clients.size()) {
                    clients.add(new Client(clientId, subscriber));
                }
                clients.get(clientId).Subscribe(sc.nextInt());
            } else if (command == 'U') {
                TruckPositionDelta delta = new TruckPositionDelta();
                delta.truckId = sc.nextInt();
                delta.deltaX = sc.nextDouble();
                delta.deltaY = sc.nextDouble();
                server.onUpdate(subscriber, delta);
            } else if (command == 'R') {
                int clientId = sc.nextInt();
                clients.get(clientId).RequestUpdate();
            } else {
                throw new IllegalArgumentException("Invalid input");
            }
        }
    }
}
