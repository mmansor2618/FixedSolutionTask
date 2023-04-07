package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CrudPage extends PageBase {
    public CrudPage(WebDriver driver) {
        super(driver);
    }

    private final By CreateBtn = By.xpath("//button[text()='Add Recipe']");
    private final By RecipeNameTxtBox = By.xpath("//input[@placeholder='Recipe Name']");
    private final By IngredientTxtBox = By.xpath("//textarea[contains(@placeholder,'Enter Ingredients')]");
    private final By CreateBtnFromPopUp = By.xpath("(//button[text()='Add Recipe'])[last()]");
    private final By EditBtn = By.xpath("(//button[text()='Edit'])[last()]");
    private final By confirmEditBtn= By.xpath("//button[text()='Edit Recipe']");
    private final By DeleteBtn = By.xpath("(//button[text()='Delete'])[last()]");
    private final int x =9;
    
    public void ClickOnCreate(){
        clickButton(getElement(CreateBtn));
    }

    public void AddNewRecipe(String RecipeName, String FirstIngredient){
    	ClickOnCreate();
        setText(getElement(RecipeNameTxtBox),RecipeName);
        setText(getElement(IngredientTxtBox),FirstIngredient);
        clickButton(getElement(CreateBtnFromPopUp));
        //x=8;
    }
    public Boolean AssertRecipeName(String ReciepName){
      By  ReciepNameObj= By.xpath("//a[text()='"+ReciepName+"']");
        return isElementAppear(getElement(ReciepNameObj));

    }
    public Boolean editRecipeName(String RecipeNameOld,String RecipeNameNew,String NewEngiredient){
        By ReciepName= By.xpath("//a[text()='"+RecipeNameOld+"']");
        clickButton(getElement(ReciepName));
        clickButton(getElement(EditBtn));
        clearAndSetText(getElement(RecipeNameTxtBox),RecipeNameNew);
        clearAndSetText(getElement(IngredientTxtBox),NewEngiredient);
        clickButton(getElement(confirmEditBtn));
        ReciepName = By.xpath("//a[text()='"+RecipeNameNew+"']");
        return isElementAppear(getElement(ReciepName));

    }
    public Boolean AssertNewIngredientName(String RecipeNameNew,String NewEngiredient){
        By ReciepName= By.xpath("//a[text()='"+RecipeNameNew+"']");
        clickButton(getElement(ReciepName));
        By IngeredientName = By.xpath("//li[text()='"+NewEngiredient+"']");
        return isElementAppear(getElement(IngeredientName));
    }
    
    public Boolean DeleteLastRecipe(String RecipeName){
        clickButton(getElement(DeleteBtn));
        By ReciepName= By.xpath("//a[text()='"+RecipeName+"']");
        return isElementNotExist(ReciepName);

    }


}
