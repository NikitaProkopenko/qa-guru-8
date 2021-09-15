package guru.qa.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.*;

public class RegistrationForm extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    GenderCheckboxComponent genderCheckboxComponent = new GenderCheckboxComponent();
    CalendarComponent calendarComponent = new CalendarComponent();
    SubjectSelectorComponent subjectSelectorComponent = new SubjectSelectorComponent();
    HobbiesCheckboxComponent hobbiesCheckboxComponent = new HobbiesCheckboxComponent();
    UploadPictureComponent uploadPictureComponent = new UploadPictureComponent();
    StateAndCitySelectorComponent stateAndCitySelectorComponent = new StateAndCitySelectorComponent();
    FormModalComponent formModalComponent = new FormModalComponent();
    Faker faker = new Faker();

    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String userNumber = faker.number().digits(10);
    private String userEmail = faker.internet().emailAddress();
    private String userGender = "Male";
    private String month = "March";
    private String year = "1992";
    private String day = "01";
    private String subject = "Maths";
    private String hobby = "Music";
    private String userAddress = faker.address().fullAddress();
    private String pathToPicture = "img/image.png";
    private String pictureName = "image.png";
    private String state = "NCR";
    private String city = "Delhi";

    @Test
    void submitFormTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmail)
                .typeUserNumber(userNumber)
                .typeUserAddress(userAddress);
        genderCheckboxComponent.chooseGender(userGender);
        calendarComponent.setDate(month, year, day);
        subjectSelectorComponent.chooseSubject(subject);
        hobbiesCheckboxComponent.chooseHobby(hobby);
        uploadPictureComponent.uploadPicture(pathToPicture);
        stateAndCitySelectorComponent.setState(state).setCity(city);
        registrationPage.submitForm();

        formModalComponent.checkModalTitle()
                .checkUserName(firstName + " " + lastName)
                .checkUserEmail(userEmail)
                .checkGender(userGender)
                .checkPhone(userNumber)
                .checkDateOfBirth(day + " " + month + "," + year)
                .checkSubjects(subject)
                .checkHobbies(hobby)
                .checkPicture(pictureName)
                .checkAddress(userAddress)
                .checkStateAndCity(state + " " + city);
    }
}
