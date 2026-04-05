class EventManager {
    TreeMap<Integer, PriorityQueue<Integer>> map;
    HashMap<Integer, Integer> ev;
    public EventManager(int[][] events) {
        map = new TreeMap<>();
        ev = new HashMap<>();
        for(int[] e : events){
            PriorityQueue<Integer> list = map.getOrDefault(e[1], new PriorityQueue<>((a, b) -> a-b));
            list.offer(e[0]);
            map.put(e[1], list);
            ev.put(e[0], e[1]);
        }
    }
    
    public void updatePriority(int eventId, int newPriority) {
        int oldP = ev.get(eventId);
        PriorityQueue<Integer> list = map.get(oldP);
        list.remove(eventId);
        if(list.isEmpty()) map.remove(oldP);
        PriorityQueue<Integer> temp = map.getOrDefault(newPriority, new PriorityQueue<>((a,b) -> a-b));
        temp.add(eventId);
        map.put(newPriority, temp);
        ev.put(eventId, newPriority);
    }
    
    public int pollHighest() {
        if(map.isEmpty()) return -1;
        int largestP = map.lastKey();
        PriorityQueue<Integer> list = map.lastEntry().getValue();
        if(list.isEmpty()){
            map.remove(largestP);
            return -1;
        }
        int smallest = list.poll();
        if(list.isEmpty()){
            map.remove(largestP);
        }
        ev.remove(smallest);
        return smallest;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */