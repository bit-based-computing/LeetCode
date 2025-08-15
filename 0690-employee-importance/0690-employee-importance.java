// Definition for Employee.

class Emp{
    public int id;
    public int importance;
    public List<Integer> subordinates;
    Emp(int id, int importance, List<Integer> sub) {
        this.id = id;
        this.importance = importance;
        this.subordinates = sub;
    }
};

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Emp> map = new HashMap<>();
        Queue<Emp> queue = new LinkedList<>();
        for(int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            Emp emp = new Emp(employee.id, employee.importance, employee.subordinates);
            map.put(employee.id, emp);
            if(employee.id == id) queue.add(emp);
        }
        int sum = 0;
        while(!queue.isEmpty()) {
            Emp employee = queue.poll();
            sum += employee.importance;
            for(int i = 0; i < employee.subordinates.size(); i++) {
                queue.add(map.get(employee.subordinates.get(i)));
            }
        }

        return sum;
    }
}