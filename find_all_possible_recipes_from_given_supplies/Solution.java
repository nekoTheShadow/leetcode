package find_all_possible_recipes_from_given_supplies;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        this.recipes = IntStream.range(0, recipes.length).boxed().collect(Collectors.toConcurrentMap(i -> recipes[i], i -> ingredients.get(i)));
        this.supplies = Arrays.stream(supplies).collect(Collectors.toSet());
        this.memo = new HashMap<>();
        
        return Arrays.stream(recipes).filter(this::dfs).collect(Collectors.toList());
    }
    
    private Map<String, List<String>> recipes;
    private Set<String> supplies;
    private Map<String, Boolean> memo;
    
    public boolean dfs(String target) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        
        if (supplies.contains(target)) {
            return true;
        }
        
        if (!recipes.containsKey(target)) {
            return false;
        }
        
        memo.put(target, false);
        memo.put(target, recipes.get(target).stream().allMatch(this::dfs));
        return memo.get(target);
    }
    
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findAllRecipes(new String[] {"bread"}, List.of(List.of("yeast","flour")), new String[] {"yeast","flour","corn"}));
        System.out.println(sol.findAllRecipes(new String[] {"bread","sandwich"}, List.of(List.of("yeast","flour"), List.of("bread","meat")), new String[] {"yeast","flour","meat"}));
        System.out.println(sol.findAllRecipes(new String[] {"bread","sandwich","burger"}, List.of(List.of("yeast","flour"), List.of("bread","meat"), List.of("sandwich","meat","bread")), new String[] {"yeast","flour","meat"}));
        System.out.println(sol.findAllRecipes(
                new String[] {"ju","fzjnm","x","e","zpmcz","h","q"}, 
                List.of(List.of("d"),List.of("hveml","f","cpivl"),List.of("cpivl","zpmcz","h","e","fzjnm","ju"),List.of("cpivl","hveml","zpmcz","ju","h"),List.of("h","fzjnm","e","q","x"),List.of("d","hveml","cpivl","q","zpmcz","ju","e","x"),List.of("f","hveml","cpivl")), 
                new String[] {"f","hveml","cpivl","d"}));
    
    }
}
