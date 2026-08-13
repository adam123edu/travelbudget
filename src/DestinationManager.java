import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DestinationManager {

    private List<Destination> destinations = new ArrayList<>();

    public void addDestination(Destination destination) {

        destinations.add(destination);
    }

    public List<Destination> getAllDestinations() {
        return destinations;
    }

    public void removeDestination(int index) {
        destinations.remove(index);
    }

    public double getTotalCost() {
        double total = 0;
        for (Destination destination : destinations) {
            total = total + (destination.getPrice());
        }
        return total;
    }

    public List<Destination> getSortedByPriority() {
        List<Destination> sorted = new ArrayList<>(destinations);
        sorted.sort(Comparator.comparingInt(Destination::getPriority));
        return sorted;
    }

    public List<Destination> getWithinBudget(double budget) {
        List<Destination> affordable = new ArrayList<>();
        for (Destination destination : destinations) {
            if (destination.getPrice() <= budget) {
                affordable.add(destination);
            }
        }
        return affordable;
    }
}
