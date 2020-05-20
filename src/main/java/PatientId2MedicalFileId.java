import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;
import org.apache.commons.codec.digest.DigestUtils;

@UdfDescription(name = "pid2mfid", description = "PatientId to MedicalFileId")
public class PatientId2MedicalFileId {
    public static final String SALT = "uqtris2020";
    public static final String SHA3_256 = "SHA3-256";

    @Udf(description = "PatientId to MedicalFileId")
    public String pid2mfid(@UdfParameter(value = "patientId") final String patientId) {
        return new DigestUtils(SHA3_256).digestAsHex(patientId.concat(SALT));
    }
}
