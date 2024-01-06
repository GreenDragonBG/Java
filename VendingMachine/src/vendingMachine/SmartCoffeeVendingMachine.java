package vendingMachine;

import java.io.Console;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class SmartCoffeeVendingMachine extends CoffeeVendingMachine{
	public static final String notifyFilePath = "Desktop/notification.txt";
	
	public SmartCoffeeVendingMachine(Collection<String> ingredients) {
		super(ingredients);
	}
	
	public void notifySupport(String ingredient) {
		File file = new File(notifyFilePath);
		try(FileWriter fileWriter = new FileWriter(file)){
			fileWriter.write("Ingredient "+ ingredient +" is almost over. Current amount: " + getIngerdientSupply(ingredient));
		}catch(IOException ex){
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public void brewRecipe(Recipe recipe) {
		super.brewRecipe(recipe);
		for (String ingredient : super.containers.keySet()) {
			if(super.containers.get(ingredient)< super.CAPACITY*0.2) {
				notifySupport(ingredient);
			}
		}
	}
}
