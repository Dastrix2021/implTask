import java.util.*;

// Task 2: Find the shortest path in a graph using Dijkstra's algorithm
class ShortestPathTask implements Task {
    private Map<String, Integer> cityIndex;
    private List<List<Edge>> graph;
    private List<String[]> queries; // List of city pairs for queries
    private int cities;

    // Constructor initializes data structures
    public ShortestPathTask() {
        this.cityIndex = new HashMap<>();
        this.graph = new ArrayList<>();
        this.queries = new ArrayList<>();
    }

    @Override
    public void input(Scanner scanner) {
        // Input the number of cities
        System.out.print("Enter the number of cities: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next(); // Clear invalid input
        }
        cities = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        // Input each city and its neighbors
        for (int i = 0; i < cities; i++) {
            System.out.print("Enter city name: ");
            String cityName = scanner.nextLine();
            cityIndex.put(cityName, i);
            graph.add(new ArrayList<>());

            System.out.print("Enter number of neighbors for " + cityName + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear invalid input
            }
            int neighborsCount = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            // Input each neighbor and its cost
            for (int j = 0; j < neighborsCount; j++) {
                System.out.print("Enter neighbor index and cost (e.g., 1 3): ");
                String[] edgeInfo = scanner.nextLine().split(" ");
                int neighbor = Integer.parseInt(edgeInfo[0]) - 1; // Convert to 0-based index
                int cost = Integer.parseInt(edgeInfo[1]);

                // Validate neighbor index
                if (neighbor < 0 || neighbor >= cities) {
                    System.out.println("Error: Neighbor index " + (neighbor + 1) + " is out of range. Please try again.");
                    j--; // Retry this neighbor
                    continue;
                }

                graph.get(i).add(new Edge(neighbor, cost));
            }
        }

        // Input the number of queries (city pairs)
        System.out.print("Enter the number of city pairs to find shortest paths: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next(); // Clear invalid input
        }
        int queriesCount = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        // Input each query
        for (int i = 0; i < queriesCount; i++) {
            System.out.print("Enter source and destination cities (e.g., gdansk warszawa): ");
            String[] citiesPair = scanner.nextLine().split(" ");
            queries.add(citiesPair);
        }
    }

    @Override
    public void solve() {
        // Solve the shortest path for each query
        for (String[] query : queries) {
            String source = query[0];
            String destination = query[1];
            int result = dijkstra(graph, cityIndex.get(source), cityIndex.get(destination), cities);
            System.out.println("Shortest path from " + source + " to " + destination + ": " + result);
        }
    }

    private int dijkstra(List<List<Edge>> graph, int start, int end, int cities) {
        int[] distances = new int[cities];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.cost));
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (current.cost > distances[current.to]) continue;

            for (Edge neighbor : graph.get(current.to)) {
                int newDist = distances[current.to] + neighbor.cost;
                if (newDist < distances[neighbor.to]) {
                    distances[neighbor.to] = newDist;
                    pq.add(new Edge(neighbor.to, newDist));
                }
            }
        }

        return distances[end];
    }

    // Inner class representing a graph edge
    static class Edge {
        int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
