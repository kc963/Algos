import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Recommender {
	
	public static void handler() {
		//Make list of list for data
		List<Integer> recipe1 = new LinkedList<Integer>();
		List<Integer> recipe2 = new LinkedList<Integer>();
		List<Integer> recipe3 = new LinkedList<Integer>();
		List<Integer> recipe4 = new LinkedList<Integer>();
		List<List<Integer>> data = new LinkedList<List<Integer>>();
		
		//Make resources
		int user = 0;
		List<String> recipes = new LinkedList<String>();
		recipes.add("Recipe0");
		recipes.add("Recipe1");
		recipes.add("Recipe2");
		recipes.add("Recipe3");
		
		//Populate lists
		recipe1.add(0);
		recipe1.add(1);
		recipe1.add(2);
		recipe1.add(4);
		recipe2.add(1);
		recipe2.add(3);
		recipe2.add(4);
		recipe3.add(0);
		recipe3.add(2);
		recipe3.add(3);
		recipe4.add(1);
		recipe4.add(2);
		data.add(recipe1);
		data.add(recipe2);
		data.add(recipe3);
		data.add(recipe4);
		
		List<Integer> userRecipes = new LinkedList<Integer>();
		for(int i=0; i<data.size(); i++) {
			if(data.get(i).contains(user)) {
				userRecipes.add(i);
			}
		}
		
		//Call the recommendOnList method to get the results
		List<List<Integer>> sol = recommendOnList(data, userRecipes);
		
		//Display results
		displayResults(sol, recipes);
	}
	
	public static void displayResults(List<List<Integer>> list, List<String> recipes) {
		int len = list.size();
		for(int i=0; i<len; i++) {
			List<Integer> details = list.get(i);
			System.out.println(details.get(1) + "% of the people who like \'" + recipes.get(details.get(2)) + "\' like \'" + recipes.get(details.get(0)) + "\'.");
		}
	}
	
	public static List<Integer> recommendOnRecipe(List<List<Integer>> list, int recipe) {
		int counts[] = new int[list.size()];
		Arrays.fill(counts, 0);
		for(int u : list.get(recipe)) {
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).contains(u)) {
					counts[i]++;
				}
			}
		}
		int max = 0, max_i = 0;;
		for(int i=0; i<counts.length; i++) {
			if(i == recipe) {
				continue;
			}
			if(counts[i] > max) {
				max = counts[i];
				max_i = i;
			}
		}
		List<Integer> details = new LinkedList<Integer>();
		details.add(max_i);
		int percentage = 100*max/list.get(recipe).size();
		details.add(percentage);
		details.add(recipe);
		return details;
	}
	
	//list - sublists has the users who like the recipe at that index in the list.
	//recipes - the list of recipes that the user likes.
	public static List<List<Integer>> recommendOnList(List<List<Integer>> list, List<Integer> user_recipes) {
		List<List<Integer>> solution = new LinkedList<List<Integer>>();
		for(int recipe : user_recipes) {
			List<Integer> details = recommendOnRecipe(list, recipe);
			solution.add(details);
		}
		return solution;
	}
	
	public static void main(String args[]) {
		handler();
	}
}
