package homework;

import homework.tag.GroupTagType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.HappyNumber;

@Tags({@Tag(GroupTagType.NEGATIVE_TAG), @Tag(GroupTagType.POSITIVE_TAG), @Tag(GroupTagType.EXCAPTION_TAG)})
class JunitTests {

    @Test
    @DisplayName("Ticket isn't happy")
    @Tag(GroupTagType.NEGATIVE_TAG)
    void testNegative1Case() {
        //Arrange

        //Act
        HappyNumber happyNumber = new HappyNumber();


        //Assert

        Assertions.assertEquals(happyNumber.happyNumberFunc("123456"), "false");
    }

    @Test
    @DisplayName("Ticket isn't happy")
    @Tag(GroupTagType.NEGATIVE_TAG)
    void testNegative2Case() {
        //Arrange

        //Act
        HappyNumber happyNumber = new HappyNumber();


        //Assert
        Assertions.assertEquals(happyNumber.happyNumberFunc("000001"), "false");
    }

    @Test
    @DisplayName("Ticket isn't happy")
    @Tag(GroupTagType.NEGATIVE_TAG)
    void testNegative3Case() {
        //Arrange

        //Act
        HappyNumber happyNumber = new HappyNumber();


        //Assert
        Assertions.assertEquals(happyNumber.happyNumberFunc("987001"), "false");
    }

    @Test
    @DisplayName("Ticket is happy")
    @Tag(GroupTagType.POSITIVE_TAG)
    void testPositive1Case() {
        //Arrange

        //Act
        HappyNumber happyNumber = new HappyNumber();

        //Assert
        Assertions.assertEquals(happyNumber.happyNumberFunc("123123"), "true");

    }

    @Test
    @DisplayName("Ticket is happy")
    @Tag(GroupTagType.POSITIVE_TAG)
    void testPositive2Case() {
        //Arrange

        //Act
        HappyNumber happyNumber = new HappyNumber();

        //Assert
        Assertions.assertEquals(happyNumber.happyNumberFunc("715814"), "true");

    }

    @Test
    @DisplayName("Ticket is happy")
    @Tag(GroupTagType.POSITIVE_TAG)
    void testPositive3Case() {
        //Arrange

        //Act
        HappyNumber happyNumber = new HappyNumber();

        //Assert
        Assertions.assertEquals(happyNumber.happyNumberFunc("000000"), "true");

    }

    @Test
    @DisplayName("Exception, if the number of digits is smaller than 6")
    @Tag(GroupTagType.EXCAPTION_TAG)
    void testException1Case() {
        //Arrange

        //Act
        HappyNumber happyNumber = new HappyNumber();


        //Assert
        try {
            happyNumber.happyNumberFunc("123");
        } catch (RuntimeException e) {
            Assertions.assertEquals(e.getMessage(), "Введён неправильный номер билета");
        }
    }


    @Test
    @DisplayName("Exception, if the number of digits is bigger than 6")
    @Tag(GroupTagType.EXCAPTION_TAG)
    void testException2Case() {
        //Arrange

        //Act
        HappyNumber happyNumber = new HappyNumber();


        //Assert
        try {
            happyNumber.happyNumberFunc("1234567");
        } catch (RuntimeException e) {
            Assertions.assertEquals(e.getMessage(), "Введён неправильный номер билета");
        }
    }
}
