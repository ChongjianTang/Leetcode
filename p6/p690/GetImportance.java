package leetcode.p6.p690;

import java.util.HashMap;
import java.util.List;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

public class GetImportance {
    /**
     * My approach
     * Searching is costly
     */
    public int getImportance1(List<Employee> employees, int id) {
        int importance = 0;
        for (Employee employee : employees) {
            if (employee.id == id) {
                importance += employee.importance;
                for (int subordinatesId : employee.subordinates) {
                    importance += getImportance1(employees, subordinatesId);
                }
            }
        }
        return importance;
    }

    /**
     * HashMap
     */
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(map, id);
    }

    public int dfs(HashMap<Integer, Employee> map, int id) {
        Employee employee = map.get(id);
        int importance = employee.importance;
        for (int subordinatesId : employee.subordinates) {
            importance += dfs(map, subordinatesId);
        }
        return importance;
    }
}
