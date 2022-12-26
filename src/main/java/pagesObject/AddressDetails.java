package pagesObject;

import ActionDriver.Action;
import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressDetails extends BaseClass {
    Action action = new Action();

     public AddressDetails (){
         PageFactory.initElements(driver, this);
     }

    @FindBy(id = "firstname")
    WebElement firstName;

    @FindBy(id = "lastname")
    WebElement LastName;

    @FindBy(id = "company")
    WebElement companyName;

    @FindBy(id = "address1")
    WebElement address;

    @FindBy(id = "city")
    WebElement cityName;

    @FindBy(id = "uniform-id_country")
    WebElement country;

    @FindBy(id = "id_state")
    WebElement stateName;

    @FindBy(id = "postcode")
    WebElement zip;

    @FindBy(id = "phone")
    WebElement homePhone;

    @FindBy(id = "alias")
    WebElement myAddress;

    @FindBy(xpath = "//*[@id='submitAddress']")
    WebElement submitAddress;

    public void setUpAddress(String fName,
                             String lName,
                             String comp,
                             String local,
                             String city,
                             String st,
                             String postal,
                             String count,
                             String num,
                             String myAdd
    ){
        action.type(firstName, fName);
        action.type(LastName, lName);
        action.type(companyName, comp);
        action.type(address, local);
        action.type(cityName, city);
        action.selectByValue(stateName, st);
        action.type(zip, postal);
        action.selectByValue(country,count);
        action.type(homePhone, num);
        action.type(myAddress, myAdd);

    }
    public AddressPage clickOnSaveButton() throws Throwable{
        action.click(driver, submitAddress);
        return new AddressPage();

    }


}
