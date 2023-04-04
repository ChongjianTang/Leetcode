package leetcode.p3.p399;

import java.util.*;

public class CalcEquation {
    /**
     * 08/27/2022 01:29
     * My approach
     * Build graph and then use DFS to search the path and store the search result for future convenience.
     */
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String node1 = equations.get(i).get(0);
            String node2 = equations.get(i).get(1);
            if (!graph.containsKey(node1)) {
                graph.put(node1, new HashMap<>());
                graph.get(node1).put(node1, 1.0);
            }
            if (!graph.containsKey(node2)) {
                graph.put(node2, new HashMap<>());
                graph.get(node2).put(node2, 1.0);
            }

            graph.get(node1).put(node2, values[i]);
            graph.get(node2).put(node1, 1 / values[i]);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            if (graph.containsKey(query.get(0)) && graph.containsKey(query.get(1))) {
                dfs1(graph, new HashSet<>(), new ArrayList<>(), query.get(0), query.get(1));
                if (graph.containsKey(query.get(0)) && graph.get(query.get(0)).containsKey(query.get(1))) {
                    result[i] = graph.get(query.get(0)).get(query.get(1));
                } else {
                    result[i] = -1;
                }
            } else {
                result[i] = -1;
            }
        }
        return result;
    }

    public static boolean dfs1(Map<String, Map<String, Double>> graph, Set<String> visited, List<String> currentPath, String start, String end) {
        Map<String, Double> neighbors = graph.get(start);
        visited.add(start);
        if (!currentPath.isEmpty()) {
            double val = graph.get(currentPath.get(currentPath.size() - 1)).get(start);
            for (int i = currentPath.size() - 2; i >= 0; i--) {
                String node = currentPath.get(i);
                val = val * graph.get(node).get(currentPath.get(i + 1));
                graph.get(node).put(start, val);
                graph.get(start).put(node, 1 / val);
            }
        }
        if (start.equals(end)) {
            return true;
        }
        currentPath.add(start);
        if (!neighbors.containsKey(end)) {
            Set<String> temp = new HashSet<>(neighbors.keySet());
            for (String neighbor : temp) {
                if (!visited.contains(neighbor)) {
                    if (dfs1(graph, visited, currentPath, neighbor, end)) {
                        return true;
                    }
                }
            }
            currentPath.remove(currentPath.size() - 1);
        } else {
            return dfs1(graph, visited, currentPath, end, end);
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        double[] values;
        List<List<String>> queries = new ArrayList<>();

        values = new double[]{3.0, 0.5, 3.4, 5.6};
        List<String> equation = new ArrayList<>();
        equation.add("x1");
        equation.add("x2");
        equations.add(equation);
        equation = new ArrayList<>();
        equation.add("x2");
        equation.add("x3");
        equations.add(equation);
        equation = new ArrayList<>();
        equation.add("x1");
        equation.add("x4");
        equations.add(equation);
        equation = new ArrayList<>();
        equation.add("x2");
        equation.add("x5");
        equations.add(equation);

        List<String> query = new ArrayList<>();
        query.add("x2");
        query.add("x4");
        queries.add(query);
//        query = new ArrayList<>();
//        query.add("x5");
//        query.add("x2");
//        queries.add(query);
//        query = new ArrayList<>();
//        query.add("x2");
//        query.add("x4");
//        queries.add(query);

        System.out.println(Arrays.toString(calcEquation(equations, values, queries)));

        equations.clear();
        queries.clear();
        values = new double[]{3.0, 4.0, 5.0, 6.0};
        equation = new ArrayList<>();
        equation.add("x1");
        equation.add("x2");
        equations.add(equation);
        equation = new ArrayList<>();
        equation.add("x2");
        equation.add("x3");
        equations.add(equation);
        equation = new ArrayList<>();
        equation.add("x3");
        equation.add("x4");
        equations.add(equation);
        equation = new ArrayList<>();
        equation.add("x4");
        equation.add("x5");
        equations.add(equation);

        query = new ArrayList<>();
        query.add("x1");
        query.add("x5");
        queries.add(query);
        query = new ArrayList<>();
        query.add("x5");
        query.add("x2");
        queries.add(query);
        query = new ArrayList<>();
        query.add("x2");
        query.add("x4");
        queries.add(query);

        System.out.println(Arrays.toString(calcEquation(equations, values, queries)));

        equations.clear();
        queries.clear();
        values = new double[]{2.0, 3.0};
        equation = new ArrayList<>();
        equation.add("a");
        equation.add("b");
        equations.add(equation);
        equation = new ArrayList<>();
        equation.add("b");
        equation.add("c");
        equations.add(equation);

        query = new ArrayList<>();
        query.add("a");
        query.add("c");
        queries.add(query);
        query = new ArrayList<>();
        query.add("b");
        query.add("a");
        queries.add(query);
        query = new ArrayList<>();
        query.add("a");
        query.add("e");
        queries.add(query);
        query = new ArrayList<>();
        query.add("a");
        query.add("a");
        queries.add(query);
        query = new ArrayList<>();
        query.add("x");
        query.add("x");
        queries.add(query);

        System.out.println(Arrays.toString(calcEquation(equations, values, queries)));
    }
}
