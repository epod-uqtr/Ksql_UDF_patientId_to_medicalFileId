
import static org.junit.Assert.*;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

public class PID2MFIDTest {


    @Test
    public void testPid2mfid() throws NoSuchAlgorithmException {
        assertEquals(new PatientId2MedicalFileId()
                        .pid2mfid("b593c27a-d3a6-4eae-97b1-67997b7b212a"),
                "45ca2a0695bf947ec224db5432f7928c804538e4a4fb3548ed438cd54c114def");
    }
}
