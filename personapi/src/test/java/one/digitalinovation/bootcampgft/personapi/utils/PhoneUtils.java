package one.digitalinovation.bootcampgft.personapi.utils;

import one.digitalinovation.bootcampgft.personapi.dto.PhoneDTO;
import one.digitalinovation.bootcampgft.personapi.enums.PhoneTypes;
import one.digitalinovation.bootcampgft.personapi.model.Phone;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "1199999-9999";
    private static final PhoneTypes PHONE_TYPE = PhoneTypes.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .phoneType(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .phoneType(PHONE_TYPE)
                .build();
    }
}
