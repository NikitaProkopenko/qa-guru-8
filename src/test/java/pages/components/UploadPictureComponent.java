package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class UploadPictureComponent {
    public void uploadPicture(String pathToPicture) {
        $("#uploadPicture").uploadFromClasspath(pathToPicture);
    }
}
