package guru.qa.tests;

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

    private String firstName = "Ivan";
    private String lastName = "Ivanov";
    private String userNumber = "8900111111";
    private String userEmail = "ivan@test.com";
    private String userGender = "Male";
    private String month = "March";
    private String year = "1992";
    private String day = "01";
    private String subject = "Maths";
    private String hobby = "Music";
    private String userAddress = "Test address";
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
