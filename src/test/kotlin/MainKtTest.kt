import junit.framework.Assert.assertEquals
import org.junit.Test

class MainKtTest {


    @Test
    fun calculationCommission_VkPay() {
        // arrange
        val cardType = "VK Pay"
        val amountOfPreviousTransfersM = 0
        val transferNow = 200

        //act
        val result = calculationCommission(
            cardType = cardType,
            amountOfPreviousTransfersM = amountOfPreviousTransfersM,
            transferNow = transferNow
        )

        //assert
        assertEquals(0.0, result)
    }

    @Test
    fun calculationCommission_MastercardAddComission() {
        //assert
        assertEquals(21.8, calculationCommission(
            cardType = "Masterkard",
            amountOfPreviousTransfersM = 0,
            transferNow = 300
        ))
    }

    @Test
    fun calculationCommission_MastercardNotComission() {
        assertEquals(0.0, calculationCommission(
            cardType = "Masterkard",
            amountOfPreviousTransfersM = 350,
            transferNow = 320
        ))
    }

    @Test
    fun calculationCommission_MaestroAddComission() {
        //assert
        assertEquals(21.8, calculationCommission(
            cardType = "Maestro",
            amountOfPreviousTransfersM = 0,
            transferNow = 300
        ))
    }

    @Test
    fun calculationCommission_MaestrodNotComission() {
        assertEquals(0.0, calculationCommission(
            cardType = "Maestro",
            amountOfPreviousTransfersM = 350,
            transferNow = 320
        ))
    }

    @Test
    fun calculationCommission_VisaMinComission() {
        assertEquals(35.0, calculationCommission(
            cardType = "Visa",
            amountOfPreviousTransfersM = 350,
            transferNow = 320
        ))
    }

    @Test
    fun calculationCommission_VisaComission() {
        assertEquals(112.5, calculationCommission(
            cardType = "Visa",
            amountOfPreviousTransfersM = 350,
            transferNow = 15000
        ))
    }

    @Test
    fun calculationCommission_MirMinComission() {
        assertEquals(35.0, calculationCommission(
            cardType = "??????",
            amountOfPreviousTransfersM = 350,
            transferNow = 320
        ))
    }

    @Test
    fun calculationCommission_MirComission() {
        assertEquals(112.5, calculationCommission(
            cardType = "??????",
            amountOfPreviousTransfersM = 350,
            transferNow = 15000
        ))
    }

    @Test
    fun calculatingTheLimit_VklimitExceeded() {
        assertEquals("?????????? ????????????????", calculatingTheLimit(
            cardType = "VK Pay",
            amountOfPreviousTransfersM = 50000,
            transferNow = 1000
        ))
    }

    @Test
    fun calculatingTheLimit_VkNotlimitExceeded() {
        assertEquals("?????????? ???? ????????????????", calculatingTheLimit(
            cardType = "VK Pay",
            amountOfPreviousTransfersM = 5000,
            transferNow = 1000
        ))
    }

    @Test
    fun calculatingTheLimit_VisaCardlimitExceeded() {
        assertEquals("?????????? ????????????????", calculatingTheLimit(
            cardType = "Visa",
            amountOfPreviousTransfersM = 1_500_000,
            transferNow = 15_000
        ))
    }

    @Test
    fun calculatingTheLimit_VisaCardNotlimitExceeded() {
        assertEquals("?????????? ???? ????????????????", calculatingTheLimit(
            cardType = "Visa",
            amountOfPreviousTransfersM = 15_000,
            transferNow = 15_000
        ))
    }

    @Test
    fun calculatingTheLimit_MastercardlimitExceeded() {
        assertEquals("?????????? ????????????????", calculatingTheLimit(
            cardType = "Masterkard",
            amountOfPreviousTransfersM = 1_500_000,
            transferNow = 15_000
        ))
    }

    @Test
    fun calculatingTheLimit_MasterkardNotlimitExceeded() {
        assertEquals("?????????? ???? ????????????????", calculatingTheLimit(
            cardType = "Masterkard",
            amountOfPreviousTransfersM = 15_000,
            transferNow = 15_000
        ))
    }

    @Test
    fun calculatingTheLimit_MaestroCardlimitExceeded() {
        assertEquals("?????????? ????????????????", calculatingTheLimit(
            cardType = "Maestro",
            amountOfPreviousTransfersM = 1_500_000,
            transferNow = 15_000
        ))
    }

    @Test
    fun calculatingTheLimit_MaestroCardNotlimitExceeded() {
        assertEquals("?????????? ???? ????????????????", calculatingTheLimit(
            cardType = "Maestro",
            amountOfPreviousTransfersM = 15_000,
            transferNow = 15_000
        ))
    }

    @Test
    fun calculatingTheLimit_MirCardlimitExceeded() {
        assertEquals("?????????? ????????????????", calculatingTheLimit(
            cardType = "??????",
            amountOfPreviousTransfersM = 1_500_000,
            transferNow = 15_000
        ))
    }

    @Test
    fun calculatingTheLimit_MirCardNotlimitExceeded() {
        assertEquals("?????????? ???? ????????????????", calculatingTheLimit(
            cardType = "??????",
            amountOfPreviousTransfersM = 15_000,
            transferNow = 15_000
        ))
    }

}