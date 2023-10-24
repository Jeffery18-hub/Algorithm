/* optiver truck position */
package company;

import java.text.DecimalFormat;
import java.util.*;

// Data class for Truck Position
class TruckPosition {
    public double x;
    public double y;
}

// Data class for Truck Position Delta
class TruckPositionDelta {
    public int truckId;
    public double deltaX;
    public double deltaY;
}

class Subscriber {
    private final Server server;
    private HashMap<Integer, List<Integer>> subscribers; // truckId as key, list of clientId as values
    private HashMap<Integer, List<TruckPositionDelta>> updates; // client id as key. list of delta as values

    public Subscriber(Server server) {
        this.server = server;
        this.subscribers = new HashMap<>();
        this.updates = new HashMap<>();
    }

    public void processUpdate(final TruckPositionDelta update) {
        int truckId = update.truckId;
        List<Integer> subscribeToTruck = subscribers.get(truckId);
        for(int clientId : subscribeToTruck) {
            if(updates.containsKey(clientId)) updates.get(clientId).add(update);
            else {
                List<TruckPositionDelta> list  = new ArrayList<>();
                list.add(update);
                updates.put(clientId, list);
            }
        }
    }

    public TruckPosition subscribeToTruck(int truckId, int clientId) {
        TruckPosition posFromServer = this.server.subscribeToTruck(truckId);
        if(subscribers.containsKey(truckId)) {
            subscribers.get(truckId).add(clientId);
        }else {
            List<Integer> newList = new ArrayList<>();
            newList.add(clientId);
            subscribers.put(truckId, newList);
        }

        return posFromServer;
    }

    public List<TruckPositionDelta> getUpdates(int clientId) {
        return updates.get(clientId);
    }
}

class Server {
    private Set<Integer> registeredTrucks;
    private Map<Integer, TruckPosition> currentPos;

    public Server() {
        registeredTrucks = new HashSet<>();
        currentPos = new HashMap<>();
    }

    public TruckPosition subscribeToTruck(int truckId) {
        registeredTrucks.add(truckId);
        TruckPosition pos = currentPos.get(truckId);
        TruckPosition copy = new TruckPosition();
        copy.x = pos.x;
        copy.y = pos.y;
        return copy;
    }

    public void addPosition(int truckId, TruckPosition pos) {
        currentPos.put(truckId, pos);
    }

    public void onUpdate(Subscriber subscriber, final TruckPositionDelta delta) {
        if (registeredTrucks.contains(delta.truckId)) {
            subscriber.processUpdate(delta);
        }
        TruckPosition pos = currentPos.get(delta.truckId);
        pos.x += delta.deltaX;
        pos.y += delta.deltaY;
    }
}

class Client {
    private final int clientId;
    private final Subscriber subscriber;
    private final DecimalFormat format;

    public Client(int clientId, Subscriber subscriber) {
        this.clientId = clientId;
        this.subscriber = subscriber;
        this.format = new DecimalFormat("0.#");
    }

    public void Subscribe(int truckId) {
        TruckPosition pos = subscriber.subscribeToTruck(truckId, clientId);
        System.out.println("S " + clientId + " " + truckId + " " + format.format(pos.x) + " " + format.format(pos.y));
    }

    public void RequestUpdate() {
        List<TruckPositionDelta> updates = subscriber.getUpdates(clientId);
        for (final TruckPositionDelta delta : updates) {
            System.out.println("U " + clientId + " " + delta.truckId + " " + format.format(delta.deltaX) + " " + format.format(delta.deltaY));
        }
    }
}