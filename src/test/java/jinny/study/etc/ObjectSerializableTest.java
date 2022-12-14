package jinny.study.etc;

import jinny.study.domain.Member;
import jinny.study.domain.Member2;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Base64;

public class ObjectSerializableTest {

    @Test
    public void testMemberSerializable() throws IOException {
        Member obj = new Member("1", "kassy", 27);
        String base64Member = serializedString(obj);

        byte[] serializedMember = Base64.getDecoder().decode(base64Member);
        try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedMember)) {
            try (ObjectInputStream ois = new ObjectInputStream(bais)) {
                // 역직렬화된 Member 객체를 읽어온다.
                Object objectMember = ois.readObject();
                Member member = (Member) objectMember;
                System.out.println(member);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String serializedString(Object obj) {
        byte[] serializedMember;

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(obj);
                // serializedMember -> 직렬화된 member 객체
                serializedMember = baos.toByteArray();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Base64.getEncoder().encodeToString(serializedMember);
    }


}
