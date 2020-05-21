import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@UdfDescription(name = "pid2mfid", description = "PatientId to MedicalFileId")
public class PatientId2MedicalFileId {
    public static final String SALT = "uqtris2020";
    public static final String SHA3_256 = "SHA3-256";

    @Udf(description = "PatientId to MedicalFileId")
    public String pid2mfid(@UdfParameter(value = "patientId") final String patientId) throws NoSuchAlgorithmException {
        System.out.println("----------------------------------------------");
        System.out.println("patientId = "+patientId);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA3-256");

        String result = toHexString(messageDigest.digest(patientId.concat(SALT).getBytes(StandardCharsets.UTF_8)));
        System.out.println("result = "+result);
        return result;
    }
    public static String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }
}
