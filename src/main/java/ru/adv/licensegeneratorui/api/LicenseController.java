package ru.adv.licensegeneratorui.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.adv.licensegeneratorui.coder.Decoder;
import ru.adv.licensegeneratorui.api.dto.LicenseRequest;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LicenseController {
    private final Decoder decoder;

    @PostMapping("/license")
    public Map<String, String> getLicenseFile(@RequestBody LicenseRequest licenseRequest) throws IOException {
        licenseRequest.setCreateData(new Date());
        String json = convertObjectToJSON(licenseRequest);
        String decodeJson = decoder.decodeRSA(json);
        return Map.of("key", decodeJson);
    }

    private static String convertObjectToJSON(LicenseRequest licenseRequest) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(licenseRequest);
    }
}
