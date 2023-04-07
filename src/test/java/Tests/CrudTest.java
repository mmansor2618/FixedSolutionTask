package Tests;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.CrudPage;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;


public class CrudTest extends TestBase {
    CrudPage crudPage;
    Properties crud;

    @BeforeClass(alwaysRun = true)
    public void initialize() throws IOException {
        crudPage = new CrudPage(driver);
    }

    @Test(testName = "Check The New Recipe Is Appear", priority = 1, enabled = true)
    public void CheckTheNewRecipeIsAppear() {
        driver.get("http://127.0.0.1:5501/");
        String FistRecipeName = prop.getProperty("firstRecipe");
        String FirstIngredient = prop.getProperty("FirstIngredient");
        crudPage.AddNewRecipe(FistRecipeName, FirstIngredient);
        Assert.assertTrue(crudPage.AssertRecipeName(FistRecipeName));
    }

    @Test(testName = "Edit Recipe", priority = 2, enabled = true)

    public void EditRecipe() {
        String FistRecipeName = prop.getProperty("firstRecipe");
        String SecondRecipeName = prop.getProperty("SecondRecipe");
        String SecondIngredient = prop.getProperty("SecondIngredient");
        Assert.assertTrue(crudPage.editRecipeName(FistRecipeName, SecondRecipeName, SecondIngredient));
    }

    @Test(testName = "assert New Ingredient", priority = 3, enabled = true)

    public void assertNewIngredient() {
        String SecondRecipeName = prop.getProperty("SecondRecipe");
        String SecondIngredient = prop.getProperty("SecondIngredient");
        Assert.assertTrue(crudPage.AssertNewIngredientName(SecondRecipeName, SecondIngredient));
    }
    
    @Test(testName = "assert New Ingredient", priority = 4, enabled = true)

    public void DeleteLastRecipe(){
        String SecondRecipeName = prop.getProperty("SecondRecipe");
        Assert.assertTrue(crudPage.DeleteLastRecipe(SecondRecipeName));
    }

}
