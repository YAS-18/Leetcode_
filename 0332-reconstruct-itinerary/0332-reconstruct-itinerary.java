class Solution {
    List<String> ans  = new ArrayList<>();
    Map<String , PriorityQueue<String>>map = new HashMap<>();

    void dfs(String currAirport) {
      while(map.containsKey(currAirport) && !map.get(currAirport).isEmpty())
      {
        dfs(map.get(currAirport).poll());  
      }

       ans.add(0 , currAirport);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
      for(List<String> ticket : tickets){
        map.computeIfAbsent(ticket.get(0),k->new PriorityQueue<>())
           .add(ticket.get(1));
      }

      //System.out.println(map);

      dfs("JFK");

      return ans;
    }
}